package com.mia.miablog;

import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mia.miablog.dao.UserDAO;
import com.mia.miablog.vo.UserVO;

/**
 * Handles requests for the application home page.
 */
@Controller
//세션의 이름으로 쓸 값들을 어노테이션과 함께 선언
//@SessionAttributes는 항상 클래스 상단에 위치하며 해당 어노테이션이 붙은 컨트롤러는 @SessionAttributes("세션명")에서 지정하고 있는 "세션명"을 @RequestMapping으로 설정한 모든 뷰에서 공유하고 있어야 한다는 규칙을 갖고 있다.
@SessionAttributes({"sessionUserName","sessionEmail"})
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UserDAO userDAO;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/admin/login/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		return "admin/login/login";
	}
	
	//입력값 검증은 프론트단에서 하는 게 나을듯,,,
	@RequestMapping(value = "/admin/login/loginDo", method = RequestMethod.POST)
	public String loginDo(@RequestParam("userId") String userId, @RequestParam("userPwd") String userPwd, Locale locale, Model model) {
		
		//id나 pwd 값 중 하나라도 들어오지 않은경우 로그인 화면으로 
		if(userPwd.equals("") || userId.equals("")){
			return "redirect:/admin/login/login";
		}else {
			//받아온 파라미터값을 토대로 해당 정보가 DB의 정보와 일치하는지 확인 
			UserVO userVO = new UserVO();
			userVO.setuserId(userId);
			userVO.setuserPwd(userPwd);
			
			UserVO returnUserVO = userDAO.selectByUserId(userVO);
			//값은 입력되었으나 일치하는 값이 없는 경우 로그인 화면으로
			if(returnUserVO == null) {
				return "redirect:/admin/login/login";
			}else {
				if(returnUserVO.getuserPwd().equals(userPwd) && returnUserVO.getuserId().equals(userId)) {
					//db의 정보와 비교해 아이디-패스워드 정보가 일치할 경우 세션에 유저 이름 저장
					model.addAttribute("sessionUserName", returnUserVO.getuserName()); 
				}else {
					//틀린 경우 로그인 화면으로 돌아가기 
					return "redirect:/admin/login/login";
				}
				return "redirect:/admin/board/list";
			}
		}
	}
	
	@RequestMapping(value="/admin/login/logout", method=RequestMethod.GET)
	//@modelAttribute 대신 sessionAttribute 태그를 달고 require 속성을 false로 넣으면해당 메써드에서는 세션값이 없더라도 오류 나지 않음. 초기 로그인 페이지 등에서 이렇게 활용하면 됨 
	public String logout(@SessionAttribute(required=false, value= "sessionUserName") String sessionUserName, Locale locale, Model model) {
		model.addAttribute("sessionUserName", "");
		return "redirect:/admin/login/login";
	}
}

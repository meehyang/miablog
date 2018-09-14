package com.mia.miablog;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mia.miablog.dao.UserDAO;
import com.mia.miablog.vo.UserVO;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes({"sessionUserName", "sessionUserIdx"})
public class UserController {
	
	@Autowired
	private UserDAO userDAO = new UserDAO();
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	//requestMapping의 value값 안에 들어가는 값이 웹브라우저에서 접속하는 주소. 이 주소로 접속하면 home 메써드가 실행됨 
	@RequestMapping(value = "/admin/user/list", method = RequestMethod.GET)
	public String list(Locale locale, Model model, HttpSession session) {
		//세션값이 없는 경우 로그인 화면으로 
		if(session.getAttribute("sessionUserName")==null || session.getAttribute("sessionUserName").equals("") || session.getAttribute("sessionUserIdx")==null || session.getAttribute("sessionUserIdx").equals("")) {
			return "redirect:/admin/login/login";
		}
		
		//DAO에서 selectList 값 가져오기 
		List<UserVO> userList = userDAO.selectList();
		//가져온 값을 jsp 쪽으로 전달 
		model.addAttribute("userList", userList);
		//view 폴더에서 admin/users/list.jsp 파일을 찾으라는 의미 
		return "admin/user/list";
	}
	
	@RequestMapping(value ="/admin/user/view", method = RequestMethod.GET)
	public String view(@RequestParam("idx") int idx, Locale locale, Model model) {
		UserVO user = userDAO.select(idx);
		model.addAttribute("userView", user);
		return "admin/user/view";
	}
	
	@RequestMapping(value ="/admin/user/edit", method = RequestMethod.GET)
	public String edit(@RequestParam("idx") int idx, Locale locale, Model model) {
		UserVO user = userDAO.select(idx);
		model.addAttribute("userView", user);
		return "admin/user/edit";
	}
	
	@RequestMapping(value ="/admin/user/editDo", method = RequestMethod.POST)
	public String userEdit(@RequestParam("idx") int idx, @RequestParam("userName") String userName, @RequestParam("email") String email, @RequestParam("changePwd") String changePwd, Locale locale, Model model) {
		UserVO userVO = new UserVO();
		
		//edit 페이지에서 넘어온 값 VO에 세팅 
		userVO.setIdx(idx);
		userVO.setuserName(userName);
		//비밀번호를 변경하는 경우 
		if(changePwd != null ) {
			userVO.setuserPwd(changePwd);
		}
		userVO.setEmail(email);
		
		//VO를 인자값으로 넘겨주며 dao의 update 메써드 실행 
		userDAO.update(userVO);
		
		//redirect를 써주지 않으면 /admin/uwer/edit?idx=3.jsp 형태의 jsp파일을 찾기 때문에 404 에러가 나오는 
		return "redirect:/admin/user/edit?idx="+idx;
	}
	
	@RequestMapping(value="/admin/user/insert", method=RequestMethod.GET)
	public String insert(Locale locale, Model model) {
		return "/admin/user/insert";
	}
	
	@RequestMapping(value ="/admin/user/insertDo", method = RequestMethod.POST)
	public String userInsert(@RequestParam("userId") String userId, @RequestParam("userName") String userName, @RequestParam("email") String email, @RequestParam("userPwd") String userPwd, Locale locale, Model model) {
		UserVO userVO = new UserVO();
		
		//insert 페이지에서 넘어온 값 VO에 세팅 
		userVO.setuserId(userId);
		userVO.setuserName(userName);
		userVO.setuserPwd(userPwd);
		userVO.setEmail(email);
		
		//VO를 인자값으로 넘겨주며 dao의 update 메써드 실행 
		userDAO.insert(userVO);
		
		return "redirect:/admin/user/list";
	}
	
	@RequestMapping(value="/admin/user/delete", method=RequestMethod.GET)
	public String delete(@RequestParam("idx") int idx,Locale locale, Model model) {
		UserVO userVO = new UserVO();
		userVO.setIdx(idx);
		
		userDAO.delete(userVO);
		return "redirect:/admin/user/list";
	}
}

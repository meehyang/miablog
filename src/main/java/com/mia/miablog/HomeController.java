package com.mia.miablog;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mia.miablog.dao.AttachfileDAO;
import com.mia.miablog.dao.BoardDAO;
import com.mia.miablog.vo.AttachfileVO;
import com.mia.miablog.vo.BoardVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private BoardDAO boardDAO = new BoardDAO();
	@Autowired
	private AttachfileDAO attachfileDAO = new AttachfileDAO();
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		List<BoardVO> boardList = boardDAO.selectList();
		model.addAttribute("boardList", boardList);
		
		return "main/index";
	}
	
	@RequestMapping(value="/view", method = RequestMethod.GET)
	public String view(Locale locale, Model model, @RequestParam("idx") int idx) {
		BoardVO board = boardDAO.select(idx);
		AttachfileVO attachfile = attachfileDAO.select(idx);
		//첨부파일이 존재하는 경우에만 넘겨준다 
		if(attachfile!=null) {
			model.addAttribute("attachView", attachfile);
		}
		//이전글 다음글 가져오기
		BoardVO boardNum = boardDAO.selectNum(idx);
		
		model.addAttribute("boardView", board);
		model.addAttribute("boardNum", boardNum);
		
		return "main/view";
	}
	
}

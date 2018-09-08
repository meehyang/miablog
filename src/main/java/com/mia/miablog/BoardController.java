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

import com.mia.miablog.dao.BoardDAO;
import com.mia.miablog.vo.BoardVO;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("sessionUserName")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@Autowired
	private BoardDAO boardDAO = new BoardDAO();
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value="/admin/board/list", method = RequestMethod.GET)
	public String list(Locale locale, Model model, HttpSession session) {
		if(session.getAttribute("sessionUserName")==null || session.getAttribute("sessionUserName").equals("")) {
			return "redirect:/admin/login/login";
		}
		
		BoardVO boardVO = new BoardVO();
		List<BoardVO> boardList = boardDAO.selectList();
		model.addAttribute("boardList", boardList);
		return "admin/board/list";
	}
	
	@RequestMapping(value="/admin/board/view", method = RequestMethod.POST)
	public String view(Locale locale, Model model) {
		return "admin/board/view";
	}
}

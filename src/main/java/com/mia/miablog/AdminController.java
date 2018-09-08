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
@SessionAttributes("sessionUserName")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@RequestMapping(value="/admin/main/index", method = RequestMethod.GET)
	public String adminMain(Locale locale, Model model, @ModelAttribute("sessionUserName") String sessionUserName) {
		if(sessionUserName.equals("")) {
			return "redirect:/admin/login/login";
		}
		return "/admin/main/index";
	}
	
}

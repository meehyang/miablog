package com.mia.miablog;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import org.springframework.web.multipart.MultipartFile;

import com.mia.miablog.dao.AttachfileDAO;
import com.mia.miablog.dao.BoardDAO;
import com.mia.miablog.vo.AttachfileVO;
import com.mia.miablog.vo.BoardVO;
import com.mia.miablog.vo.UserVO;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("sessionUserName")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@Autowired
	private BoardDAO boardDAO = new BoardDAO();
	@Autowired
	private AttachfileDAO attachfileDAO = new AttachfileDAO();
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
	
	@RequestMapping(value="/admin/board/insert", method=RequestMethod.GET)
	public String insert(Locale locale, Model model){
		return "admin/board/insert";
	}
	
	@RequestMapping(value="/admin/board/insertDo", method=RequestMethod.POST)
	public String insertDo(Locale locale, Model model, @RequestParam("attachFileOrg") MultipartFile file, @RequestParam("title") String title) throws IOException{
		//파일 저장 로직 
		//넘어온 파일이 있으면 
		//넘어온 파일 이름
		String fileNameOrg = file.getOriginalFilename();
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("MM-dd-ss");
		//서버에 저장할 파일명으로 규칙 설정 후 변수 생성  
		String fileName = date.format(today)+"_"+fileNameOrg;
		
		try{
			
			if(!file.getOriginalFilename().isEmpty()) {
				
				BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File("/Users/MH/workspace-sts-3.9.5.RELEASE/miablog/src/main/webapp/resources/upload" , fileName)));
				bufferedOutputStream.write(file.getBytes());
				bufferedOutputStream.flush();
				bufferedOutputStream.close();
			}
			
		}catch(Exception e) {
		} finally {
			BoardVO boardVO = new BoardVO();
			boardVO.setTitle(title);
			boardVO.setuserIdx(7);
			
			boardDAO.insert(boardVO);
			
			AttachfileVO attachfileVO = new AttachfileVO();
			attachfileVO.setattachFile("/upload/"+fileName);
			attachfileVO.setattachFileOrg(fileNameOrg);
			attachfileVO.setboardIdx(boardVO.getBoardIdx());
			
			attachfileDAO.insert(attachfileVO);
			
		}
		
		return "redirect:/admin/board/list";
	}
	
	@RequestMapping(value="/admin/board/view", method = RequestMethod.GET)
	public String view(Locale locale, Model model, @RequestParam("idx") int idx) {
		BoardVO board = boardDAO.select(idx);
		AttachfileVO attachfile = attachfileDAO.select(idx);
		
		model.addAttribute("boardView", board);
		model.addAttribute("attachView", attachfile);
		
		return "admin/board/view";
	}
}

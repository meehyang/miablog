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
import com.mia.miablog.dao.UserDAO;
import com.mia.miablog.vo.AttachfileVO;
import com.mia.miablog.vo.BoardVO;
import com.mia.miablog.vo.UserVO;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes({"sessionUserName", "sessionUserIdx"})
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
		//인터셉터를 만들었기 때문에 기존 세션 처리는 필요없어짐 
//		if(session.getAttribute("sessionUserName")==null || session.getAttribute("sessionUserName").equals("") || session.getAttribute("sessionUserIdx")==null || session.getAttribute("sessionUserIdx").equals("")) {
//			return "redirect:/admin/login/login";
//		}
		List<BoardVO> boardList = boardDAO.selectList();
		
		model.addAttribute("boardList", boardList);
		return "admin/board/list";
	}
	
	@RequestMapping(value="/admin/board/insert", method=RequestMethod.GET)
	public String insert(Locale locale, Model model, HttpSession session){
		int userIdx = (int) session.getAttribute("sessionUserIdx");
		model.addAttribute("userIdx", userIdx);
		return "admin/board/insert";
	}
	
	@RequestMapping(value="/admin/board/delete", method=RequestMethod.GET)
	public String delete(Locale locale, Model model, @RequestParam("idx") int idx){
		//첨부파일이 있는 경우 첨부파일 먼저 삭제 
		AttachfileVO deleteAttachFile = attachfileDAO.select(idx);
		if(deleteAttachFile!=null) {
			//System.out.println("삭제할 경로 "+ deleteAttachFile.getattachFile() +"삭제할 파일 넘버 "+deleteAttachFile.getIdx());
			attachfileDAO.delete(deleteAttachFile.getIdx());
		}
		
		boardDAO.delete(idx);
		return "redirect:/admin/board/list";
	}
	
	@RequestMapping(value="/admin/board/insertDo", method=RequestMethod.POST)
	public String insertDo(Locale locale, Model model, @RequestParam("attachFileOrg") MultipartFile file, @RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("cate") String cate, HttpSession session) throws IOException{
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
			int userIdx = (int) session.getAttribute("sessionUserIdx");
			boardVO.setTitle(title);
			boardVO.setContent(content);
			boardVO.setCate(cate);
			boardVO.setuserIdx(userIdx);
			boardDAO.insert(boardVO);
			
			AttachfileVO attachfileVO = new AttachfileVO();
			attachfileVO.setattachFile("upload/"+fileName);
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
		//첨부파일이 존재하는 경우에만 넘겨준다 
		if(attachfile!=null) {
			model.addAttribute("attachView", attachfile);
		}
		model.addAttribute("boardView", board);
		
		return "admin/board/view";
	}
	
	@RequestMapping(value="/admin/board/edit", method = RequestMethod.GET)
	public String edit(Locale locale, Model model, @RequestParam("idx") int idx) {
		BoardVO board = boardDAO.select(idx);
		AttachfileVO attachfile = attachfileDAO.select(idx);
		//첨부파일이 존재하는 경우에만 넘겨준다 
		if(attachfile!=null) {
			model.addAttribute("attachView", attachfile);
		}
		model.addAttribute("boardView", board);
		
		return "admin/board/edit";
	}
	
	@RequestMapping(value="/admin/board/editDo", method=RequestMethod.POST)
	public String editDo(Locale locale, Model model, @RequestParam("attachFileOrg") MultipartFile file, @RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("idx") int idx, @RequestParam("cate") String cate) throws IOException{
		BoardVO boardVO = new BoardVO();
		boardVO.setIdx(idx);
		boardVO.setTitle(title);
		boardVO.setContent(content);
		boardVO.setuserIdx(idx);
		boardVO.setCate(cate);
		
		boardDAO.update(boardVO);
		
		//파일 저장 로직 
		//넘어온 파일이 있으면 
		//넘어온 파일 이름
		String fileNameOrg = file.getOriginalFilename();
		System.out.println("넘어온 파일 이름 "+fileNameOrg);
		if(fileNameOrg != null && !fileNameOrg.equals("")) {
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
				AttachfileVO attachfileVO = new AttachfileVO();
				attachfileVO.setattachFile("upload/"+fileName);
				attachfileVO.setattachFileOrg(fileNameOrg);
				attachfileVO.setboardIdx(idx);
				
				attachfileDAO.update(attachfileVO);
				
			}
		}
		
		return "redirect:/admin/board/view?idx="+idx;
	}
}

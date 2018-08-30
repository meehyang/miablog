package com.mia.miablog;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mia.miablog.dao.BoardDAO;
import com.mia.miablog.vo.BoardVO;

//junit과 servlet-context 파일을 불러오겠다는 명령
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class BoardDAOTest {
	@Autowired
	protected BoardDAO boardDAO;
	
	@Test
	public void selectList() {
		List<BoardVO> boardList = boardDAO.selectList();
		for(BoardVO boardVO : boardList) {
			System.out.println("idx는 "+boardVO.getIdx()+" 제목은 "+boardVO.getTitle());
			assertTrue(boardVO instanceof BoardVO);
		}
	}
	
	@Test
	public void insert() {
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("게시물 제목 ");
		boardVO.setContent("게시물 내용이 들어갑니다. 게시물 테스트...");
		boardVO.setUser_idx(5);
		
		boardDAO.insert(boardVO);
	}
	
	@Test
	public void update() {
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("제목바꾸기 ");
		boardVO.setIdx(3);
		
		boardDAO.update(boardVO);
	}
	
	@Test
	public void delete() {
		BoardVO boardVO = new BoardVO();
		boardVO.setIdx(3);
		
		boardDAO.delete(boardVO);
	}
}



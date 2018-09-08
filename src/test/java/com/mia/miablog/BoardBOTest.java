package com.mia.miablog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mia.miablog.bo.BoardBO;
import com.mia.miablog.vo.BoardVO;

//junit초기화 설
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})

public class BoardBOTest {
	@Autowired
	private BoardBO boardBO;
	
	@Test
	public void insert() {
		BoardVO boardVO = new BoardVO();
		
		boardVO.setTitle("boardBO test title");
		boardVO.setContent("메롱메롱메롱멜ㅇ");
		boardVO.setuserIdx(7);
		
		boardBO.insert(boardVO);
	}
	
	@Test
	public void update() {
		BoardVO boardVO = new BoardVO();
		
		boardVO.setTitle("BO 테스트 확인용 타이틀 update");
		boardVO.setIdx(4);
		
		boardBO.update(boardVO);
	}
	
	@Test
	public void delete() {
		BoardVO boardVO = new BoardVO();
		
		boardVO.setIdx(5);
		
		boardBO.delete(boardVO);
	}
	
	@Test
	public void selectList() {
		boardBO.selectList();
	}
}

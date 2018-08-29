package com.mia.miablog;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mia.miablog.dao.UserDAO;
import com.mia.miablog.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class UserDAOTest {
	@Autowired
	protected UserDAO userDAO;
	//userDAO가 이미 클래스의 멤버변수로 선언되어 있다.
	//@Autowired가 UserDAO userDAO = new UserDAO(); 부분을 해결해줌
	//@Autowired는 스프링의 기능 중 하나로 선언된 이름(UserDAO)을 찾아서 그것과 동일한 객체를 찾아 userDAO에 자동으로 new UserDAO()를 해서 담아주는 역할  
	
	@Test
	public void insert() {
		UserVO userVO = new UserVO();
		userVO.setUser_id("nia");
		userVO.setEmail("meixiang126@test.com");
		userVO.setUser_name("meehyang kim");
		userVO.setUser_pwd("pwd");
		
		userDAO.insert(userVO);
	}
	
	@Test
	public void selectList() {
		List<UserVO> userList = userDAO.selectList();
		for(UserVO userVO : userList) {
			System.out.println(userVO.getUser_name());
			assertTrue(userVO instanceof UserVO);
		}
	}
	
	@Test
	public void update() {
		UserVO userVO = new UserVO();
		userVO.setIdx(1);
		userVO.setUser_name("sia");
		
		userDAO.update(userVO);
	}
	
	@Test
	public void delete() {
		UserVO userVO = new UserVO();
		userVO.setUser_name("sia");
		
		userDAO.delete(userVO);
	}
}

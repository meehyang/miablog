package com.mia.miablog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mia.miablog.bo.UserBO;
import com.mia.miablog.vo.UserVO;

//junit초기화 설
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})

public class UserBOTest {
	@Autowired
	protected UserBO userBO;
	
	@Test
	public void insert() {
		UserVO userVO = new UserVO();
		
		userVO.setuserId("bo_tester");
		userVO.setEmail("meixiang126@test.com");
		userVO.setuserName("meehyang kim");
		userVO.setuserPwd("pwd");
		
		userBO.insert(userVO);
	}
	
	@Test
	public void update() {
		UserVO userVO = new UserVO();
		
		userVO.setIdx(5);
		userVO.setuserName("botester_name_update");
		
		userBO.update(userVO);
	}
	
	@Test
	public void delete() {
		UserVO userVO = new UserVO();
		userVO.setuserName("botester_name_update");
		userBO.delete(userVO);
	}
	
	@Test
	public void selectList() {
		userBO.selectList();
	}
}

package com.mia.miablog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mia.miablog.bo.AttachfileBO;
import com.mia.miablog.vo.AttachfileVO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})

public class AttachfileBOTest {
	@Autowired
	private AttachfileBO attachfileBO = new AttachfileBO();
	
	@Test
	public void insert() {
		AttachfileVO attachfileVO = new AttachfileVO();
		
		attachfileVO.setattachFile("/bo test.jpg");
		attachfileVO.setattachFileOrg("../home/image/aaaa.jpg");
		attachfileVO.setboardIdx(9);
		
		attachfileBO.insert(attachfileVO);
	}
	
	@Test
	public void update() {
		AttachfileVO attachfileVO = new AttachfileVO();
		
		attachfileVO.setattachFile("bo도 잘 바뀌는지 체크 ");
		attachfileVO.setIdx(5);
		
		attachfileBO.update(attachfileVO);
	}
	
	@Test
	public void delete() {
		AttachfileVO attachfileVO = new AttachfileVO();
		attachfileVO.setIdx(6);
		
		attachfileBO.delete(attachfileVO.getIdx());
	}
	
	@Test
	public void selectList() {
		attachfileBO.selectList();
	}
	
}

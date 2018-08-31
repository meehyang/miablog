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
		
		attachfileVO.setAttach_file("/bo test.jpg");
		attachfileVO.setAttach_file_org("../home/image/aaaa.jpg");
		attachfileVO.setBoard_idx(9);
		
		attachfileBO.insert(attachfileVO);
	}
	
	@Test
	public void update() {
		AttachfileVO attachfileVO = new AttachfileVO();
		
		attachfileVO.setAttach_file("bo도 잘 바뀌는지 체크 ");
		attachfileVO.setIdx(5);
		
		attachfileBO.update(attachfileVO);
	}
	
	@Test
	public void delete() {
		AttachfileVO attachfileVO = new AttachfileVO();
		attachfileVO.setIdx(6);
		
		attachfileBO.delete(attachfileVO);
	}
	
	@Test
	public void selectList() {
		attachfileBO.selectList();
	}
	
}

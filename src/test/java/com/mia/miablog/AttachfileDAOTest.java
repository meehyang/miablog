package com.mia.miablog;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mia.miablog.dao.AttachfileDAO;
import com.mia.miablog.vo.AttachfileVO;

//junit과 servlet-context 파일을 불러오겠다는 명령
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class AttachfileDAOTest {
	@Autowired
	private AttachfileDAO attachfileDAO = new AttachfileDAO();
	
	@Test
	public void insert() {
		AttachfileVO attachfileVO = new AttachfileVO();
		
		attachfileVO.setattachFile("저장되는첨부파일명.jpg");
		attachfileVO.setattachFileOrg("/실제경로/원래파일네임.jpg");
		attachfileVO.setboardIdx(8);
		
		attachfileDAO.insert(attachfileVO);
	}
	
	@Test
	public void update() {
		AttachfileVO attachfileVO = new AttachfileVO();
		
		attachfileVO.setattachFile("변경파일명");
		attachfileVO.setIdx(1);
		
		attachfileDAO.update(attachfileVO);
	}
	
	@Test
	public void delete() {
		AttachfileVO attachfileVO = new AttachfileVO();
		
		attachfileVO.setIdx(1);
		
		attachfileDAO.delete(attachfileVO.getIdx());
	}
	
	@Test
	public void selectList() {
		AttachfileVO attachfileVO = new AttachfileVO();
		attachfileDAO.selectList(attachfileVO);
		
		//콘솔 출력용으로 idx와 attach_file_org만 출력해보기
		//AttachfileVO 타입의 List 생성 
		List<AttachfileVO> attachList = attachfileDAO.selectList(attachfileVO);
		//변경된 foreach문 for(변수타입 변수명 : 배열이름)
		for(AttachfileVO attachfileList: attachList) {
			System.out.println("idx 는 "+attachfileList.getIdx() + " 원본파일명은 "+attachfileList.getattachFileOrg());
			// junit용 테스트 메써드 
			assertTrue(attachfileList instanceof AttachfileVO);
		}
	}
}

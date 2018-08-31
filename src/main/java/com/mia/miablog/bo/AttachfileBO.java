package com.mia.miablog.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mia.miablog.dao.AttachfileDAO;
import com.mia.miablog.vo.AttachfileVO;

public class AttachfileBO {
	@Autowired
	private AttachfileDAO attachfileDAO = new AttachfileDAO();
	
	public void insert(AttachfileVO attachfileVO) {
		attachfileDAO.insert(attachfileVO);
	}
	
	public void update(AttachfileVO attachfileVO) {
		attachfileDAO.update(attachfileVO);
	}
	
	public void delete(AttachfileVO attachfileVO) {
		attachfileDAO.delete(attachfileVO);
	}
	
	public List<AttachfileVO> selectList(){
		return attachfileDAO.selectList(); 
	}
}

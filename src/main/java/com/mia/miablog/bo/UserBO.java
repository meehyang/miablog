package com.mia.miablog.bo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.mia.miablog.dao.UserDAO;
import com.mia.miablog.vo.UserVO;

public class UserBO {
	@Autowired
	protected UserDAO userDAO;
	
	//BO에 DAO의 메써드를 호출하는 메써드를 구현해둔다
	//그럼 컨트롤러에서 BO를 호출하면 BO의 메써드가 DAO메써드를 호출하고 DAO에 구현된 메써드들이 mybatis에 접근해서 해당 기능을 실행하는 구조 
	//user테이블에만 관여하는 메써드 
	public void insert(UserVO userVO) {
		userDAO.insert(userVO);
	}
	
	public void update(UserVO userVO) {
		userDAO.update(userVO);
	}
	
	public void delete(UserVO userVO) {
		userDAO.delete(userVO);
	}
	
	public List<UserVO> selectList(){
		return userDAO.selectList();
	}
}

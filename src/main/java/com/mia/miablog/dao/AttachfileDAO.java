package com.mia.miablog.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.mia.miablog.vo.AttachfileVO;

public class AttachfileDAO extends SqlSessionDaoSupport{
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void insert(AttachfileVO attachfileVO) {
		getSqlSession().insert("Attachfile.insert", attachfileVO);
	}
	
	public void update(AttachfileVO attachfileVO) {
		getSqlSession().update("Attachfile.update", attachfileVO);
	}

	public void delete(AttachfileVO attachfileVO) {
		getSqlSession().delete("Attachfile.delete", attachfileVO);
	}
	
	public List<AttachfileVO> selectList(){
		Map<String, String> paramMap = new HashMap<String, String>();
		return getSqlSession().selectList("Attachfile.selectList", paramMap);
		
	}
}

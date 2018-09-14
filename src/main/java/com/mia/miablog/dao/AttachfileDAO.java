package com.mia.miablog.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.mia.miablog.vo.AttachfileVO;
import com.mia.miablog.vo.BoardVO;

public class AttachfileDAO extends SqlSessionDaoSupport{
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void insert(AttachfileVO attachfileVO) {
		getSqlSession().insert("Attachfile.insert", attachfileVO);
	}
	
	public void update(AttachfileVO attachfileVO) {
		getSqlSession().update("Attachfile.update", attachfileVO);
	}

	public void delete(int idx) {
		getSqlSession().delete("Attachfile.delete", idx);
	}
	
	public List<AttachfileVO> selectList(AttachfileVO attachfileVO){
		return getSqlSession().selectList("Attachfile.selectList", attachfileVO);
		
	}
	
	public AttachfileVO select(int idx){
		return getSqlSession().selectOne("Attachfile.select", idx);
	}
}

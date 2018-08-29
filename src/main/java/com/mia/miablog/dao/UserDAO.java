package com.mia.miablog.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.mia.miablog.vo.UserVO;

/*
 * SqlSessionDaoSupport 와 sqlSessionTemplate 는 mybatis 가 가지고 있는 기능 
 * JDBC : java에서 mysql에 연결할 수 있는 라이브러리 (쿼리 날리고 받고 등등을 다 할 수 있다.) 
 * 쿼리 쓰고 데이터 받고 등등 일련의 과정을 한번에 할 수 있게 묶어 둔 템플릿 같은 거라고 생각하면 됨.
 * mysql - JDBC - Mybatic(sqlsession이 포함된) 이런 식으로 연결되있다고 생각하면 됨 
 * sqlsession이 mysql 에 입장할 수 있는 번호표를 주며 db의 커넥션을 유지하는 역할 
 * sql 명령어 등을 변환해서 결과물을 내고 돌려주는 그 연결 '구간' 이 sqlsessiontemplate 
 * dao - sqlsessiondaosupport - sqlsessiontemplate 는 세트 
 */
public class UserDAO extends SqlSessionDaoSupport{
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void insert(UserVO userVO) {
		getSqlSession().insert("User.insert",userVO);
	}
	
}

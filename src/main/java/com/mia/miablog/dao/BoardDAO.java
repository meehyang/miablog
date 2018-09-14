package com.mia.miablog.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import com.mia.miablog.vo.BoardVO;
import com.mia.miablog.vo.UserVO;

//SqlSessionDaoSupport는 SqlSession을 제공하는 추상클래스이다. 
//getSqlSession()메서드를 호출해서 다음처럼 SQL을 처리하는 마이바티스 메서드를 호출하기 위해 사용할 SqlSessionTemplate을 얻을 수 있다.
public class BoardDAO extends SqlSessionDaoSupport{
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void insert(BoardVO boardVO) {
		getSqlSession().insert("Board.insert", boardVO);
	}
	
	public void update(BoardVO boardVO) {
		getSqlSession().update("Board.update", boardVO);
	}
	
	public void delete(int idx) {
		getSqlSession().delete("Board.delete", idx);
	}
	
	public List<BoardVO> selectList(){
		Map<String, String> paramMap = new HashMap<String, String>();
		return getSqlSession().selectList("Board.selectList", paramMap);
	}
	
	public BoardVO select(int idx){
		return getSqlSession().selectOne("Board.select", idx);
	}
	
	public BoardVO selectNum(int idx){
		return getSqlSession().selectOne("Board.selectNum", idx);
	}
}

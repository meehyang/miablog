package com.mia.miablog.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mia.miablog.dao.BoardDAO;
import com.mia.miablog.vo.BoardVO;

public class BoardBO {
	@Autowired
	protected BoardDAO boardDAO;
	
	public void insert(BoardVO boardVO) {
		boardDAO.insert(boardVO);
	}
	
	public void update(BoardVO boardVO) {
		boardDAO.update(boardVO);
	}
	
	public void delete(int idx) {
		boardDAO.delete(idx);
	}
	
	public List<BoardVO> selectList() {
		return boardDAO.selectList();
	}
}


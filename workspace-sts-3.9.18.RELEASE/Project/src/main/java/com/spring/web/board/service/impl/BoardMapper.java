package com.spring.web.board.service.impl;

import java.util.List;

import com.spring.web.vo.boardVO;

public interface BoardMapper {
	public List<boardVO> getList(boardVO searchVO);
	public void insertBoard(boardVO searchVO); 

}

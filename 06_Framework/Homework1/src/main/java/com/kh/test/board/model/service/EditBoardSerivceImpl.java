package com.kh.test.board.model.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.test.board.model.mapper.EditBoardMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class EditBoardSerivceImpl implements EditBoardService{

	private final EditBoardMapper mapper;
	
}

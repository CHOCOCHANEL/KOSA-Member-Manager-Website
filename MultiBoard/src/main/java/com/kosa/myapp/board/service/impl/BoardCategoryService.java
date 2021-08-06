package com.kosa.myapp.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.myapp.board.model.BoardCategory;
import com.kosa.myapp.board.service.IBoardCategoryService;

@Service
public class BoardCategoryService implements IBoardCategoryService {
	
	@Autowired
	IBoardCategoryRepository boardCategoryRepository;

	@Override
	public List<BoardCategory> selectAllCategory() {
		// TODO Auto-generated method stub
		return boardCategoryRepository.selectAllCategory();
	}

	@Override
	public List<BoardCategory> selectAllCategoryBy() {
		// TODO Auto-generated method stub
		return boardCategoryRepository.selectAllCategoryByClass1(calss1);
	}

	@Override
	public void insertNewCategory(BoardCategory boardCategory) {
		// TODO Auto-generated method stub
		boardCategory.setCategoryId(boardCategoryRepository.selectMaxCategoryId());
		boardCateogoryRepository.insertNewCategory(boardCategory);

	}

	@Override
	public void updateCategory(BoardCategory boardCategory) {
		// TODO Auto-generated method stub
		boardCategoryRepository.updateCategory(boardCategory);

	}

	@Override
	public void deleteCategory(int categoryId) {
		// TODO Auto-generated method stub
		boardCategoryRepository.deleteCategory(categoryId);
	}

}

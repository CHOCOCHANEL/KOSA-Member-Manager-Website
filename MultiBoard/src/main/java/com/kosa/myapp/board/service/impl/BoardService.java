package com.kosa.myapp.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kosa.myapp.board.model.Board;
import com.kosa.myapp.board.model.BoardUploadFile;
import com.kosa.myapp.board.service.IBoardService;
//qwertyuiop
@Service
public class BoardService implements IBoardService {

	@Autowired
	IBoardRepository boardRepository;
	
	@Transactional
	public void insertArticle(Board board) {
		// TODO Auto-generated method stub
		board.setBoardId();
		
	}

	@Override
	public void insertArticle(Board boardId, BoardUploadFile file) {
		
		board.setBoardId(boardRepository.selectMaxArticleNo()+1);
		boardRepository.insertArticle(board);
		if(file !=null && file.getFileName() != null && !file.getFileName().equals("")) {
			file.setBoardId(board.getBoardId());
			file.setFileId(boardRepository.selectMaxFileId()+1);
			boardRepository.insertFileData(file);
		}

	}

	@Override
	public List<Board> selectArticleListByCategory(int categoryId, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Board> selectArticleListByCategory(int categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Board selectArticle(int boardId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardUploadFile getFile(int fileId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void replyArticle(Board board) {
		// TODO Auto-generated method stub

	}

	@Override
	public void replyArticle(Board board, BoardUploadFile file) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getPassword(int boardId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateArticle(Board board) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateArticle(Board board, BoardUploadFile file) {
		// TODO Auto-generated method stub

	}

	@Override
	public Board selectDeleteArticle(int boardId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteArticle(int boardId, int replyNumber) {
		// TODO Auto-generated method stub

	}

	@Override
	public int selectTotalArticleCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectTotalArticleCountByCategoryId(int categoryId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Board> searchListByContentKeyword(String keyword, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectTotalArticleCountByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return 0;
	}

}

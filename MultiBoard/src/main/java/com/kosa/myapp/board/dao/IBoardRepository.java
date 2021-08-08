package com.kosa.myapp.board.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.kosa.myapp.board.model.Board;
import com.kosa.myapp.board.model.BoardUploadFile;

public interface IBoardRepository {
	int selectMaxArticleNo();
	int selectMaxFileId();
	
	void insertArticle(Board board);
	void insertFileData(BoardUploadFile file);
	
	List<Board> selectArticleListByCategory(@Param("categoryId") int categoryId, @Param("start") int start, @Param("end") int end);
	
	Board selectArticle(int boardId);
	BoardUploadFile getFile(int fileId);
	
	void updateReadCount(int boardId);
	void updateReplyNumber(@Param("masterId") int masterId, @Param("replyNumber") int replyNumber);
	void replyArticle(Board boardId);
	
	String getPassword(int boardId);
	void updateArticle(Board board);
	void updateFileData(BoardUploadFile file);
	
	void deleteFileData(int boardId);
	void deleteReplyFileData(int boardId);
	Board selectDeleteArticle(int boardId);
	void deleteArticleByBoardId(int boardId);
	void deleteArticleByMasterId(int boardId);
	
	int selectTotalArticleCount();
	int selectTotalArticleCountByCategoryId(int categoryId);
	int selectTotalArticleCountByKeyword(String keyword); //교재에 없고 BoardMapper에만 있음(재홍)
	List<Board> searchListByContentKeyword(String keyword, int start, int end); //교재와 달리 p.406 BoardService와 BoardMapper 참고해서 추론함(재홍)
}

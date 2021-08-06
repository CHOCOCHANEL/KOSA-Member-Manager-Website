package com.kosa.myapp.board.model;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

public class Board {
	private int boardId;
	private int categoryId;
	private String writer;
	private String email;
	private String password;
	private String title;
	private String content;
	private Timestamp writeDate;
	private int masterId;
	private int readCount;
	private int replyNumber;
	private int replyStep;
	private int seq;
	private int page;
	private BoardCategory category;
	private MultipartFile file;
	
	private int fileId;
	private String fileName;
	private long fileSize;
	private String fileContentType;
	public int getBoardId() {
		return boardId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public String getWriter() {
		return writer;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public Timestamp getWriteDate() {
		return writeDate;
	}
	public int getMasterId() {
		return masterId;
	}
	public int getReadCount() {
		return readCount;
	}
	public int getReplyNumber() {
		return replyNumber;
	}
	public int getReplyStep() {
		return replyStep;
	}
	public int getSeq() {
		return seq;
	}
	public int getPage() {
		return page;
	}
	public BoardCategory getCategory() {
		return category;
	}
	public MultipartFile getFile() {
		return file;
	}
	public int getFileId() {
		return fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public long getFileSize() {
		return fileSize;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setWriteDate(Timestamp writeDate) {
		this.writeDate = writeDate;
	}
	public void setMasterId(int masterId) {
		this.masterId = masterId;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public void setReplyNumber(int replyNumber) {
		this.replyNumber = replyNumber;
	}
	public void setReplyStep(int replyStep) {
		this.replyStep = replyStep;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public void setCategory(BoardCategory category) {
		this.category = category;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	@Override
	public String toString() {
		return "Board [boardId=" + boardId + ", categoryId=" + categoryId + ", writer=" + writer + ", email=" + email
				+ ", password=" + password + ", title=" + title + ", content=" + content + ", writeDate=" + writeDate
				+ ", masterId=" + masterId + ", readCount=" + readCount + ", replyNumber=" + replyNumber
				+ ", replyStep=" + replyStep + ", seq=" + seq + ", page=" + page + ", category=" + category + ", file="
				+ file + ", fileId=" + fileId + ", fileName=" + fileName + ", fileSize=" + fileSize
				+ ", fileContentType=" + fileContentType + "]";
	}
	
	

}//end class
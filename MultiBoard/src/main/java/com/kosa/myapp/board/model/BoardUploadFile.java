package com.kosa.myapp.board.model;

import java.util.Arrays;

public class BoardUploadFile {
	
	private int fileId; //파일 아이디, 1씩 증가
	private int boardId; //첨부파일이 있는 게시글의 아이디 (글번호)
	private String fileName; //파일이름
	private long fileSize; //파일크기
	private String fileContetType; //파일타입(MIME Type)
	private byte[] fileData; //파일데이터
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	public String getFileContentType() { // 오타 수정
		return fileContetType;
	}
	public void setFileContentType(String fileContetType) {
		this.fileContetType = fileContetType;
	}
	public byte[] getFileData() {
		return fileData;
	}
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
	@Override
	public String toString() {
		return "BoardUploadFile [fileId=" + fileId + ", boardId=" + boardId + ", fileName=" + fileName + ", fileSize="
				+ fileSize + ", fileContetType=" + fileContetType + ", fileData=" + Arrays.toString(fileData) + "]";
	}

}

package com.kosa.myapp.upload.dao;

import java.util.List;

import com.kosa.myapp.upload.model.UploadFileVO;

public interface IUploadFileRepository {
	
	// fileId 자동 생성
	int getMaxFileId();
	// file 업로드
	void uploadFile(UploadFileVO file);
	// 업로드 file 목록
	List<UploadFileVO> getFileList(String directoryName);
	// getAillFileList
	List<UploadFileVO> getAllFileList();
	// file 다운로드
	UploadFileVO getFile(int fileId);
	// file 업데이트
	void updateFile(UploadFileVO file);
	// file 삭제
	void deleteFile(int fileId);
	
}

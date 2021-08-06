package com.kosa.myapp.upload.service;

import java.util.List;

import org.springframework.ui.Model;

import com.kosa.myapp.upload.model.UploadFileVO;

public interface IUploadFileService {
	void uploadFile(UploadFileVO file);
	List<UploadFileVO> getFileList(String dir);
	List<UploadFileVO> getAllFileList();
	UploadFileVO getFile(int fileId);
	void updateFile(UploadFileVO file);
	void deleteFile(int fileId);
}

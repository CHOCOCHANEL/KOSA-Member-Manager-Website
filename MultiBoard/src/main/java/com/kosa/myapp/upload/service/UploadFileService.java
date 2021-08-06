package com.kosa.myapp.upload.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.myapp.upload.dao.IUploadFileRepository;
import com.kosa.myapp.upload.model.UploadFileVO;

@Service
public class UploadFileService implements IUploadFileService {

	@Autowired
	IUploadFileRepository uploadFileRepository;
	
	@Override
	public void uploadFile(UploadFileVO file) {
		file.setFileId(uploadFileRepository.getMaxFileId() + 1);
		uploadFileRepository.uploadFile(file);
	}
	
	@Override
	public List<UploadFileVO> getFileList(String dir){
		return uploadFileRepository.getFileList(dir);
	}
	
	@Override
	public List<UploadFileVO> getAllFileList(){
		return uploadFileRepository.getAllFileList();
	}

	@Override
	public UploadFileVO getFile(int fileId) {
		return uploadFileRepository.getFile(fileId);
	}
	
	@Override
	public void updateFile(UploadFileVO file) {
		uploadFileRepository.updateFile(file);
	}
	
	@Override
	public void deleteFile(int fileId) {
		uploadFileRepository.deleteFile(fileId);
	}
}

package com.kosa.myapp.upload.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kosa.myapp.upload.model.UploadFileVO;

@Repository
public class UploadFileRepository implements IUploadFileRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public int getMaxFileId() {
		String sql = "select nvl(max(file_id), 0) from upload_file";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public void uploadFile(UploadFileVO file) {
		String sql = "insert into upload_file "
				+ "(file_id, directory_name, file_name, file_size, "
				+ "file_content_type, file_upload_date, file_data) "
				+ "values(?, ?, ?, ?, ?, systimestamp, ?)";
		jdbcTemplate.update(sql,
				file.getFileId(),
				file.getDirectoryName(),
				file.getFileName(),
				file.getFileSize(),
				file.getFileContentType(),
				file.getFileData());
	}

	@Override
	public List<UploadFileVO> getFileList(String directoryName) {
		String sql = "select "
				+ "file_id as fileId, "
				+ "directory_name as directoryName, "
				+ "file_name as fileName, "
				+ "file_size as fileSize, "
				+ "file_content_type as fileContentType, "
				+ "file_upload_date as fileUploadDate "
				+ "from upload_file "
				+ "where dictionary_name = ? "
				+ "order by file_upload_date desc ";
		return jdbcTemplate.query(sql, new RowMapper<UploadFileVO>() {
			@Override
			public UploadFileVO mapRow(ResultSet rs, int count) throws SQLException {
				UploadFileVO file = new UploadFileVO();
				file.setFileId(rs.getInt("fileId"));
				file.setDirectoryName(rs.getString("directoryName"));
				file.setFileName(rs.getString("fileName"));
				file.setFileSize(rs.getLong("fileSize"));
				file.setFileContentType(rs.getString("fileContentType"));
				file.setFileUploadDate(rs.getTimestamp("fileUploadDate"));
				return file;
			}
		}, directoryName);
	}
	
	@Override
	public List<UploadFileVO> getAllFileList(){
		String sql = "select "
				+ "file_id as fileId, "
				+ "directory_name as directoryName, "
				+ "file_name as fileName, "
				+ "file_size as fileSize, "
				+ "file_content_type as fileContentType, "
				+ "file_upload_date as fileUploadDate "
				+ "from upload_file "
				+ "order by file_upload_date desc ";
		return jdbcTemplate.query(sql, new RowMapper<UploadFileVO>() {
			@Override
			public UploadFileVO mapRow(ResultSet rs, int count) throws SQLException {
				UploadFileVO file = new UploadFileVO();
				file.setFileId(rs.getInt("fileId"));
				file.setDirectoryName(rs.getString("directoryName"));
				file.setFileName(rs.getString("fileName"));
				file.setFileSize(rs.getLong("fileSize"));
				file.setFileContentType(rs.getString("fileContentType"));
				file.setFileUploadDate(rs.getTimestamp("fileUploadDate"));
				return file;
			}
		});
	}

	@Override
	public UploadFileVO getFile(int fileId) {
		String sql = "select "
				+ "file_id as fileId, "
				+ "directory_name as directoryName, "
				+ "file_name as fileName, "
				+ "file_size as fileSize, "
				+ "file_content_type as fileContentType, "
				+ "file_data as fileData "
				+ "from upload_file "
				+ "where file_id = ? ";
		return jdbcTemplate.queryForObject(sql, new RowMapper<UploadFileVO>() {
			@Override
			public UploadFileVO mapRow(ResultSet rs, int count) throws SQLException {
				UploadFileVO file = new UploadFileVO();
				file.setFileId(rs.getInt("fileId"));
				file.setDirectoryName(rs.getString("directoryName"));
				file.setFileName(rs.getString("fileName"));
				file.setFileSize(rs.getLong("fileSize"));
				file.setFileContentType(rs.getString("fileContentType"));
				file.setFileData(rs.getBytes("fileData"));
				return file;
			}
		}, fileId);
	}

	@Override
	public void updateFile(UploadFileVO file) {
		String sql = "update upload_file "
				+ "set directory_name = ?, "
				+ "file_name = ?, "
				+ "file_size = ?, "
				+ "file_content_type = ?, "
				+ "file_data = ?, "
				+ "where file_id = ?";
		jdbcTemplate.update(sql, 
								file.getDirectoryName(),
								file.getFileName(),
								file.getFileSize(),
								file.getFileContentType(),
								file.getFileData(),
								file.getFileId());
	}

	@Override
	public void deleteFile(int fileId) {
		String sql = "delete from upload_file "
				+ "where file_id = ? ";
		jdbcTemplate.update(sql, fileId);
	}

}

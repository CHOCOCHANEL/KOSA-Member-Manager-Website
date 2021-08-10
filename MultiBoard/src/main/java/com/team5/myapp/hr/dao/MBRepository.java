package com.team5.myapp.hr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.team5.myapp.hr.model.MBVO;
import com.team5.myapp.hr.model.gHistoryVO;

@Repository
public class MBRepository implements IMBRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private class MBMapper implements RowMapper<MBVO>{
		@Override
		public MBVO mapRow(ResultSet rs, int count) throws SQLException{
			MBVO mb = new MBVO();
			mb.setMemberId(rs.getInt("member_id"));
			mb.setFirstName(rs.getString("first_name"));
			mb.setLastName(rs.getString("last_name"));
			mb.setEmail(rs.getString("email"));
			mb.setPhoneNumber(rs.getString("phone_number"));
			mb.setGroupId(rs.getInt("group_id"));
			mb.setJobId(rs.getString("job_id"));
			mb.setManagerId(rs.getInt("manager_id"));
			mb.setRoleId(rs.getString("role_id"));
			return mb;
		}
	}
	
	private class GroupHistoryMapper implements RowMapper<gHistoryVO>{
		@Override
		public gHistoryVO mapRow(ResultSet rs, int count) throws SQLException{
			gHistoryVO g = new gHistoryVO();
			g.setMemberId(rs.getInt("member_id"));
			g.setStartDate(rs.getDate("start_date"));
			g.setEndDate(rs.getDate("end_date"));
			g.setGroupId(rs.getInt("group_id"));
			g.setGroupName(rs.getString("group_name"));
			g.setRoleId(rs.getString("role_id"));
			return g;
		}
	}

	@Override
	public int getMBCount() {
		String sql = "select count(*) from MB";
		return jdbcTemplate.queryForObject(sql, Integer.class) ;
	}

	@Override
	public int getMBCount(int groupid) {
		String sql = "select count(*) from MB where group_id=?";
		return jdbcTemplate.queryForObject(sql, Integer.class, groupid);
	}

	@Override
	public List<MBVO> getMBList() {
		String sql ="select * from MB";
		return jdbcTemplate.query(sql, new MBMapper());
	}
	
	@Override
	public List<gHistoryVO> getGroupHistoryList() {
		String sql = "select * from GROUP_HISTORY ORDER BY group_id";
		return jdbcTemplate.query(sql, new GroupHistoryMapper());
	}

	@Override
	public MBVO getMBInfo(int memid) {
		String sql = "select member_id, first_name, last_name, email, "
				   +" phone_number, job_id, manager_id, group_id, role_id "
				   +" from MB where member_id=?";
		return jdbcTemplate.queryForObject(sql, new MBMapper(), memid);
	}

	@Override
	public void updateMB(MBVO mb) {
		String sql = "UPDATE MB "
				    +"SET first_name=?, last_name=?, email=?, phone_number=?, "
				    +"job_id=?, manager_id=?, group_id=?, role_id=? "
				    +"WHERE member_id=?";
		jdbcTemplate.update(sql, mb.getFirstName(),
								 mb.getLastName(),
								 mb.getEmail(),
								 mb.getPhoneNumber(),
								 mb.getJobId(),
								 mb.getManagerId(),
								 mb.getGroupId(),
								 mb.getRoleId(),
								 mb.getMemberId()
								 );
	}

	@Override
	public void insertMB(MBVO mb) {
		String sql = "insert into MB "
					+ "(member_id, first_name, last_name, email, phone_number, "
				    + "job_id, manager_id, group_id, role_id) "
				    + "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql,mb.getMemberId(),
								mb.getFirstName(),
								mb.getLastName(),
								mb.getEmail(),
								mb.getPhoneNumber(),
								mb.getJobId(),
								mb.getManagerId(),
								mb.getGroupId(),
								mb.getRoleId());
	}

	@Override
	public List<gHistoryVO> getGroupHistory(int memid){
		String sql = "select * "
				+ " from GROUP_HISTORY "
				+ " WHERE member_id = ? "
				+ " ORDER BY start_date, end_date";
		return jdbcTemplate.query(sql, new GroupHistoryMapper(), memid);
	}
	
	@Override
	public void deleteGroupHistory(int memid) {
		String sql = "DELETE FROM group_history WHERE member_id=?";
		jdbcTemplate.update(sql, memid);
		
	}

	@Override
	public void deleteMB(int memid, String email) {
		String sql = "DELETE from MB WHERE member_id=? and email=?";
		//이메일 말고 다른 것으로도 변경가능~
		jdbcTemplate.update(sql, memid, email);
	}
	
    @Override
	public List<Map<String, Object>> getAllGroupId() {
		String sql = "select group_id as groupId, "
				    +"group_name as groupName "
				    +"from groups";
		return jdbcTemplate.queryForList(sql);
	}

    @Override
	public List<Map<String, Object>> getAllManagerId() {
		String sql = "SELECT DISTINCT "
				   + "member.manager_id, manager.first_name, manager.last_name "
				   + "FROM MB member "
				   + "JOIN MB manager ON (member.manager_id = manager.member_id)";
		return jdbcTemplate.queryForList(sql);
	}

	@Override
	public List<Map<String, Object>> getAllJobId() {
		String sql = "select job_id as jobId, job_title as title from job";
		return jdbcTemplate.queryForList(sql);
	}

}

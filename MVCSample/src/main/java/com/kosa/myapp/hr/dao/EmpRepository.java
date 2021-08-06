package com.kosa.myapp.hr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kosa.myapp.hr.model.EmpVO;

/* IEmpRepository 인터페이스를 구현한 빈이 두 개. EmpRepository.java 와 EmpMapper.xml 두 개.*/
@Repository
public class EmpRepository implements IEmpRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private class EmpMapper implements RowMapper<EmpVO>{
		@Override
		public EmpVO mapRow(ResultSet rs, int count) throws SQLException {
			EmpVO emp = new EmpVO();
			emp.setEmployeeId(rs.getInt("employee_id"));
			emp.setFirstName(rs.getString("first_name"));
			emp.setLastName(rs.getString("last_name"));
			emp.setEmail(rs.getString("email"));
			emp.setPhoneNumber(rs.getString("phone_number"));
			emp.setHireDate(rs.getDate("hire_date"));
			
			emp.setJobId(rs.getString("job_id"));
			emp.setSalary(rs.getDouble("salary"));
			emp.setCommissionPct(rs.getDouble("commission_pct"));
			emp.setManagerId(rs.getInt("manager_id"));
			emp.setDepartmentId(rs.getInt("department_id"));
			return emp;
		}
	}
	
	@Override
	public int getEmpCount() {
		String sql = "select count(*) from employees";
		return jdbcTemplate.queryForObject(sql, Integer.class); //jdbcTemplate.queryForInt(sql) Spring v.3점대
	}

	@Override
	public int getEmpCount(int deptid) {
		String sql = "select count(*) from employees where department_id = ?";
		return jdbcTemplate.queryForObject(sql, Integer.class, deptid);
	}

	@Override
	public List<EmpVO> getEmpList() {
		String sql = "select * from employees";
		return jdbcTemplate.query(sql, new EmpMapper());
	}

	@Override
	public EmpVO getEmpInfo(int empid) {
		String sql = "select * from employees where employee_id = ?";
		return jdbcTemplate.queryForObject(sql, new EmpMapper(), empid);
	}

	@Override
	public void updateEmp(EmpVO emp) {
		String sql = "update employees "
				+ "set first_name = ?, last_name = ?, email = ?,"
				+ "phone_number = ?, hire_date = ?, job_id = ?,"
				+ "salary = ?, commission_pct = ?, manager_id = ?,"
				+ "department_id = ? where employee_id = ?";
		jdbcTemplate.update(sql, emp.getFirstName(),
				emp.getLastName(),
				emp.getEmail(),
				emp.getPhoneNumber(),
				emp.getHireDate(),
				emp.getJobId(),
				emp.getSalary(),
				emp.getCommissionPct(),
				emp.getManagerId(),
				emp.getDepartmentId(),
				emp.getEmployeeId()
				);

	}

	@Override
	public void insertEmp(EmpVO emp) {
		String sql = "insert into employees "
				+ "(employee_id, first_name, last_name, email, "
				+ "phone_number, hire_date, job_id, salary, "
				+ "commission_pct, manager_id, department_id) "
				+ "values (?,?,?,?,?, sysdate, ?,?,?,?,?)";
		jdbcTemplate.update(sql,
				emp.getEmployeeId(),
				emp.getFirstName(),
				emp.getLastName(),
				emp.getEmail(),
				emp.getPhoneNumber(),
				emp.getJobId(),
				emp.getSalary(),
				emp.getCommissionPct(),
				emp.getManagerId(),
				emp.getDepartmentId()
				);

	}

	@Override
	public void deleteJobHistory(int empid) {
		String sql = "delete from job_history where employee_id = ?";
		jdbcTemplate.update(sql, empid);

	}

	@Override
	@Transactional("txManager")
	public void deleteEmp(int empid, String email) {
		String sql = "delete from employees where employee_id = ? and email = ?";
		jdbcTemplate.update(sql, empid, email);

	}

	@Override
	public List<Map<String, Object>> getAllDeptId() {
		String sql = "select department_id as departmentId, "
				+ "          department_name as departmentName "
				+ "   from departments";
		return jdbcTemplate.queryForList(sql);
	}

	@Override
	public List<Map<String, Object>> getAllJobId() {
		String sql = "select job_id as jobId, job_title as title from jobs";
		return jdbcTemplate.queryForList(sql);
	}

	@Override
	public List<Map<String, Object>> getAllManagerId() {
		String sql = "select distinct "
				+ " m.manager_id as managerId, e.first_name as firstName "
				+ " from employees m join employees e "
				+ " on m.manager_id = e.employee_id "
				+ " order by m.manager_id";
		return jdbcTemplate.queryForList(sql);
	}

}

package kr.re.kitri.helloboot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.re.kitri.helloboot.model.LombokEmployee;

@Repository
public class EmployeeDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public LombokEmployee insertEmployee(LombokEmployee emp) {
		String sql = "INSERT INTO EMPLOYEE (EMP_ID,NAME,POSITION,AGE) VALUES(?,?,?,? )";
		jdbcTemplate.update(sql, emp.getEmpId(),emp.getName(),emp.getPosition(),emp.getAge());
		
		
		return emp;
	}

	public List<LombokEmployee> selectEmployees() {
		String sql = "SELECT EMP_ID,NAME,POSITION,AGE FROM EMPLOYEE";
		  List<LombokEmployee> employees = jdbcTemplate.query(sql,new RowMapper<LombokEmployee>() {
		         @Override
		         public LombokEmployee mapRow(ResultSet rs, int rowNum) throws SQLException {
		        	 LombokEmployee emp = new LombokEmployee();
		            emp.setEmpId(rs.getInt(1));
		            emp.setName(rs.getString(2));
		            emp.setPosition(rs.getString(3));
		            emp.setAge(rs.getInt(4));
		            
		            return  emp;
		         }
		      });
		      return employees;
		   }

	public LombokEmployee selectEmployeeById(String empId) {
		String sql = "SELECT EMP_ID,NAME,POSITION,AGE FROM EMPLOYEE WHERE EMP_ID = ?";
		LombokEmployee employee = jdbcTemplate.queryForObject(sql, new Object[] {empId}, new RowMapper<LombokEmployee>() {
			@Override
	         public LombokEmployee mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	 LombokEmployee emp = new LombokEmployee();
	            emp.setEmpId(rs.getInt(1));
	            emp.setName(rs.getString(2));
	            emp.setPosition(rs.getString(3));
	            emp.setAge(rs.getInt(4));
	            
	            return  emp;
	         }
		});
		
		return employee;
	}

}

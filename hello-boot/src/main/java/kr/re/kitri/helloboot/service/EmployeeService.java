package kr.re.kitri.helloboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.re.kitri.helloboot.dao.EmployeeDao;
import kr.re.kitri.helloboot.model.LombokEmployee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	public LombokEmployee registerEmployee(LombokEmployee emp) {
		return employeeDao.insertEmployee(emp);
	}

	public List<LombokEmployee> retrieveEmployees() {
		return employeeDao.selectEmployees();
	}

	public LombokEmployee searchEmployee(String empId) {
		return employeeDao.selectEmployeeById(empId);
	}

}

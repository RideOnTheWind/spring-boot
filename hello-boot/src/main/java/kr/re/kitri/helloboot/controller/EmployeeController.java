package kr.re.kitri.helloboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.re.kitri.helloboot.model.LombokEmployee;
import kr.re.kitri.helloboot.service.EmployeeService;

@RestController
public class EmployeeController {
	
	private static Logger logger = LoggerFactory.getLogger(EmployeeController.class); 
	
	@Autowired
	private EmployeeService service;
	
	//직원 전체 조회
	@GetMapping("/employees")
	public List<LombokEmployee> searchEmployees() {
		
		return service.retrieveEmployees();
		
	}
	
	//직원 번호로 상세 조회
	@GetMapping("/employees/{empId}")
	public LombokEmployee searchEmployeeById(@PathVariable String empId ) {
		
		logger.debug("=======================================");
		logger.debug("searchEmployeeById++++++empId = "+empId);
		logger.debug("=======================================");
		
		return service.searchEmployee(empId);
	}
	
	//직원 삭제 
	@DeleteMapping("/employees/{empId}")
	public LombokEmployee deleteEmployeeById(@PathVariable String empId ) {
		System.out.println("deleteEmployeeById++++++empId = "+empId);
		LombokEmployee emp = new LombokEmployee();
		emp.setEmpId(Integer.parseInt(empId));
		return emp;
	}
	
	//직원 등록 JSON
	@PostMapping("/employees")
	public LombokEmployee registerEmployeeJson(@RequestBody  LombokEmployee emp ) {
		
		System.out.println(emp);
		LombokEmployee registered = service.registerEmployee(emp);
		
		return registered;
	}
	
	//직원 정보 수정
	@PutMapping("/employees/{empId}")
	public LombokEmployee modifyEmployee(@PathVariable String empId ) {
		System.out.println("modifyEmployee++++++empId = "+empId);
		return null;
	}

}




////직원 등록
//@PostMapping("/employees")
//public LombokEmployee registerEmployee( @RequestParam int empId,
//																				@RequestParam String name,
//																				@RequestParam String position,
//																				@RequestParam int age) {
//	LombokEmployee emp = new LombokEmployee();
//	emp.setEmpId(empId);
//	emp.setName(name);
//	emp.setPosition(position);
//	emp.setAge(age);
//	
//	System.out.println(emp.toString());
//	
//	return emp;
//}
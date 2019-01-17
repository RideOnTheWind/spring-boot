package kr.re.kitri.helloboot.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.re.kitri.helloboot.model.LombokEmployee;

@RestController
public class HomeController {
	
	@GetMapping("/")
	public String rootGet() {
		return " root!!!"; 
	}
	
	@GetMapping("/hello")
	public String helloGet() {
		return "Hello World!!!"; 
	}
	
	@PostMapping("/hello")
	public String helloPost() {
		return "Hello Post";
	}
	
	@GetMapping("/emp/235")
	public LombokEmployee lombokEmployee() {
		LombokEmployee dummyLombok = new LombokEmployee();
		
		dummyLombok.setEmpId(1234);
		dummyLombok.setName("kim");
		dummyLombok.setPosition("Lombok_G1");
		dummyLombok.setAge(20);
		
		System.out.println(dummyLombok.toString());
		
		return dummyLombok;
	}
}

package kr.re.kitri.helloboot.model;

import lombok.Data;

@Data
public class LombokEmployee {
	private int empId;
	private String name;
	private String position;
	private int age;
	
	
	public LombokEmployee(int empId, String name, String position, int age) {
		super();
		this.empId = empId;
		this.name = name;
		this.position = position;
		this.age = age;
	}
	public LombokEmployee() {
		
	}
	
	
}

package kr.re.kitri.helloboot.util;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import kr.re.kitri.helloboot.model.LombokEmployee;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public  LombokEmployee handleBaseException(Exception e) {
		
		return new LombokEmployee();
		
		
//		return "Occured Error!!!";
	}

}

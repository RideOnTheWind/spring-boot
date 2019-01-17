package kr.re.kitri.helloboot.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import kr.re.kitri.helloboot.model.LombokEmployee;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeDaoTest {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Test
	public void testSelectEmployees() {
		List<LombokEmployee> result = employeeDao.selectEmployees();
		Assert.assertTrue(result.size() > 0 );
	}
	
	@Test
	public void testSelectEmployeeById() {
		LombokEmployee result = employeeDao.selectEmployeeById("4");
		Assert.assertTrue(result.getEmpId() ==4);
		Assert.assertTrue("park".equals(result.getName()));
		Assert.assertTrue("G3".equals(result.getPosition()));
		Assert.assertTrue(result.getAge() ==40);
	}
	
	@Ignore
	public void testInsertEmployee() {
		LombokEmployee emp = new LombokEmployee(6,"park","G2",40);

		LombokEmployee inserted = employeeDao.insertEmployee(emp);
		Assert.assertTrue(inserted.getEmpId() ==6);
		Assert.assertTrue("park".equals(inserted.getName()));
		Assert.assertTrue("G3".equals(inserted.getPosition()));
		Assert.assertTrue(inserted.getAge() ==40);
	}
}

package telran.employees.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import telran.employees.service.Company;
import telran.employees.service.CompanyImpl;
import telran.employees.dto.Employee;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CompanyTests {
//TODO
	final static String TEST_FILE_NAME = "test.data";
	
	Company company;
	Employee employee1;
	Employee employee2;
	@BeforeEach
	void setUp() throws Exception {
		//TODO
	    company = new CompanyImpl();
	    employee1 = new Employee(1L, "Alex", "IT", 1000, LocalDate.of(1990, 1, 1));
	    employee2 = new Employee(2L, "Max", "HR", 1500, LocalDate.of(1985, 5, 15));
	}

	@Test
	void testAddEmployee() {
		//TODO
	    assertTrue(company.addEmployee(employee1));
	    assertFalse(company.addEmployee(employee1)); // adding same employee again
	    assertEquals(employee1, company.getEmployee(1L));
	}

	@Test
	void testRemoveEmployee() {
		//TODO
	    company.addEmployee(employee1);
	    assertEquals(employee1, company.removeEmployee(1L));
	    assertNull(company.getEmployee(1L));
	}

	@Test
	void testGetEmployee() {
		//TODO
	    company.addEmployee(employee1);
	    assertEquals(employee1, company.getEmployee(1L));
	    assertNull(company.getEmployee(3L)); // employee with id 3 doesn't exist
	}

	@Test
	void testGetEmployees() {
		//TODO
	    company.addEmployee(employee1);
	    company.addEmployee(employee2);
	    assertEquals(2, company.getEmployees().size());
	}
	
	@Test
	@Order(2)
	void testRestore() {
		//TODO
	    Company newCompany = new CompanyImpl();
	    newCompany.restore(TEST_FILE_NAME);
	    assertEquals(employee1, newCompany.getEmployee(1L));
	}
	@Test
	@Order(1)
	void testSave() {
		//TODO
	    company.addEmployee(employee1);
	    company.save(TEST_FILE_NAME);
	    File file = new File(TEST_FILE_NAME);
	    assertTrue(file.exists());
	}

}

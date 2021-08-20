package com.employee.management.service;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.employee.management.model.Employee;
import com.employee.management.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
public class EmployeeServiceTest {

	@InjectMocks
	private EmployeeService employeeService;

	@Mock
	private EmployeeRepository employeeRepository;

	// fetching all employees
	@Test
	public void getAllEmployees() {
		List<Employee> emps = new ArrayList<Employee>();
		Employee employee = new Employee();
		emps.add(employee);
		Mockito.when(employeeRepository.findAll()).thenReturn(emps);
		emps = employeeService.getAllEmployees();
		assertTrue(emps.size() > 0);
	}

}

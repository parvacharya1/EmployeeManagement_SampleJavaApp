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

import com.employee.management.model.Department;
import com.employee.management.repository.DepartmentRepository;

@RunWith(SpringRunner.class)
public class DepartmentServiceTest {

	@InjectMocks
	private DepartmentService departmentService;

	@Mock
	private DepartmentRepository departmentRepository;

	// fetching all employees
	@Test
	public void getAllEmployees() {
		List<Department> departments = new ArrayList<Department>();
		Department department = new Department();
		departments.add(department);
		Mockito.when(departmentRepository.findAll()).thenReturn(departments);
		departments = departmentService.getAllDepartments();
		assertTrue(departments.size() > 0);
	}

}
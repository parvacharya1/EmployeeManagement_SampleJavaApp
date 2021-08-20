package com.employee.management.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.model.Employee;
import com.employee.management.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	static final Logger logger = LogManager.getLogger(EmployeeController.class.getName());

	@Autowired
	private EmployeeService employeeService;

	// displaying list of all employees
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployee() {
		return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(), HttpStatus.OK);
	}

	// displaying employee by id
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int id) {
		return new ResponseEntity<Employee>(employeeService.getEmployee(id), HttpStatus.OK);

	}

	// inserting employee
	@PostMapping
	public ResponseEntity addEmployees(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	// updating employee by id
	@PutMapping("/{id}")
	public ResponseEntity updateEmployee(@RequestBody Employee e, @PathVariable int id) {
		employeeService.updateEmployee(e, id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	// deleting all employees
	@DeleteMapping
	public ResponseEntity deleteAllEmployees() {
		employeeService.deleteAllEmployees();
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	// deleting employee by id
	@DeleteMapping("/{id}")
	public ResponseEntity deleteEmployeeByID(@RequestBody Employee e, @PathVariable int id) {
		employeeService.deleteEmployeeByID(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	// updating/ patching employee by id
	@PatchMapping("/{id}")
	public ResponseEntity patchEmployeeByID(@RequestBody Employee e, @PathVariable int id) {
		employeeService.patchEmployee(e, id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

}

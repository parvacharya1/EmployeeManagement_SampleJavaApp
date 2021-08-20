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

import com.employee.management.model.Department;
import com.employee.management.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

	static final Logger logger = LogManager.getLogger(DepartmentController.class.getName());

	@Autowired
	private DepartmentService departmentService;

	// displaying list of all department
	@GetMapping
	public ResponseEntity<List<Department>> getAllDepartment() {
		return new ResponseEntity<List<Department>>(departmentService.getAllDepartments(), HttpStatus.OK);
	}

	// displaying department by id
	@GetMapping("/{id}")
	public ResponseEntity<Department> getDepartment(@PathVariable int id) {
		return new ResponseEntity<Department>(departmentService.getDepartment(id), HttpStatus.OK);
	}

	// inserting department
	@PostMapping
	public ResponseEntity addDepartment(@RequestBody Department department) {
		departmentService.addDepartment(department);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	// updating department by id
	@PutMapping("/{id}")
	public ResponseEntity updateDepartment(@RequestBody Department d, @PathVariable int id) {
		departmentService.updateDepartment(d, id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	// deleting all department
	@DeleteMapping
	public ResponseEntity deleteAllDepartments() {
		departmentService.deleteAllDepartment();
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	// deleting department by id
	@DeleteMapping("/{id}")
	public ResponseEntity deleteDepartmentByID(@RequestBody Department d, @PathVariable int id) {
		departmentService.deleteDepartmentByID(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	// updating/ patching department by id
	@PatchMapping("/{id}")
	public ResponseEntity patchDepartmentByID(@RequestBody Department d, @PathVariable int id) {
		departmentService.patchDepartment(d, id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
}

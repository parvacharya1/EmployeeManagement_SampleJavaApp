package com.employee.management.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.employee.management.model.ErrorDto;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorDto> handleCityNotFoundException(EmployeeNotFoundException ex, WebRequest request) {
		ErrorDto errorDto = new ErrorDto();
		errorDto.setTimestamp(LocalDateTime.now());
		errorDto.setMessage("Employee Not found");
		return new ResponseEntity<ErrorDto>(errorDto, HttpStatus.NOT_FOUND);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<ErrorDto> handleDeptNotFoundException(DepartmentNotFoundException ex, WebRequest request) {
		ErrorDto errorDto = new ErrorDto();
		errorDto.setTimestamp(LocalDateTime.now());
		errorDto.setMessage("Department not found");
		return new ResponseEntity<ErrorDto>(errorDto, HttpStatus.NOT_FOUND);
	}

}

package com.first_crud.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.first_crud.demo.model.Employee;
import com.first_crud.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@PostMapping("/saveEmployee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.addEmployee(employee), HttpStatus.CREATED);
	}

	@GetMapping("/getEmployee")
	public List<Employee> getEmployee() {
		return employeeService.getEmployee();
	}

	@GetMapping("/getEmployee/{id}")
	public Employee getById(@PathVariable("id") int id) {
		return employeeService.getById(id);
	}

	@PutMapping("/updateEmployee/{id}")
	public Employee updateEmployee(@PathVariable("id") int id, @RequestBody Employee employe) {
		return employeeService.updateEmployee(id, employe);
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteById(@PathVariable("id") int id) {
		employeeService.deleteById(id);
		return "Deleted Successfully";
	}
}

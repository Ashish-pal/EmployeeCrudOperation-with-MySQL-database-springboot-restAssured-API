package com.first_crud.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.first_crud.demo.model.Employee;
import com.first_crud.demo.repository.EmployeeRepository;


@Service
public class EmployeeServiceImplement implements EmployeeService {

	private EmployeeRepository employeeRepo;

	public EmployeeServiceImplement(EmployeeRepository employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	@Override
	public List<Employee> getEmployee() {
		return employeeRepo.findAll();
	}

	@Override
	public Employee getById(int id) {
		return employeeRepo.findById(id).get();
	}

	@Override
	public Employee updateEmployee(int id, Employee employee) {
		Employee updatemployee = employeeRepo.findById(id).get();
		updatemployee.setFname(employee.getFname());
		updatemployee.setLname(employee.getLname());
		updatemployee.setEmail(employee.getEmail());
		return employeeRepo.save(updatemployee);
	}

	@Override
	public void deleteById(int id) {
		employeeRepo.deleteById(id);
	}
}

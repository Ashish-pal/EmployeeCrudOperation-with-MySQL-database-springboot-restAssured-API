package com.first_crud.demo.service;

import java.util.List;
import com.first_crud.demo.model.Employee;

public interface EmployeeService {

	public Employee addEmployee(Employee employee);

	public List<Employee> getEmployee();

	public Employee getById(int id);

	Employee updateEmployee(int id, Employee employee);

	void deleteById(int id);

}

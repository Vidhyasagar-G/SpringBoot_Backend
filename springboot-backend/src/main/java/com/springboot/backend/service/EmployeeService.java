package com.springboot.backend.service;

import java.util.List;

import com.springboot.backend.model.Employee;






public interface EmployeeService {



	

	public List<Employee> get();
	Employee get(Long id);
	Employee save(Employee employee);
	
	public void deleteEmployee(long id);
	//public void save(Employee employee);
	//public List<Employee> findAll();
	//public List<Employee> findByNameContaining(String search);

	





	
}

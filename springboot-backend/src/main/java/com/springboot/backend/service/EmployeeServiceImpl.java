package com.springboot.backend.service;

import java.util.List
;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.backend.model.Employee;
import com.springboot.backend.repository.EmployeeRepository;





@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Override
	public List<Employee> get() {
		return employeeRepository.findAll();
	}
//	
//	@Override
//	public Employee save(Employee employee) {
//		return employeeRepository.save(employee);
//	}
	
	@Override
	public Employee get(Long id) {
		return employeeRepository.findById(id).isPresent() ? employeeRepository.findById(id).get() : null;
	}

	@Override
	public void deleteEmployee(long id) {
		employeeRepository.deleteById(id);
		
	}

	@Override
	public Employee save(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	

	
	

	

}






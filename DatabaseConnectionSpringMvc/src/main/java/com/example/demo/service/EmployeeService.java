package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	public EmployeeRepository emprepo;
	
	public EmployeeService(EmployeeRepository emprepo) {
		this.emprepo=emprepo;
	}
	public List<Employee> getAllEmployee(){
		return emprepo.findAll();
	}
	public void saveEmployee(Employee employee) {
        emprepo.save(employee);
    }
}
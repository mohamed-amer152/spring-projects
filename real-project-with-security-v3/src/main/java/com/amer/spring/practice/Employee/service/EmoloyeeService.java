package com.amer.spring.practice.Employee.service;

import java.util.List;

import com.amer.spring.practice.Employee.entity.Employee;

public interface EmoloyeeService {
	
	public List<Employee> findall();
	
	public Employee findsingale(int id);

	public void save(Employee empl) ;
	
	public void delete(int id);
	
	public List<Employee> Searche(String name );
	
}

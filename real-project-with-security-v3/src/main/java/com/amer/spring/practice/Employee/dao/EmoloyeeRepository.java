package com.amer.spring.practice.Employee.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amer.spring.practice.Employee.entity.Employee;

public interface EmoloyeeRepository extends JpaRepository<Employee, Integer> {
	
	public List<Employee> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String name, String lName);
}

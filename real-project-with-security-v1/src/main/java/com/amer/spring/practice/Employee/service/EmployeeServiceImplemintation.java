package com.amer.spring.practice.Employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amer.spring.practice.Employee.dao.EmoloyeeRepository;
import com.amer.spring.practice.Employee.entity.Employee;

@Service
public class EmployeeServiceImplemintation implements EmoloyeeService {


	@Autowired
	private EmoloyeeRepository emprepo ;
	
	@Override
	public List<Employee> findall() {
		
		List<Employee> list = emprepo.findAll();
 		return list;
	}

	@Override
	public Employee findsingale(int id) {
		Optional<Employee> emp = emprepo.findById(id);
		Employee result ;
		if (emp.isPresent()) {
			result = emp.get();
			return result ;
		}
		else
		{
			return null ;
		}
	}

	@Override
	public void save(Employee empl) {
 
		emprepo.save(empl);
	}

	@Override
	public void delete(int id) {
 
		emprepo.deleteById(id);
	}

}

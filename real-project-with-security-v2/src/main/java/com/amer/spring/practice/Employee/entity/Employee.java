package com.amer.spring.practice.Employee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private int id ;
	
	@Column(name ="first_name")
	private String firstName ;
	
	@Column(name ="last_name")
	private String lastName ;
	
	@Column(name ="email")
	private String email ;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return firstName;
	}

	public void setFirst_name(String first_name) {
		this.firstName = first_name;
	}

	public String getLast_name() {
		return lastName;
	}

	public void setLast_name(String last_name) {
		this.lastName = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Employee(String first_name, String last_name, String email) {
		this.firstName = first_name;
		this.lastName = last_name;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", first_name=" + firstName + ", last_name=" + lastName + ", email=" + email
				+ "]";
	}
	
	

}

package com.learnings.demo.payroll;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
 
@Entity
@Table(name="employee")
public class Employee {
	
    @Override
	public String toString() {
		return "Employee [Id=" + Id + ", name=" + name + ", role=" + role + "]";
	}

	public Long getId() {	
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Id
    @GeneratedValue
	private Long Id;
	private String name;
	private String role;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String name, String role) {
		this.name=name;
		this.role=role;
	}
	
}

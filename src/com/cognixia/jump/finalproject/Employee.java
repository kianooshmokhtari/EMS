package com.cognixia.jump.finalproject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Employee {
	
//This is the Employee Class

	private static int idCounter = 1;

	private int employeeId;
	private String firstName;
	private String lastName;
	private int salary;
	private String department;
	private LocalDate employmentDate;

	public Employee(String firstName, String lastName, int salary, String department, LocalDate date) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.department = department;
		this.employeeId = idCounter++;
		this.employmentDate = date;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getId() {
		return employeeId;
	}
	
	public LocalDate getEmploymentDate() {
		return employmentDate;
	}
	
	public void setEmploymentDate(LocalDate date) {
		this.employmentDate = date;
	}

	@Override
	public String toString() {
		return "Employee [ID:" + employeeId + ", FirstName: " + firstName +" LastName: " + lastName + ", Salary: $" + salary + ", Department: " + department + ", Employment Date: " + employmentDate.toString() + "]";
	}
	
	
	

}
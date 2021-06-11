package com.cognixia.jump.finalproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.time.LocalDate;;

public class Employees {

	List<Employee> employees = new ArrayList<>();
	int counter = 0;

	private int employeeSelectedID;
	private boolean itemSelected = false;

	public void addEmployee(String firstName, String lastName, int salary, String depratment, int year, int month,
			int day) {

		Employee e = new Employee(firstName, lastName, salary, depratment, LocalDate.of(year, month, day));

		employees.add(e);
		
		counter++;

		System.out.println("Added: " + e.toString());

	}
	
	public boolean isEmpty() {
		if(counter >0)
			return false;
		else
			return true;
	}

	public void printAllEmployees() {
		employees.stream().filter(x -> (x != null)).forEach(System.out::println);
	}

	public void printAllNames() {

		employees.stream().forEach(x -> System.out.println(x.getFirstName() + " " + x.getLastName()));
	}

	public int selectEmployee(String firstName, String lastName) {

		List<Employee> emp = employees.stream().filter(e -> e.getFirstName().replaceFirst("\\s++$", "")
				.equalsIgnoreCase(firstName.replaceFirst("\\s++$", ""))
				&& e.getLastName().replaceFirst("\\s++$", "").equalsIgnoreCase(lastName.replaceFirst("\\s++$", "")))
				.collect(Collectors.toList());

		if (!emp.isEmpty()) {
			employeeSelectedID = emp.get(0).getId();
			System.out.println("Employee Selected: " + emp.get(0).getFirstName() + " " + emp.get(0).getLastName()
					+ " with Employee ID: " + emp.get(0).getId());
			System.out.println(employeeSelectedID);
			setItemSelected(true);
			return 1;
		} else {
			System.out.println("No Employees Found");
			setItemSelected(false);
			return 0;
		}

	}

	public void editFirstName(String name) {
		if (itemSelected) {
			for (Employee e : employees) {
				if (e.getId() == employeeSelectedID) {
					e.setFirstName(name);
				}
			}
		} else
			System.out.println("Please Select an Employee");
	}

	public void editLastName(String newLastName) {
		if (itemSelected) {
			for (Employee e : employees) {
				if (e.getId() == employeeSelectedID) {
					e.setLastName(newLastName);
				}
			}
		} else
			System.out.println("Please Select an Employee");
	}

	public void editSalary(int newSalary) {
		if (itemSelected) {
			for (Employee e : employees) {

				if (e.getId() == employeeSelectedID) {
					e.setSalary(newSalary);
				}
			}

		} else
			System.out.println("Please Select an Employee");
	}

	public void editEmploymentDate(int day, int month, int year) {
		if (itemSelected) {
			for (Employee e : employees) {
				if (e.getId() == employeeSelectedID) {
					e.setEmploymentDate(LocalDate.of(year, month, day));
				}
			}
		}
	}

	public void EditDepartment(String newDepartmentName) {
		if (itemSelected) {
			for (Employee e : employees) {
				if (e.getId() == employeeSelectedID) {
					e.setDepartment(newDepartmentName);
				}
			}
		}
	}

	public void deleteEmployee() {
		if (itemSelected) {
			for (int i = 0; i < employees.size(); i++) {
				if (employees.get(i).getId() == employeeSelectedID) {
					// employees.set(i, null);
					employees.remove(i);
					counter--;
					System.out.println("deleted");
				}
			}
		}
	}

	public int getEmployeeSelectedID() {
		return employeeSelectedID;
	}

	public void setEmployeeSelectedID(int id) {
		employeeSelectedID = id;
	}

	public boolean isItemSelected() {
		return itemSelected;
	}

	public void setItemSelected(boolean itemSelected) {
		this.itemSelected = itemSelected;
	}

}

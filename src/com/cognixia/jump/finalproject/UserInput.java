package com.cognixia.jump.finalproject;

import java.time.YearMonth;
import java.util.InputMismatchException;
import java.util.Scanner;

//This is the class to handle userInputs for EMS
public class UserInput {

	//just another comment for git/github testing

	//another test

	private String firstName;
	private String lastName;
	private int salary;
	private String phoneNumber;
	private String departmentName;
	private int day;
	private int month;
	private int year;

	// method that returns true if userInput for firstName is Valid otherwise false
	public boolean getUserInputFirstName() {
		System.out.println("Enter First Name: ");
		Scanner input = new Scanner(System.in);
		String firstName = input.nextLine();
		if (firstName.isBlank()) {
			System.out.println("Invalid Input");
			return false;
		}
		setFirstName(firstName);
		return true;
	}

	// method that returns true if userInput for firstName is Valid, otherwise false
	public boolean getUserInputLastName() {
		System.out.println("Enter Last Name");
		Scanner input = new Scanner(System.in);
		String lastName = input.nextLine();
		if (lastName.isBlank()) {
			System.out.println("Invalid Input");
			return false;
		}
		setLastName(lastName);
		return true;
	}

	// method that returns true if a number above 0 is inputed otherwise false
	public boolean getUserSalaryInput() throws InputOutOfRangeException {
		System.out.println("Enter Employee Salary: ");
		int userInput = 0;
		try {
			Scanner input = new Scanner(System.in);
			int sal = input.nextInt();
			if (sal < 0) {
				throw new InputOutOfRangeException("Salary Out Of Range");

			}
			setSalary(sal);
		} catch (InputMismatchException e) {
			System.out.println("Please Only Enter Numbers for Salary: ");
			return false;
		} catch (InputOutOfRangeException e) {
			System.out.println("Please enter a number above 0");
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("fsdfsd");
			return false;
		}
		return true;

	}

	//print menu
	public void printMenu() {
		System.out.println("Enter a number from the menu");
		System.out.println("---------------");
		System.out.println("1. List All Employees");
		System.out.println("2. Add New Employee");
		System.out.println("3. Edit Employee");
		System.out.println("4. Delete Employee");
		System.out.println("5. Exit Program");
		System.out.println("---------------");

	}
	//method that returns true if the day input by user is in the correct range for corresponding
	//month and year. Feb has 28 days so input should be in range of 1-28 for Feb
	public boolean getUserInputForDay() throws MonthOutOfRangeException {

		int month = getMonth();
		int year = getYear();

		// calculate number of day in that month
		YearMonth date = YearMonth.of(year, month);
		int daysInMonth = date.lengthOfMonth();
		String monthName = date.getMonth().toString();

		// System.out.println("Test: " + monthName);

		System.out.println("Enter Employment Day (1-" + daysInMonth + ")");
		try {
			Scanner input = new Scanner(System.in);
			int dayofmonth = input.nextInt();
			if (dayofmonth < 1 || dayofmonth > daysInMonth) {
				throw new MonthOutOfRangeException(1, 3, "4343", "434343");
			}
			setDay(dayofmonth);

		} catch (InputMismatchException e) {
			return false;
		} catch (MonthOutOfRangeException e) {
			System.out.println("Please enter a day in between 1 and " + daysInMonth);
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}
	//method that returns true if user input is in 1-12 range for months. otherwise false
	public boolean getUserInputForMonth() throws InputOutOfRangeException {
		System.out.println("Enter Employment Month (1-12)");
		try {
			Scanner input = new Scanner(System.in);
			int month = input.nextInt();
//			System.out.println("Right before check Month = " + month);

			if (month < 1 || month > 12) {
				// System.out.println("Inside month check");
				throw new InputOutOfRangeException("Please Enter between 1 - 12");
			}

			setMonth(month);
		} catch (InputMismatchException e) {
			return false;
		} catch (InputOutOfRangeException e) {
			System.out.println("Invalid Input");
			e.toString();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}
	//method for getting user input of year
	public boolean getUserInputForYear() {
		System.out.println("Enter Employment Year (YYYY)");
		try {
			Scanner input = new Scanner(System.in);
			setYear(input.nextInt());
		} catch (InputMismatchException e) {
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}
	//method for getting userinput for Department
	public boolean getUserInputDepartment() {
		System.out.println("Enter Department Name");
		Scanner input = new Scanner(System.in);
		setDepartmentName(input.nextLine());
		return true;
	}

	// reset input class
	public void resetInput() {
		firstName = null;
		lastName = null;
		salary = 0;
		phoneNumber = null;
		departmentName = null;
		day = 0;
		month = 0;
		year = 0;

	}

	// method for printing options for editing an employee
	public int printEditEmployeeMenu(String first, String last) {
		System.out.println("You are editing " + first + " " + last + "'s record.");
		System.out.println("Pick from the following option");
		System.out.println("1. Edit First Name");
		System.out.println("2. Edit Last Name");
		System.out.println("3. Edit Salary");
		System.out.println("4. Edit Department");
		System.out.println("5. Employment Date");

		int menuNumberPicked = -1;
		boolean correctInput = false;
		while (!correctInput) {
			try {
				Scanner input = new Scanner(System.in);
				menuNumberPicked = input.nextInt();
				correctInput = true;

			} catch (InputMismatchException e) {
				e.printStackTrace();

			}

		}
		return menuNumberPicked;
	}

	
	//setters and getters for this class
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}

package com.cognixia.jump.finalproject;

import java.util.Scanner;

public class EMS {

//where program runs main method

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employees employees = new Employees();
		UserInput userInput = new UserInput();
		boolean mainProgram = true;
		System.out.println("Welcome to EMS!");
		while (mainProgram) {

			// reset saved inputs from previous iteration to null
			userInput.resetInput();

			userInput.printMenu();

			Scanner input = new Scanner(System.in);

			int menuNumber = input.nextInt();

			switch (menuNumber) {
			case 1:
				printAll(employees);
				break;
			case 2:
				try {
					createEmployee(userInput, employees);
				} catch (InputOutOfRangeException e) {
					e.printStackTrace();
				} catch (MonthOutOfRangeException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					editEmployee(userInput, employees);
				} catch (InputOutOfRangeException e) {
					e.printStackTrace();

				} catch (MonthOutOfRangeException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 4:
				deleteEmployee(userInput, employees);
				break;
			case 5:
				System.exit(0);

			default:
				System.out.println("deafault");

			}

		}

	}
	//print all Employee Names
	public static void printAll(Employees e) {
		if (e.isEmpty()) {
			System.out.println("No Employees to show. Please add Employees at Main Menu");
		} else {
			e.printAllEmployees();
		}
	}
	//deletes an employee. Call UserInput class to store which employee to delete 
	public static void deleteEmployee(UserInput input, Employees e) {

		if (e.isEmpty()) {
			System.out.println("No Employees to Delete. Please add Employees at Main Menu.");
		} else {
			input.resetInput();
			int found = -1;

			boolean correct = false;

			while (!correct) {
				correct = input.getUserInputFirstName();

			}

			correct = false;

			while (!correct) {
				correct = input.getUserInputLastName();
			}

			found = e.selectEmployee(input.getFirstName(), input.getLastName());


			if (found > 0) {
				e.deleteEmployee();
			}
		}
	}

	public static void editEmployee(UserInput input, Employees e)
			throws InputOutOfRangeException, MonthOutOfRangeException {

		if (e.isEmpty()) {
			System.out.println("No Employees to Edit. Add Employees at Main Menu");

		} else {

			input.resetInput();

			// boolean correct = false;
			int found = -1;
			int option = -1;

			boolean correct = false;

			while (!correct) {
				correct = input.getUserInputFirstName();

			}

			correct = false;

			while (!correct) {
				correct = input.getUserInputLastName();
			}

			found = e.selectEmployee(input.getFirstName(), input.getLastName());

			// SelectEmployee method return 0 if no Employees were found or 1 if employee
			// was found
//		while (found == -1 || found == 0) {
//			
//			input.getUserInputFirstName();
//			input.getUserInputLastName();
//
//			// employee found or not
//			found = e.selectEmployee(input.getFirstName(), input.getLastName());
//		}
			// checks if employee was found, if so pick an option from the menu
			// UserInput class has a method called printEditEmployee Menu to take userinput
			// for what field in the record to edit
			//
			if (found == 1) {
				option = input.printEditEmployeeMenu(input.getFirstName(), input.getLastName());
			}

			input.resetInput();

			boolean keepAsking = false;

			switch (option) {
			case 1:
				input.getUserInputFirstName();
				e.editFirstName(input.getFirstName());
				System.out.println(" First Name Edit Complete");
				break;
			case 2:
				input.getUserInputLastName();
				e.editLastName(input.getLastName());
				System.out.println("Last Name Edit Complete");
				break;
			case 3:
				while (!keepAsking) {
					keepAsking = input.getUserSalaryInput();

					e.editSalary(input.getSalary());
					System.out.println("Salary Edit Complete");
				}
				break;
			case 4:
				input.getUserInputDepartment();
				e.EditDepartment(input.getDepartmentName());
				System.out.println("Department Name Edit Completed");
				break;
			case 5:

				while (!keepAsking) {
					keepAsking = input.getUserInputForYear();

				}

				keepAsking = false;
				while (!keepAsking) {
					keepAsking = input.getUserInputForMonth();

				}

				keepAsking = false;

				while (!keepAsking) {

					keepAsking = input.getUserInputForDay();

				}
				e.editEmploymentDate(input.getDay(), input.getMonth(), input.getYear());
				System.out.println("Employment Date Edit Complete");
			default:

			}

		}
	}

	public static void createEmployee(UserInput input, Employees e)
			throws InputOutOfRangeException, MonthOutOfRangeException {

		input.resetInput();

		boolean correct = false;

		while (!correct) {
			correct = input.getUserInputFirstName();

		}

		correct = false;

		while (!correct) {
			correct = input.getUserInputLastName();
		}

		correct = false;

		while (!correct) {
			correct = input.getUserSalaryInput();
		}

		correct = false;

		while (!correct) {
			correct = input.getUserInputDepartment();
		}

		correct = false;

		while (!correct) {
			correct = input.getUserInputForYear();
		}

		correct = false;

		while (!correct) {
			correct = input.getUserInputForMonth();
		}

		correct = false;

		while (!correct) {
			correct = input.getUserInputForDay();
		}

		e.addEmployee(input.getFirstName(), input.getLastName(), input.getSalary(), input.getDepartmentName(),
				input.getYear(), input.getMonth(), input.getDay());

	}

}

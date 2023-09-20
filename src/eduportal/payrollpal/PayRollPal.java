/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payrollpal;

/**
 *
 * @author Delron Munyai
 */

import java.util.*;

public class PayRollPal {
    public static void main(String[] args) {
        
        String fullName;
        int empId;
        double annualSalary;
        int choice;
        int count = 0;
        
        Scanner scanner = new Scanner(System.in);

        Employee[] employees = new Employee[10]; // Array to store employees

        System.out.println("Welcome to our Employee Management System!");
        
        do {
            System.out.println("-------------------------------");
            System.out.println("Menu:");
            System.out.println("1. Add Full-Time Employee");
            System.out.println("2. Add Part-Time Employee");
            System.out.println("3. List Employees");
            System.out.println("4. Exit");
            System.out.println("-------------------------------");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            System.out.println("-------------------------------");

            switch (choice) {
                case 1:
                    try {
                        if (count <= 10) {
                            System.out.print("Enter Full-Time Employee Names: ");
                            fullName = scanner.next();
                            System.out.print("Enter Employee ID: ");
                            empId = scanner.nextInt();
                            System.out.print("Enter Annual Salary: ");
                            annualSalary = scanner.nextDouble();

                            employees[count] = new FullTimeEmployee(fullName, empId, annualSalary);
                            employees[count].calculateMonthlySalary();
                            count++;
                        } else {
                            System.out.println("Employee list is full.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter valid data.");
                        scanner.nextLine(); 
                    }
                    break;
                case 2:
                    try {
                        if (count <= 10) {
                            System.out.print("Enter Part-Time Employee Names: ");
                            fullName = scanner.next();
                            System.out.print("Enter Employee ID: ");
                            empId = scanner.nextInt();
                            System.out.print("Enter Hourly Rate: ");
                            double hourlyRate = scanner.nextDouble();
                            System.out.print("Enter Hours Worked: ");
                            int hoursWorked = scanner.nextInt();

                            employees[count] = new PartTimeEmployee(fullName, empId, hourlyRate, hoursWorked);
                            employees[count].calculateMonthlySalary();
                            count++;
                        } else {
                            System.out.println("Employee list is full.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter valid inputs.");
                        scanner.nextLine(); 
                    }
                    break;
                case 3:
                    System.out.println("-------------------------------");
                    System.out.println("Employee List:");
                    System.out.println();
                    for (int i = 0; i < count; i++) {
                        System.out.println("Employee " + (i + 1) );
                        System.out.println("-------------------------------");
                        System.out.println("Name: " + employees[i].getName());
                        System.out.println("Employee ID: " + employees[i].getEmployeeId());
                        System.out.println("Monthly Salary: $" + employees[i].getMonthlySalary());
                        System.out.println("-------------------------------");
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }
}


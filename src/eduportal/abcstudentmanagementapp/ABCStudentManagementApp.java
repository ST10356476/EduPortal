/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package abcstudentmanagementapp;

/**
 *
 * @author Munyai Phalanndwa
 */
import java.util.*;

public class ABCStudentManagementApp {

    public static void main(String[] args) {
        
        int studentId;
        String studentName;
        int studentAge;
        String studentEmail;
        String studentCourse;
        Scanner scanInput = new Scanner(System.in);
        Student student = new Student();
        
        //Display the welcome message and menu options
        System.out.println("STUDENT MANAGEMENT APPLICATION");
        System.out.println("****************************************");
        System.out.println("Enter (1) to launch menu or any other key to exit");

        String launchMenu = scanInput.nextLine();

        while ("1".equals(launchMenu)) {
            System.out.println("Please select one of the following menu items:" +
                "\n(1) Capture a new student." +
                "\n(2) Search for a student." +
                "\n(3) Delete a student." +
                "\n(4) Print student report." +
                "\n(5) Exit Application");
            System.out.println();
            int menuOption = scanInput.nextInt();
            scanInput.nextLine(); // Consume the newline character

            switch (menuOption) {
                case 1:
                    // Capture a new student
                    System.out.println("CAPTURE A NEW STUDENT" + "\n************************");
                    System.out.print("Enter the student id: ");
                    studentId = scanInput.nextInt();
                    scanInput.nextLine(); // Consume the newline character
                    System.out.print("Enter the student name: ");
                    studentName = scanInput.nextLine();
                    System.out.print("Enter the student age: ");
                    
                    while (true) {
                        try {
                            studentAge = scanInput.nextInt();
                            
                            //determines if the age entered is greater or equal to 16
                            if (studentAge >= 16) {
                                break;
                            } else {
                                System.out.println("You have entered an incorrect student age!!!");
                                System.out.print("Please re-enter the student age >> ");
                            }
                            
                            //catch the input mismatch exceptions and return necessary message
                        } catch (InputMismatchException e) {
                            System.out.println("You have entered an incorrect student age!!!");
                            System.out.print("Please re-enter the student age >> ");
                            scanInput.nextLine(); 
                        }
                    }
                    scanInput.nextLine(); // Consume the newline character
                    System.out.print("Enter the student email: ");
                    studentEmail = scanInput.nextLine();
                    System.out.print("Enter the student course: ");
                    studentCourse = scanInput.nextLine();
                    
                    // Save the student details
                    student.saveStudent(studentId, studentName, studentAge, studentEmail, studentCourse);
                    System.out.println("****************************************************");
                    System.out.println("Student details have been successfully saved.");
                    System.out.println("****************************************************");
                    System.out.println("Enter (1) to launch menu or any other key to exit");
                    launchMenu = scanInput.nextLine();
                    break;
                
                case 2:
                    // Search for a student
                    System.out.print("Enter the student id to search: ");
                    studentId = scanInput.nextInt();
                    scanInput.nextLine();
                    
                    String searchResults = student.searchStudent(studentId);
                    System.out.println(searchResults);
                    System.out.println("Enter (1) to launch menu or any other key to exit");
                    launchMenu = scanInput.nextLine();
                    break;
                 
                case 3:
                    // Delete a student
                    String confirm;
                    System.out.print("Enter the student id to delete: ");
                    studentId = scanInput.nextInt();
                    scanInput.nextLine(); // Consume the newline character

                    System.out.println("Are you sure you want to delete student with id " + studentId + " from the system? Yes (Y) to delete, No (N) to cancel.");
                    confirm = scanInput.nextLine(); // Read the confirmation input as a whole line

                    while (true) {
                        if (confirm.equalsIgnoreCase("Y")) {
                            if (student.deleteStudent(studentId)) {
                                System.out.println("-----------------------------------------" +
                                                    "\nStudent with Student Id: " + studentId + " was deleted!" + 
                                                    "\n-----------------------------------------");
                            } else {
                                System.out.println("-----------------------------------------" +
                                                    "\nStudent with Student Id: " + studentId + " was not found!" + 
                                                    "\n-----------------------------------------");
                            }
                                break;
                        } else if (confirm.equalsIgnoreCase("N")) {
                            System.out.println("Student not deleted.");
                            break;
                        } else {
                            System.out.println("Incorrect input. Please enter 'Y' to delete, 'N' to cancel.");
                            confirm = scanInput.nextLine();
                        }
                    }

                    System.out.println("Enter (1) to launch menu or any other key to exit");
                    launchMenu = scanInput.nextLine();
                    break;
                    
                case 4:
                    // Print student report
                    String report;
                    report = student.studentReport();
                    System.out.println(report);
                    System.out.println("Enter (1) to launch menu or any other key to exit");
                    launchMenu = scanInput.nextLine();
                    break;
                case 5:
                    // Exit application
                    System.out.println("Thank you for using our student management app.");
                    student.exitStudentApplication();
                    break;

                default:
                    System.out.println("Invalid menu option. Please try again.");
                    break;
            }
        }
    }
}

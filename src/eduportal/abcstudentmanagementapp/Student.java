/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abcstudentmanagementapp;

import java.util.*;

public class Student {
    // Define ArrayLists to store student information
    ArrayList<Integer> studentId;
    ArrayList<String> studentName;
    ArrayList<Integer> studentAge;
    ArrayList<String> studentEmail;
    ArrayList<String> studentCourse;

    // Constructor to initialize the ArrayLists
    public Student() {
        studentId = new ArrayList<>();
        studentName = new ArrayList<>();
        studentAge = new ArrayList<>();
        studentEmail = new ArrayList<>();
        studentCourse = new ArrayList<>();
    }

    // Method to save student information
    public void saveStudent(int id, String Name, int age, String email, String course) {
        studentId.add(id);
        studentName.add(Name);
        studentAge.add(age);
        studentEmail.add(email);
        studentCourse.add(course);
    }

    // Method to search for a student by ID
    public String searchStudent(int idNumber) {
        StringBuilder searchReport = new StringBuilder();
        boolean idFound = false; // Track whether a student with the given ID is found

        for (int i = 0; i < studentId.size(); i++) {
            if (studentId.get(i).equals(idNumber)) {
                String report = "----------------------------------------------" +
                    "\nSTUDENT ID: " + studentId.get(i) +
                    "\nSTUDENT NAME: " + studentName.get(i) +
                    "\nSTUDENT AGE: " + studentAge.get(i) +
                    "\nSTUDENT EMAIL: " + studentEmail.get(i) +
                    "\nSTUDENT COURSE: " + studentCourse.get(i) +
                    "\n---------------------------------------------";
                searchReport.append(report).append("\n");
                idFound = true; // Mark that a student with the given ID was found
            }
        }

        if (!idFound) {
            searchReport.append("------------------------------------------------------" +
                            "\nStudent with Id: " + idNumber + " was not found." + 
                            "\n------------------------------------------------------");
        }

        return searchReport.toString();
    }

    // Method to delete a student by ID
    public boolean deleteStudent(int idNumber) {
        int index = studentId.indexOf(idNumber);
        if (index != -1) {
            studentId.remove(index);
            studentName.remove(index);
            studentAge.remove(index);
            studentEmail.remove(index);
            studentCourse.remove(index);
            
            return true;
        }
        
        return false;
    }

    // Method to generate a report of all students
    public String studentReport() {
        StringBuilder report = new StringBuilder();
        
        if (studentId.isEmpty()) {
            report.append("--------------------------" +
                        "\nNo students captured." + 
                        "\n--------------------------");
        } else {
            for (int i = 0; i < studentId.size(); i++) {
                String studentsReport = "STUDENT " + (i + 1)+
                        "\n--------------------------------------------"+
                        "\nSTUDENT ID: " + studentId.get(i)+
                        "\nSTUDENT NAME: " + studentName.get(i)+
                        "\nSTUDENT AGE: " + studentAge.get(i)+
                        "\nSTUDENT EMAIL: " + studentEmail.get(i)+
                        "\nSTUDENT COURSE: " + studentCourse.get(i)+
                        "\n---------------------------------------------";
                
                report.append(studentsReport).append("\n");
            }
        }
        
        return report.toString();
    }

    // Method to check if the age input is valid
    public boolean isAgeValid(int age) {
        try {
            if (age >= 16) {
                return true;
            } else {
                return false;
            }
        } catch (InputMismatchException e) {
            return false;
        }
    }

    // Method to exit the student application
    public void exitStudentApplication() {
        System.exit(0);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payrollpal;

/**
 *
 * @author Delron Munyai
 */
public abstract class Employee {
    private String name;
    private int employeeId;
    private double monthlySalary;

    public Employee(String name, int employeeId) {
        this.name = name;
        this.employeeId = employeeId;
        this.monthlySalary = 0.0;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public abstract void calculateMonthlySalary();
}
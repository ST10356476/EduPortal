/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payrollpal;

/**
 *
 * @author Delron Munyai
 */
class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(String name, int employeeId, double hourlyRate, int hoursWorked) {
        super(name, employeeId);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public void calculateMonthlySalary() {
        setMonthlySalary(hourlyRate * hoursWorked);
    }
}

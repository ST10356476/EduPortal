/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package payrollpal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

/*
This Employee test class test both FullTimeEmployee and PartTimeEmployee classes in the PayRollPal app.
This is because it is the parent class and those two subclasses inherit from it as a parent class.
*/


public class EmployeeTest {
    
    //Tests if the method for full-time employees is working as intended 
    @Test
    public void testFullTimeEmployee() {
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee("Munyai Phalanndwa", 1, 500000.0);

        fullTimeEmployee.calculateMonthlySalary();
        
        assertEquals(41666.66, fullTimeEmployee.getMonthlySalary(), 0.01);
    }
    
    //Tests if the method for part-time employees is working as intended
    @Test
    public void testPartTimeEmployee() {
        PartTimeEmployee partTimeEmployee = new PartTimeEmployee("Grace Brown", 2, 150.5, 160);

        partTimeEmployee.calculateMonthlySalary();

        assertEquals(24080.0, partTimeEmployee.getMonthlySalary(), 0.01);
    }
    
    //Tests if the method for displaying the list of employees is working as intended
    @Test
    public void testEmployeeList() {
        // Create an array to store Employee objects
        Employee[] employees = new Employee[2];

        // Create a FullTimeEmployee object and a PartTimeEmployee object
        employees[0] = new FullTimeEmployee("Munyai Phalanndwa", 1, 500000.0);
        employees[1] = new PartTimeEmployee("Grace Brown", 2, 150.5, 160);

        // Calculate the monthly salaries for both employees
        employees[0].calculateMonthlySalary();
        employees[1].calculateMonthlySalary();

        // Assert the attributes and calculated monthly salaries of the employees
        assertEquals("Munyai Phalanndwa", employees[0].getName());
        assertEquals(1, employees[0].getEmployeeId());
        assertEquals(41666.66, employees[0].getMonthlySalary(), 0.01);

        assertEquals("Grace Brown", employees[1].getName());
        assertEquals(2, employees[1].getEmployeeId());
        assertEquals(24080.0, employees[1].getMonthlySalary(), 0.01);
    }
}


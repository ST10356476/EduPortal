/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package abcstudentmanagementapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentTest {
    Student student = new Student();
    
    //Tests the method to see if it saves all the saved students details.
    @Test
    public void testSaveStudent() {
        student.saveStudent(10111, "J.Bloggs", 19, "jbloggs@ymail.com", "disd");
        assertEquals(1, student.studentId.size());
    }
    
    //Test if the student exist in the array of saved students.
    @Test
    public void testSearchExistingStudent() {
        boolean available = false;
        student.saveStudent(10111, "J.Bloggs", 19, "jbloggs@ymail.com", "disd");
        
        //(Pankaj, 2022)
        available = student.searchStudent(10111).contains("10111");
        assertTrue(available);
    }

    @Test
    public void testSearchNonExistingStudent() {
        boolean available = false;
        student.saveStudent(10111, "J. Bloggs", 19, "jbloggs@ymail.com", "disd");
        
        available = student.searchStudent(10111).contains("10111");
        
        assertTrue(available);
    }
    
    //Test if the student has been deleted from the saved students.
    @Test
    public void testDeleteExistingStudent() {
        student.saveStudent(10111, "J.Bloggs", 19, "jbloggs@ymail.com", "disd");
        assertTrue(student.deleteStudent(10111));
        assertEquals(0, student.studentId.size());
    }
    
    //Tests if the app return neccessary information if the student to be deleted is not located in the system.
    @Test
    public void testDeleteNonExistingStudent() {
        assertFalse(student.deleteStudent(10111));
    }
    

    //Tests if the neccessary message is returned when there is no saved student.
    @Test
    public void testStudentReportEmpty() {
        String report = student.studentReport();
        assertTrue(report.contains("No students captured."));
    }
    
    //Tests if the saved students can be displayed as a report of all saved students.
    @Test
    public void testStudentReportWithStudents() {
        student.saveStudent(10111, "J.Bloggs", 19, "jbloggs@ymail.com", "disd");
        student.saveStudent(10112, "P.Parker", 20, "spidey@ymail.com", "disd");
        String report = student.studentReport();
        assertTrue(report.contains("STUDENT ID: 10111"));
        assertTrue(report.contains("STUDENT ID: 10112"));
    }
    
    //Tests if the input age is greater than 16.
    @Test
    public void testIsAgeValid() {
        assertTrue(student.isAgeValid(16));
    }
    
    //Tests if the input age is less than 16 or have characters.
    @Test
    public void testAgeInvalid() {
        assertFalse(student.isAgeValid(10));
    }
}
    

//Code Attribution
/* 
1. Pankaj. 2022. How to Check if Java Array Contains a Value? | DigitalOcean. [online] Available at: https://www.digitalocean.com/community/tutorials/java-array-contains-value [Accessed 14 September 2022].
*/
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cse.springtute;

import java.io.*;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Yasura
 */
public class StudentManagementSystemTest {
    
    Student st1,st2;
    static StudentManagementSystem instance;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    
    public StudentManagementSystemTest() {
        instance = new StudentManagementSystem();
        instance.setRepo(new SimpleStudentRepository());
        st1=new Student();
        st1.setRegNumber(100559);
        st1.setFirstName("Yasura");
        st1.setLastName("Vithana");
        st2=new Student();
        st2.setRegNumber(100498);
        st2.setFirstName("Hashini");
        st2.setLastName("Senaratne");
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }
    
    @After
    public void tearDown() {
        System.setOut(null);
        instance.getRepo().deleteStudent(st1);
        instance.getRepo().deleteStudent(st2);
    }

    /**
     * Test of listAllStudents method, of class StudentManagementSystem.
     */
    @Test
    public void testListAllStudents(){
        System.out.println("listAllStudents");
        instance.registerStudent(st1);
        instance.registerStudent(st2);
        instance.listAllStudents();
        assertEquals("listAllStudents\r\n100498\tHashini Senaratne\r\n100559\tYasura Vithana\r\n", outContent.toString());
    }

    /**
     * Test of registerStudent method, of class StudentManagementSystem.
     */
    @Test
    public void testRegisterStudent() {
        System.out.println("registerStudent");
        instance.registerStudent(st1);
        if(instance.getRepo().findStudent(st1.getRegNumber())!=st1)
            fail("The test case is a prototype.");
    }
}

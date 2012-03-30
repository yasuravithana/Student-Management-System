
package org.cse.springtute;

import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author 100559v
 */
public class SimpleStudentRepositoryTest {
    Student st1,st2;
    static SimpleStudentRepository instance;
    
    public SimpleStudentRepositoryTest() {
        instance = new SimpleStudentRepository();
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

    @After
    public void tearDown() {
        instance.deleteStudent(st1);
        instance.deleteStudent(st2);
    }


    /**
     * Test of saveStudent method, of class SimpleStudentRepository.
     */
    @Test
    public void testSaveStudent() {
        System.out.println("saveStudent");
        instance.saveStudent(st1);
        if(instance.findStudent(st1.getRegNumber())==null)
            fail("Saving the student failed!");
    }

    /**
     * Test of deleteStudent method, of class SimpleStudentRepository.
     */
    @Test
    public void testDeleteStudent() {
        instance.saveStudent(st1);
        System.out.println("deleteStudent");
        instance.deleteStudent(st1);
        if(instance.findStudent(st1.getRegNumber())!=null)
            fail("Deleting the student failed!");
    }

    /**
     * Test of findStudent method, of class SimpleStudentRepository.
     */
    @Test
    public void testFindStudent() {
        System.out.println("findStudent");
        instance.saveStudent(st1);
        Student result = instance.findStudent(100559);
        assertEquals(st1, result);
        result = instance.findStudent(100498);
        assertEquals(null, result);
    }

    /**
     * Test of updateStudent method, of class SimpleStudentRepository.
     */
    @Test
    public void testUpdateStudent() {
        System.out.println("updateStudent");
        Student st=new Student();
        instance.saveStudent(st1);
        st.setRegNumber(100559);
        st.setFirstName("Yasura");
        st.setLastName("Gimhan");
        instance.updateStudent(st);
        assertEquals(st, instance.findStudent(100559));
    }

    /**
     * Test of findAllStudents method, of class SimpleStudentRepository.
     */
    @Test
    public void testFindAllStudents() {
        System.out.println("findAllStudents");
        instance.saveStudent(st1);
        instance.saveStudent(st2);
        List result = instance.findAllStudents();
        assertEquals(st1, result.get(1));
        assertEquals(st2, result.get(0));
        assertEquals(2, result.size());
    }

}
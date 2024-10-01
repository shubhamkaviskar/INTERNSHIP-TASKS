package com.Initializer.Services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.Initializer.ModelClasses.Student;

public class StudentServiceIMPLTest {

    @InjectMocks
    private StudentServiceIMPL studentService;

    @Mock
    private StudentDaoIMPL studentDao;

    @BeforeEach
    public void setUp() {
    	MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveStudentSuccess() {
        Student student = new Student(5, "Dummy", 8788229973L, 99, "Pune");

        // Call the method to test
        studentService.saveStudent(student);

        // Verify the interaction with DAO
        verify(studentDao, times(1)).saveStudent(student);
    }

    @Test
    public void testDeleteStudentSuccess() {
        // Setup
        List<Student> students = new ArrayList<>();
        students.add(new Student(5, "Dummy", 8788229973L, 99, "Pune"));
        when(studentDao.deleteStudent(1)).thenReturn(students);

        // Execute
        List<Student> result = studentService.deleteStudent(1);

        // Verify
        assertNotNull(result);
        assertEquals(1, result.size());
        verify(studentDao, times(1)).deleteStudent(1);
    }

    @Test
    public void testLoginCheckSuccess() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(5, "Dummy", 8788229973L, 99, "Pune"));
        when(studentDao.getAllStudentsRecord()).thenReturn(students);
        List<Student> result = studentService.loginCheck("5", "8788229973L");
        assertNotNull(result);
        assertEquals(students, result);
    }

    @Test
    public void testEditStudentSuccess() {
        Student student = new Student(5, "Dummy", 8788229973L, 99, "Pune");
        when(studentDao.editStudent(1)).thenReturn(student);

        Student result = studentService.editStudent(1);

        assertNotNull(result);
        assertEquals("Dummy", result.getName());
    }
    
    @Test
    public void testStudentLoginFailure() {
        when(studentDao.getSingleStudentData(8, 8788229973L)).thenReturn(null);
        
        Student result = studentService.studentLogin(5, 8788229973L);
        
        assertNull(result);
        verify(studentDao, times(1)).getSingleStudentData(5, 8788229973L);
    }
}

package com.Initializer.Services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.Initializer.ModelClasses.Student;

public class StudentDaoIMPLTest {

    private StudentDaoIMPL studentDao;

    @Mock
    private SessionFactory sessionFactory;

    @Mock
    private Session session;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this); // Use initMocks for Mockito 2.x
        studentDao = new StudentDaoIMPL();
        studentDao.setFactory(sessionFactory); // Inject the mocked SessionFactory
    }


    @Test
    public void testSaveStudent() {
        Student student = new Student(5, "Dummy", 8788229973L, 99, "Pune");
        
        when(sessionFactory.openSession()).thenReturn(session);
        when(session.beginTransaction()).thenReturn(mock(Transaction.class));

        studentDao.saveStudent(student);
        
        verify(session).saveOrUpdate(student);
        verify(session).beginTransaction().commit();
    }

    @Test
    public void testDeleteStudent() {
        when(sessionFactory.openSession()).thenReturn(session);
        when(session.beginTransaction()).thenReturn(mock(Transaction.class));

        studentDao.deleteStudent(5);
        
        verify(session).createQuery("delete from Student where rollno=:id");
    }

    @Test
    public void testEditStudentNotFound() {
        when(sessionFactory.openSession()).thenReturn(session);
        when(session.get(Student.class, 5)).thenReturn(null);

        Student result = studentDao.editStudent(5);
        
        assertNull(result);
    }
}

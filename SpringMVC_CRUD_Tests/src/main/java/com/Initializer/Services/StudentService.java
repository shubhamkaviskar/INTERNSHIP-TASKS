package com.Initializer.Services;

import java.util.List;
import com.Initializer.ModelClasses.Student;

public interface StudentService {

	public void saveStudent(Student student);

	public List<Student> loginCheck(String username, String password);

	public List<Student> deleteStudent(int rollno);

	public Student editStudent(int rollno);

	public Student studentLogin(int rollno, long mobileno);

}

package com.Initializer.Services;

import java.util.List;
import com.Initializer.ModelClasses.Student;

public interface StudentDao {
	public void saveStudent(Student student);

	public List<Student> getAllStudentsRecord();

	public List<Student> deleteStudent(int rollno);

	public Student editStudent(int rollno);

	public Student getSingleStudentData(int rollno, long mobileno);
	
}

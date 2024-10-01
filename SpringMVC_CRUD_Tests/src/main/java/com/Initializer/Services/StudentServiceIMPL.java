package com.Initializer.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Initializer.ModelClasses.Student;
import com.Initializer.ModelClasses.User;


@Service
public class StudentServiceIMPL implements StudentService {
	
	@Autowired
	private StudentDao dao;
	@Autowired
	private User user;
	
	public void saveStudent(Student student) {
		System.out.println("Service Is Active Now");
		System.out.println(student);
		dao.saveStudent(student);
	}

	public List<Student> loginCheck(String username, String password) {
		System.out.println("In student service impl class");
		System.out.println(user.getUsername()+" "+user.getPassword());
		
		if(username.equals(user.getUsername()) && password.equals(user.getPassword())) {
		return dao.getAllStudentsRecord();
		}
		else
		return null;
	}

	@Override
	public List<Student> deleteStudent(int rollno) {
		return dao.deleteStudent(rollno);
	}

	@Override
	public Student editStudent(int rollno) {
		return dao.editStudent(rollno);
	}

	@Override
	public Student studentLogin(int rollno, long mobileno) {
		System.out.println("student login @ StudentServiceIMPL :: Called");
		dao.getSingleStudentData(rollno,mobileno);
		return dao.getSingleStudentData(rollno,mobileno);
	}

}

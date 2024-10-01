package com.Initializer.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.Initializer.ModelClasses.Student;
import com.Initializer.Services.StudentService;


@Controller
public class HomeController {
	
	@Autowired
	private StudentService service;
	
	public HomeController() {
		System.out.println("Home Controller :: Construct");
	}

	@RequestMapping("/")
	public String landingpage() {
	System.out.println("Landing Page :: Called");
	return "index";
	}
	
	@RequestMapping("/logPage")
	public String loginpage() {
		System.out.println("Login Page :: Called");
		return "login";
	}
	
	@RequestMapping("/regPage")
	public String registerPage() {
		System.out.println("Register Page :: Called");
		return "register";
	}
	
	@RequestMapping("/log")
	public String loginCheck(@RequestParam String username,@RequestParam String password, Model model) {
		System.out.println("Verifying Login :: Called "+username+" "+password);
		List <Student> stulist = service.loginCheck(username,password);
		if(stulist!=null) {
			stulist.forEach((n)->System.out.println(n));
			model.addAttribute("data",stulist);
			return "success";
			}
		else {
			System.out.println("Entered wrong ID PASSWORD");
			return "index";
			}	
	}
	
	@RequestMapping("/reg")
	public String saveStudent(@ModelAttribute Student student) {
		System.out.println(student);
		service.saveStudent(student);
		return "index";
	}
	
	@RequestMapping("/delete")
	public String deleteStudent(@RequestParam int rollno, Model model) {
		List <Student> stulist = service.deleteStudent(rollno);
		model.addAttribute("data",stulist);
		return "success";
	}
	
	@RequestMapping("/edit")
	public String editStudent(@RequestParam int rollno, Model model) {
		Student stu = service.editStudent(rollno);
		model.addAttribute("stu",stu);
		return "update";
	}
	
	@RequestMapping("/update")
	public String updateStudent(@ModelAttribute Student student) {
		service.saveStudent(student);
		return "index";
	}
	
	@RequestMapping("/studentlog")
	public String studentLoginPage() {
		return "studentlogin";
	}
	
	@RequestMapping("/studlog")
	public String studentLogin(@RequestParam int rollno, @RequestParam long mobileno, Model model) {
		Student stu = (Student)service.studentLogin(rollno,mobileno);
		System.out.println(stu);
		System.out.println("Student Login :: Called @ Home Controller");
		boolean flag = stu != null;
		if(flag) {
			model.addAttribute("data",stu);
			return "studentloginsuccess";
		}
		else
			return "index";
	}
	
}
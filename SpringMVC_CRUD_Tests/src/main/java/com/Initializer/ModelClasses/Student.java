package com.Initializer.ModelClasses;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
@Id
private int rollno;
private String name;
private long mobileno;
private double marks;
private String address;

public int getRollno() {
	return rollno;
}
public void setRollno(int rollno) {
	this.rollno = rollno;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getMobileno() {
	return mobileno;
}
public void setMobileno(long mobileno) {
	this.mobileno = mobileno;
}
public double getMarks() {
	return marks;
}
public void setMarks(double marks) {
	this.marks = marks;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}

@Override
public String toString() {
	return "Student [rollno=" + rollno + ", name=" + name + ", mobileno=" + mobileno + ", marks=" + marks + ", address="
			+ address + "]";
}

public Student(int rollno, String name, long mobileno, double marks, String address) {
	super();
	this.rollno = rollno;
	this.name = name;
	this.mobileno = mobileno;
	this.marks = marks;
	this.address = address;
}

public Student() {
	super();
}

}

package com.aixtor.training.empojo;

public class Employee {
	
	long id;
	String name;
	long enrollmentNo;
	String subject;
	
	public Employee(long id, String name, long enrollmentNo, String subject) {
		super();
		this.id = id;
		this.name = name;
		this.enrollmentNo = enrollmentNo;
		this.subject = subject;
	}
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getEnrollmentNo() {
		return enrollmentNo;
	}
	public void setEnrollmentNo(long enrollmentNo) {
		this.enrollmentNo = enrollmentNo;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}

}

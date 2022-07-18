package com.mss.employedetails;

public class EmployeepojoclassDetails {
	private int id;
	private String name;


	public  EmployeepojoclassDetails() {
		super();
	}

	public EmployeepojoclassDetails( int id, String name) {
		super();
	this.id=id;
	this.name=name;


	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	
}

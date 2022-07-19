package com.mss.user;

public class Userdetailsbeanclass {
	private int accountid;
	private String name;
	private String email;
	private String password;
	private int age;
	public int getAccountid() {
		return accountid;
	}
	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Userdetailsbeanclass(int accountid, String name, String email, String password, int age) {
		super();
		this.accountid = accountid;
		this.name = name;
		this.email = email;
		this.password = password;
		this.age = age;
	}
	public Userdetailsbeanclass() {
		super();
		// TODO Auto-generated constructor stub
	}

}
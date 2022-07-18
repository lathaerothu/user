package com.mss.accounts;

public class Accountsbeanclass {
	
	private int accountid;
	private String accountname;
	private String noofemployes;

	

	public int getAccountid() {
		return accountid;
	}

	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

	public String getAccountname() {
		return accountname;
	}

	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}

	public String getNoofemployes() {
		return noofemployes;
	}

	public void setNoofemployes(String noofemployes) {
		this.noofemployes = noofemployes;
	}

	public Accountsbeanclass(int accountid, String accountname, String noofemployes) {
		super();
		this.accountid = accountid;
		this.accountname = accountname;
		this.noofemployes = noofemployes;
	}

	public Accountsbeanclass() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}



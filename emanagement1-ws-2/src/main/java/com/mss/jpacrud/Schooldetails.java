package com.mss.jpacrud;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Schooldetails {
	@Id
	private int id;
	private String name;
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
	public Schooldetails(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

}

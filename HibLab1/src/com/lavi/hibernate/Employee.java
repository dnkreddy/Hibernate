package com.lavi.hibernate;

/**
 * 
 * @author LaViTechnologies
 *
 */
/*
 * Drop table Employee;
 * create table Employee (eid int primary key,ename
 * varchar(100),email varchar(100),EPHONENO number(10)); 
 * commit;
 */
public class Employee {
	private int eid;
	private String eName;
	private String email;
	private int ephoneNo;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEphoneNo() {
		return ephoneNo;
	}

	public void setEphoneNo(int ephoneNo) {
		this.ephoneNo = ephoneNo;
	}

}
package com.lavi.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Lavi Technologies
 * create table USER_DETAILS (USER_ID number(10,0) not null, PHONE_NO number(19,0), USER_NAME varchar2(255), primary key (USER_ID))
 * 
 */

@Entity
@Table(name = "USER_DETAILS")
public class User {

	@Id
	@Column(name = "USER_ID")
	private int userId;

	@Column(name = "USER_NAME")
	private String userName;
	
	@Column(name="PHONE_NO")
	private long phoneNo;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

}

package com.lavi.hibernate.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author LaVi Technologies
 * create table USER_DETAILS (USER_ID number(10,0) not null, ADDRESS varchar2(255), DATE_CREATED date, DESCRIPTION varchar2(255), USER_NAME varchar2(255), primary key (USER_ID))
 * CREATE SEQUENCE  "SYSTEM"."USER_SEQ"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 50 START WITH 2001 CACHE 20 NOORDER  NOCYCLE ;
 */

@Entity
@Table(name = "USER_DETAILS")
public class User {

	@Id
	@SequenceGenerator(name="USER_SEQ1",sequenceName="USER_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="USER_SEQ1")
	@Column(name = "USER_ID")
	private int userId;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "DATE_CREATED")
	@Temporal(TemporalType.DATE)
	private Date dateCreated;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

}

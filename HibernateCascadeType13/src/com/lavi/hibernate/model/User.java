package com.lavi.hibernate.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * @author LaVi Technologies
 * 
 */

@Entity
@Table(name = "USER_DETAILS")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int userId;

	@Column(name = "USER_NAME")
	private String userName;
	
	@Column(name="CREATED_DATE")
	@Temporal(TemporalType.DATE)
	private Date userCreatedDate;
	
	@Transient
	private String userType;

	@OneToMany(mappedBy = "userDetails")
	private Collection<Vehical> vehicalList = new ArrayList<Vehical>();

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

	public Collection<Vehical> getVehicalList() {
		return vehicalList;
	}

	public void setVehicalList(Collection<Vehical> vehicalList) {
		this.vehicalList = vehicalList;
	}

}

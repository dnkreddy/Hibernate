package com.lavi.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author LaVi Technologies
 * 
 */

@Entity
@Table(name = "VEHICAL_DETAILS")
public class Vehical {

	@Id
	@GeneratedValue
	@Column(name = "VEHICAL_ID")
	private int vehicalId;

	@Column(name = "VEHICAL_NAME")
	private String vehicalName;

	@ManyToOne()
	@JoinColumn(name = "USER_ID")
	private User userDetails;

	public int getVehicalId() {
		return vehicalId;
	}

	public void setVehicalId(int vehicalId) {
		this.vehicalId = vehicalId;
	}

	public String getVehicalName() {
		return vehicalName;
	}

	public void setVehicalName(String vehicalName) {
		this.vehicalName = vehicalName;
	}

	public User getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(User userDetails) {
		this.userDetails = userDetails;
	}

}

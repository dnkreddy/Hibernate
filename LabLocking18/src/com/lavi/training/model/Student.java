package com.lavi.training.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name="LAVI_STUDENT")
public class Student {
	
	public Student() {
		
	}
	
	@Id
	@Column(name="STUD_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int studId;
	
	@Column(name="STUD_NAME")
	private String studName;
	
	@Column(name="FEE_BAL")
	private long feeBal;
	
	@Column(name="JOIN_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date studJoinDate;
	
	/*@Version
	@Column(name="VERSION")
	private int versionNo;*/
	
	/*@Transient
	private String city;*/

	public int getStudId() {
		return studId;
	}

	public void setStudId(int studId) {
		this.studId = studId;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public long getFeeBal() {
		return feeBal;
	}

	public void setFeeBal(long feeBal) {
		this.feeBal = feeBal;
	}

	public Date getStudJoinDate() {
		return studJoinDate;
	}

	public void setStudJoinDate(Date studJoinDate) {
		this.studJoinDate = studJoinDate;
	}

	/*public int getVersionNo() {
		return versionNo;
	}*/

	/*public void setVersionNo(int versionNo) {
		this.versionNo = versionNo;
	}*/

	

}

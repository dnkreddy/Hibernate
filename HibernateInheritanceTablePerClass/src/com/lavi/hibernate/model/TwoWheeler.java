package com.lavi.hibernate.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author LaVi Technologies
 * 
 */

@Entity
@Table(name = "TWO_WHEELER")
public class TwoWheeler extends Vehicle {

	@Column(name = "STREEING_HANDLE")
	private String streeingHandle;

	public String getStreeingHandle() {
		return streeingHandle;
	}

	public void setStreeingHandle(String streeingHandle) {
		this.streeingHandle = streeingHandle;
	}

}

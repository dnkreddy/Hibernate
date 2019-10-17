package com.lavi.hibernate.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author LaVi Technologies
 * 
 */

@Entity
@Table(name = "FOUR_WHEELER")
public class FourWheeler extends Vehicle {

	@Column(name = "STREEING_WHEEL")
	private String steeringWheel;

	public String getSteeringWheel() {
		return steeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}

}

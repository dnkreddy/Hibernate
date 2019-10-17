package com.lavi.hibernate.model;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
/**
 *@author LaVi Technologies
 * 
 */
@Entity
@DiscriminatorValue("CAR")
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

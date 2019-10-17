	package com.lavi.hibernate.model;
	
	import javax.persistence.Column;
	import javax.persistence.DiscriminatorValue;
	import javax.persistence.Entity;
	/**
	 *@author LaVi Technologies
	 * 
	 */
	@Entity
	@DiscriminatorValue("BIKE")
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

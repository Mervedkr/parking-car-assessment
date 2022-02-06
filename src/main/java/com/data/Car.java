package com.data;

import javax.persistence.Entity;

@Entity
public class Car {
	private String carNo;
	private String carType;
	private String carColor;	
	
	// this override written for logging correctly
	@Override
	public String toString() {
		return "Car [carNo=" + carNo + ", carType=" + carType + ", carColor=" + carColor + "]";
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getCarColor() {
		return carColor;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
}

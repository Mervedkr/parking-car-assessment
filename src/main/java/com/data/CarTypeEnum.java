package com.data;

public enum CarTypeEnum {
	TRUCK("TRUCK",4),
	CAR("Car", 1),
	JEEP("JEEP",2);
	public int slot;
	public String type;
	CarTypeEnum(String type, int slot){
        this.slot = slot;
        this.type = type;
    }
}

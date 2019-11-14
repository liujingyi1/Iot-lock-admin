package com.rgk.entity;

import java.io.Serializable;

public class MRoom implements Serializable{
	private static final long serialVersionUID = 1L;
	
    private String id;
	
	//房间号
	private String alias;
	
	//小区id
	private String villageId;
	
	//楼栋id
	private String buildingId;
	
	//楼层id
	private String floorId;
	
	//固定电话
	private String phoneNumber;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getVillageId() {
		return villageId;
	}

	public void setVillageId(String villageId) {
		this.villageId = villageId;
	}

	public String getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getFloorId() {
		return floorId;
	}

	public void setFloorId(String floorId) {
		this.floorId = floorId;
	}
	
}

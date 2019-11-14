package com.rgk.entity;

import java.io.Serializable;

public class MRoomMember implements Serializable{
	private static final long serialVersionUID = 1L;
	
    private String id;
	
	//小区id
	private String villageId;
	
	//楼栋id
	private String buildingId;
	
	//房间id
	private String roomId;
	
	//住户id
	private String memberId;
	
	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	
	
}

package com.rgk.entity;

import java.io.Serializable;
import java.util.Date;

public class MEnterprise implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private String id;
	
	private Date settlingTime;
	
	private String name;
	
	private String villageId;
	
	private String buildingId;
	
	public Date createdDate;

	public Date modifiedDate;
	
	public String modifiedBy;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getSettlingTime() {
		return settlingTime;
	}

	public void setSettlingTime(Date settlingTime) {
		this.settlingTime = settlingTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	
	
	
	

}

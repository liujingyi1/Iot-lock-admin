package com.rgk.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 园区
 *
 */
public class MVillage implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	// 园区别称
	private String alias;

	private String address;
	// 经度
	private String longitude;
	// 纬度
	private String latitude;

	public Date createdDate;

	public Date modifiedDate;

	public String modifiedBy;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	@Override
	public String toString() {
		return "MVillage [id=" + id + ", alias=" + alias + ", address=" + address + ", longitude=" + longitude
				+ ", latitude=" + latitude + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate
				+ ", modifiedBy=" + modifiedBy + "]";
	}

}

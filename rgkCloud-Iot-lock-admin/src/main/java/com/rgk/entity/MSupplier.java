package com.rgk.entity;

import java.io.Serializable;
import java.util.Date;

public class MSupplier implements Serializable  {
	private static final long serialVersionUID = 1L;
	
    private String id;
	
	//功能名称
	private String function;
	
	//供应商名称
	private String supplier;
	
	//启用状态  0：停用   1：启用
	private Integer State = 0;
	
	public Date createdDate;

	public Date modifiedDate;
	
	public String modifiedBy;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public Integer getState() {
		return State;
	}

	public void setState(Integer state) {
		State = state;
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

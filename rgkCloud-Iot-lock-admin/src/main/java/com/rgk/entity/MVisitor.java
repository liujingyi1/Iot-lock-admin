package com.rgk.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 访客管理
 *
 */
public class MVisitor implements Serializable{
	private static final long serialVersionUID = 1L;
	
    private String id;
	
	//到访楼栋
	private String buildNo;
	
	//到访楼层
	private String floorNo;
	
	//到访房号
	private String roomNo;
	
	//邀请人
	private String invite;
	
	//邀请人电话
	private String invitePhone;
	
	//来访人
	private String vistorName;
	
	//来访人电话
	private String vistorPhone;
	
	//来访类型
	private String type;
	
	public Date startTime;
	
	public Date endTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBuildNo() {
		return buildNo;
	}

	public void setBuildNo(String buildNo) {
		this.buildNo = buildNo;
	}

	public String getFloorNo() {
		return floorNo;
	}

	public void setFloorNo(String floorNo) {
		this.floorNo = floorNo;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public String getInvite() {
		return invite;
	}

	public void setInvite(String invite) {
		this.invite = invite;
	}

	public String getInvitePhone() {
		return invitePhone;
	}

	public void setInvitePhone(String invitePhone) {
		this.invitePhone = invitePhone;
	}

	public String getVistorName() {
		return vistorName;
	}

	public void setVistorName(String vistorName) {
		this.vistorName = vistorName;
	}

	public String getVistorPhone() {
		return vistorPhone;
	}

	public void setVistorPhone(String vistorPhone) {
		this.vistorPhone = vistorPhone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

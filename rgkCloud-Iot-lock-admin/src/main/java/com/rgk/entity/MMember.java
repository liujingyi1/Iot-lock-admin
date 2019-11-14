package com.rgk.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 成员
 *
 */
public class MMember implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    
    // 姓名
    private String name;
    
    //性别
    private Integer sex;
    
    //住户类别
    private Integer type;
    
    private String villageId;
    
    private String buildingId;
    
    private String floorId;
    
    private String roomId;
    
    //是否发放钥匙
    private Boolean grantedKey;
    
    //钥匙有效期
    private Integer keyType;
    
    //钥匙有效期开始
    private Date keyStart;
    
    //钥匙有效期结束
    private Date keyEnd;
    
    //是否注册
    private Boolean registed;
    
    //电话
    private String phone;
    
    //证件类型
    private Date certificatesType;
    
    //证件号码
    private Date certificatesNumber;
    
    //是否审核
    private Boolean verify;
    
    //上次登录时间
    private Date lastLogin;
    
    //年龄
    private Integer age;

    //有效期
    private String termOfValidity;
    
    //备注
    private String note;
    
    //照片
    private String picUrl;
    
    //人脸库memberId
    private String faceMemberId;
    
	public Date createdDate;
    
    public String createdBy;

	public Date modifiedDate;
	
	public String modifiedBy;
	
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
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

	public String getFloorId() {
		return floorId;
	}

	public void setFloorId(String floorId) {
		this.floorId = floorId;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public Boolean getGrantedKey() {
		return grantedKey;
	}

	public void setGrantedKey(Boolean grantedKey) {
		this.grantedKey = grantedKey;
	}

	public Integer getKeyType() {
		return keyType;
	}

	public void setKeyType(Integer keyType) {
		this.keyType = keyType;
	}

	public Date getKeyStart() {
		return keyStart;
	}

	public void setKeyStart(Date keyStart) {
		this.keyStart = keyStart;
	}

	public Date getKeyEnd() {
		return keyEnd;
	}

	public void setKeyEnd(Date keyEnd) {
		this.keyEnd = keyEnd;
	}

	public Boolean getRegisted() {
		return registed;
	}

	public void setRegisted(Boolean registed) {
		this.registed = registed;
	}

	public Boolean getVerify() {
		return verify;
	}

	public void setVerify(Boolean verify) {
		this.verify = verify;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getFaceMemberId() {
		return faceMemberId;
	}

	public void setFaceMemberId(String faceMemberId) {
		this.faceMemberId = faceMemberId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Date getCertificatesType() {
		return certificatesType;
	}

	public void setCertificatesType(Date certificatesType) {
		this.certificatesType = certificatesType;
	}

	public Date getCertificatesNumber() {
		return certificatesNumber;
	}

	public void setCertificatesNumber(Date certificatesNumber) {
		this.certificatesNumber = certificatesNumber;
	}

	public String getTermOfValidity() {
		return termOfValidity;
	}

	public void setTermOfValidity(String termOfValidity) {
		this.termOfValidity = termOfValidity;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


	public String getPhone() {
        return phone;
    }

	public void setPhone(String phone) {
        this.phone = phone;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
}

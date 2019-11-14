package com.rgk.entity;

public class MFace {
    private String id;
	
    private int faceId;
    
    private int uid;  //扩展id（0-100）
    
    private String faceContent;  //人脸特征值 
    
    private long expireDate; // 人脸过期时间
    
    private String faceDBID; //人脸库id
    
    private String memeberId;
    
    private String faceUUID;  //人脸库中的人脸uuid
    
    private Boolean isBlack;
    
    private Boolean isWhite;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getFaceId() {
		return faceId;
	}

	public void setFaceId(int faceId) {
		this.faceId = faceId;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getFaceContent() {
		return faceContent;
	}

	public void setFaceContent(String faceContent) {
		this.faceContent = faceContent;
	}

	public long getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(long expireDate) {
		this.expireDate = expireDate;
	}

	public String getFaceDBID() {
		return faceDBID;
	}

	public void setFaceDBID(String faceDBID) {
		this.faceDBID = faceDBID;
	}

	public String getMemeberId() {
		return memeberId;
	}

	public void setMemeberId(String memeberId) {
		this.memeberId = memeberId;
	}

	public String getFaceUUID() {
		return faceUUID;
	}

	public void setFaceUUID(String faceUUID) {
		this.faceUUID = faceUUID;
	}

	public Boolean getIsBlack() {
		return isBlack;
	}

	public void setIsBlack(Boolean isBlack) {
		this.isBlack = isBlack;
	}

	public Boolean getIsWhite() {
		return isWhite;
	}

	public void setIsWhite(Boolean isWhite) {
		this.isWhite = isWhite;
	}

}

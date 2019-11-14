package com.rgk.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户所购买的设备信息
 *
 */
public class MDevice implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String id;
    
    private String villageId;
    
    private String buildingId;		//楼栋
    
    private String deviceNo;    // 设备识别码
    
    private String deviceAlias; //设备别名
    
    private String model;       //设备型号
    
    private String firmwareVersion;  //软件版本
    
    private String hardwareVersion;  //硬件版本号
    
    private String apkVersion;  //门口机apk version
    
    private String iccid;  //物联网卡ID
    
    private String bluetoothMac;  //蓝牙mac地址
    
    private String bluetoothPwd;  //蓝牙mac地址
    
    private String ipAddress;  //ip地址
    
    private String password;  //工程密码
    
	public Date createdDate;
    
	public String createdBy;
	
	public Date modifiedDate;
	
	public String modifiedBy;

    public String getDeviceNo() {
		return deviceNo;
	}

	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}

	public String getFirmwareVersion() {
		return firmwareVersion;
	}

	public void setFirmwareVersion(String firmwareVersion) {
		this.firmwareVersion = firmwareVersion;
	}

	public String getHardwareVersion() {
		return hardwareVersion;
	}

	public void setHardwareVersion(String hardwareVersion) {
		this.hardwareVersion = hardwareVersion;
	}

	public String getApkVersion() {
		return apkVersion;
	}

	public void setApkVersion(String apkVersion) {
		this.apkVersion = apkVersion;
	}

	public String getIccid() {
		return iccid;
	}

	public void setIccid(String iccid) {
		this.iccid = iccid;
	}

	public String getBluetoothMac() {
		return bluetoothMac;
	}

	public void setBluetoothMac(String bluetoothMac) {
		this.bluetoothMac = bluetoothMac;
	}

	public String getBluetoothPwd() {
		return bluetoothPwd;
	}

	public void setBluetoothPwd(String bluetoothPwd) {
		this.bluetoothPwd = bluetoothPwd;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeviceAlias() {
        return deviceAlias;
    }

    public void setDeviceAlias(String deviceAlias) {
        this.deviceAlias = deviceAlias;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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
	
	
	public String getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}

	public String getVillageId() {
		return villageId;
	}

	public void setVillageId(String villageId) {
		this.villageId = villageId;
	}
}

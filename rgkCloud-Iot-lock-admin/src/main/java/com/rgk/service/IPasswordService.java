package com.rgk.service;

import com.rgk.pojo.ReturnObject;

public interface IPasswordService {
	
	ReturnObject createOTP(String deviceId, Long startTime, Long endTime);

}

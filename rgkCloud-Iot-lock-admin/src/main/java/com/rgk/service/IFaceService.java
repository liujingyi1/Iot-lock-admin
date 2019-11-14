package com.rgk.service;

import com.rgk.entity.MFace;
import com.rgk.pojo.ReturnObject;

public interface IFaceService {
	
	public ReturnObject saveFace(MFace face);
	
	public ReturnObject deleteFace(String id);
	
	public ReturnObject updateFace(MFace face);
}

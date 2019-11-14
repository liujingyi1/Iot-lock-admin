package com.rgk.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.rgk.entity.MVisitor;
import com.rgk.pojo.ReturnObject;

@FeignClient("rgkCloud-Iot-lock")
public interface IVistorService {

	@GetMapping("/vistor/save")
	public ReturnObject saveVistor(@RequestBody MVisitor vistor);
	
//	public ReturnObject findAll();
//	
//	public JGridPage<MVisitor> findByPage(int i, Integer rows, String sidx, String sord);
//	
//	public ReturnObject deleteBatch(String id);
//	
//	public ReturnObject findGroupByVillage();
	
}

package com.rgk.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.rgk.entity.MFloor;
import com.rgk.pojo.JGridPage;
import com.rgk.pojo.ReturnObject;

@FeignClient("rgkCloud-Iot-lock")
public interface IFloorService {

	@GetMapping("/floor/save")
	public ReturnObject save(@RequestBody MFloor floor);
	
	@GetMapping("/floor/all")
	public ReturnObject findAll();
	
	@GetMapping("/floor/del")
	public ReturnObject deleteFloor(@RequestParam String id);
	
	@GetMapping("/floor/list")
	public JGridPage<MFloor> findByPage(@RequestParam Integer page,@RequestParam Integer rows,@RequestParam String sidx, @RequestParam String sord);
	
	@GetMapping("/floor/findByBuilding")
	public ReturnObject findByBuilding(@RequestParam String buildingId);
}

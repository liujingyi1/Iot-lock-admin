package com.rgk.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.rgk.entity.MRoom;
import com.rgk.pojo.JGridPage;
import com.rgk.pojo.ReturnObject;

@FeignClient("rgkCloud-Iot-lock")
public interface IRoomService {
	
	@GetMapping("/room/save")
	public ReturnObject save(@RequestBody MRoom room);

	@GetMapping("/room/all")
	public ReturnObject findAll();
	
	@GetMapping("/room/del")
	public ReturnObject deleteRoom(@RequestParam String id);
	
	@GetMapping("/room/list")
	public JGridPage<MRoom> findByPage(@RequestParam Integer page,@RequestParam Integer rows,@RequestParam String sidx, @RequestParam String sord);
	
	@GetMapping("/room/findByFloor")
	public ReturnObject findByFloor(@RequestParam String floorId);
	
//	public ReturnObject findById(String id);
	
//	public List<String> findMembersByVillageId(String villageId);
//	
//	public List<String> findMembersByBuildingId(String[] buildingId);
}

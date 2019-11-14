package com.rgk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rgk.entity.MFloor;
import com.rgk.pojo.JGridPage;
import com.rgk.pojo.ReturnObject;
import com.rgk.service.IFloorService;

@RestController
@RequestMapping("/floor")
public class FloorController {
	
	@Autowired
	IFloorService  floorService;
	
	@RequestMapping("/save")
	public ReturnObject save(MFloor floor) {
		return floorService.save(floor);
	}
	
	@RequestMapping("/all")
	public ReturnObject findAll() {
		System.out.println("floor findall");
		
		return floorService.findAll();
	}
	
	@RequestMapping("/del")
	public ReturnObject deleteFloor(String id) {
		return floorService.deleteFloor(id);
	}
	
	@RequestMapping("/findByBuilding")
	public ReturnObject findByBuilding(String buildingId) {
		return floorService.findByBuilding(buildingId);
	}
	
	@RequestMapping("/list")
	public JGridPage<MFloor> findByPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "rows", defaultValue = "20") Integer rows,
			@RequestParam(value = "sidx", required = false, defaultValue = "id") String sidx,
			@RequestParam(value = "sord", defaultValue = "DESC") String sord) {
		
		System.out.println("floor findByPage");
		
		return floorService.findByPage(page, rows, sidx, sord);
	}
	

}

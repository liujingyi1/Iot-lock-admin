package com.rgk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rgk.entity.MBuilding;
import com.rgk.pojo.JGridPage;
import com.rgk.pojo.ReturnObject;
import com.rgk.service.IBuildingService;

@RestController
@RequestMapping("/building")
public class BuildingController {
	@Autowired
	private IBuildingService buildingService;

	@RequestMapping("/save")
	public ReturnObject saveBuilding(MBuilding building) {
		return buildingService.saveBuilding(building);
	}

	@RequestMapping("/del")
	public ReturnObject delBuilding(String id) {
		return buildingService.delBuilding(id);
	}

	@RequestMapping("/deleteBatch")
	public ReturnObject deleteBatch(String ids) {
		return buildingService.deleteBatch(ids);
	}

	@RequestMapping("/list")
	public JGridPage<MBuilding> findByPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "rows", defaultValue = "20") Integer rows,
			@RequestParam(value = "sidx", required = false, defaultValue = "createdDate") String sidx,
			@RequestParam(value = "sord", defaultValue = "DESC") String sord) {
		return buildingService.findByPage(page, rows, sidx, sord);
	}

	@RequestMapping("/findByVillage")
	public ReturnObject findByVillage(String villageId) {
		return buildingService.findByVillage(villageId);
	}

	@RequestMapping("/all")
	public ReturnObject findAll() {
		return buildingService.findAll();
	}
	
	@RequestMapping("/builldingGroup")
	public ReturnObject findGroupByVillage() {
		return buildingService.findGroupByVillage();
	}
}

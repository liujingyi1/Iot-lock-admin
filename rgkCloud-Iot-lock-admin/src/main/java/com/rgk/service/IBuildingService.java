package com.rgk.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.rgk.entity.MBuilding;
import com.rgk.pojo.JGridPage;
import com.rgk.pojo.ReturnObject;


@FeignClient("rgkCloud-Iot-lock")
public interface IBuildingService {
	/**
	 * 添加/修改楼栋信息
	 * @param building
	 * @return
	 */
	@GetMapping("/building/save")
	public ReturnObject saveBuilding(@RequestBody MBuilding building);
	/**
	 * 删除楼栋信息
	 * @param buildingId
	 * @return
	 */
	@GetMapping("/building/del")
	public ReturnObject delBuilding(@RequestParam String id);
	/**
	 * 查找指定园区楼栋信息
	 * @param villageId
	 * @return
	 */
	@GetMapping("/building/findByVillage")
	public ReturnObject findByVillage(@RequestParam String villageId);
	
	@GetMapping("/building/all")
	public ReturnObject findAll();
	
	@GetMapping("/building/list")
	public JGridPage<MBuilding> findByPage(@RequestParam int page, @RequestParam Integer rows, @RequestParam String sidx,  @RequestParam String sord);
	
	@GetMapping("/building/deleteBatch")
	public ReturnObject deleteBatch(@RequestParam String ids);
	
	@GetMapping("/building/builldingGroup")
	public ReturnObject findGroupByVillage();
	

}

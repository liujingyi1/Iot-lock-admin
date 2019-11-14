package com.rgk.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.rgk.entity.MVillage;
import com.rgk.pojo.JGridPage;
import com.rgk.pojo.ReturnObject;
import com.rgk.service.fallback.VillageServiceFallback;

@FeignClient(name="rgkCloud-Iot-lock", fallback = VillageServiceFallback.class)
public interface IVillageService {
	/**
	 * 增加/修改园区信息
	 * @param village
	 * @return
	 */
	@GetMapping(value = "/village/save")
	public ReturnObject saveVillage(@RequestBody MVillage village);
	/**
	 * 删除
	 * @param villageId
	 * @return
	 */
	@GetMapping("/village/delete")
	public ReturnObject delVillage(@RequestParam String id);
	/**
	 * 所有园区
	 * @param page
	 * @param size
	 * @param property
	 * @param sort
	 * @return
	 */
	@GetMapping("/village/list")
	public JGridPage<MVillage> findByPage(@RequestParam int page, @RequestParam int rows, @RequestParam String sidx, @RequestParam String sord);
	
	@GetMapping("/village/all")
	public ReturnObject findAll();
	
	@GetMapping("/village/deleteBatch")
	public ReturnObject deleteBatch(@RequestParam String id);

}

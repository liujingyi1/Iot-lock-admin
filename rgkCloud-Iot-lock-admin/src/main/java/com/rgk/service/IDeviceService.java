package com.rgk.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.rgk.entity.MDevice;
import com.rgk.pojo.JGridPage;
import com.rgk.pojo.ReturnObject;

@FeignClient("rgkCloud-Iot-lock")
public interface IDeviceService {
	
	@GetMapping("/device/save")
	ReturnObject saveDevice(@RequestBody MDevice device);
	
//	ReturnObject findByVillageIdBuildingId(String villageId, String buildingId);
	/**
	 * 添加设备信息
	 * @param uId
	 * @param device
	 * @param deviceAlias
	 * @param model
	 * @return
	 */
//    ReturnObject create(String device, String deviceAlias, String model, String company);
    /**
     * 删除设备信息
     * @param id
     * @return
     */
	
	@GetMapping("/device/delete")
    ReturnObject delete(@RequestParam String id);
    /**
     * 修改设备信息
     * @param id
     * @param deviceId
     * @param deviceAlias
     * @param model
     * @return
     */
//    ReturnObject modify(String id, String deviceId, String deviceAlias, String model, String company);
    /**
     * 分页展示设备信息
     * @param device
     * @param page
     * @param size
     * @param property
     * @param sort
     * @return
     */
	@GetMapping("/device/list")
    JGridPage<MDevice> list(@RequestParam String deviceId, @RequestParam int page, @RequestParam int rows, @RequestParam String sidx, @RequestParam String sord);

	@GetMapping("/device/state")
	ReturnObject getDeviceState(@RequestParam String deviceId);
    
    /**
     * 批量删除
     * @param id  ids
     * @return
     */
//	ReturnObject deleteBatch(String id);
	/**
	 * 根据当前用户的公司名获取终端设备
	 * @return
	 */
//	List<MDevice> listByCompanny();

}

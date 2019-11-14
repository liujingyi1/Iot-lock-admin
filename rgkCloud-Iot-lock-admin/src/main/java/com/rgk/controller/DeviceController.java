package com.rgk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rgk.entity.MDevice;
import com.rgk.pojo.JGridPage;
import com.rgk.pojo.ReturnObject;
import com.rgk.service.IDeviceService;

/**
 * 设备管理
 *
 */
@RestController
@RequestMapping("/device")
public class DeviceController {

	@Autowired
	private IDeviceService deviceService;

	@RequestMapping("/save")
	public ReturnObject saveDevice(MDevice device) {
		return deviceService.saveDevice(device);
	}

	/**
	 * 删除设备
	 * 
	 * @param deviceId
	 * @return
	 */
	@RequestMapping("/delete")
	public ReturnObject deleteDevice(String id) {
		return deviceService.delete(id);
	}

	/**
	 * 查询
	 * 
	 * @param device
	 * @param page
	 * @param size
	 * @param property
	 * @param sort
	 * @return
	 */
	@RequestMapping("/list")
	public JGridPage<MDevice> deviceList(@RequestParam(value = "deviceId", required = false) String deviceId,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "rows", defaultValue = "20") Integer rows,
			@RequestParam(value = "sidx", required = false, defaultValue = "createdDate") String sidx,
			@RequestParam(value = "sord", defaultValue = "DESC") String sord) {
		return deviceService.list(deviceId, page, rows, sidx, sord);
	}
	
	/**
	 * 获取设备在线状态
	 * 
	 * @param deviceId
	 * @return
	 */
	@RequestMapping("/state")
	public ReturnObject getDeviceState(String deviceId) {
		return deviceService.getDeviceState(deviceId);
	}

}

package com.rgk.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rgk.pojo.ReturnObject;

@FeignClient("rgkCloud-Iot-lock")
public interface ISupplierService {

	@GetMapping("/supplier/add")
	ReturnObject add();

	@GetMapping("/supplier/delete")
	ReturnObject delete(@RequestParam String id);

	@GetMapping("/supplier/modify")
	ReturnObject modify();

}

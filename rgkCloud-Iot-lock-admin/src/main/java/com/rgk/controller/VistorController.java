package com.rgk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rgk.entity.MVisitor;
import com.rgk.pojo.ReturnObject;
import com.rgk.service.IVistorService;

@RestController
@RequestMapping("/vistor")
public class VistorController {
	
	@Autowired
	private IVistorService vistorService;

	@RequestMapping("/save")
	public ReturnObject saveVistor(@RequestBody MVisitor vistor) {
		return vistorService.saveVistor(vistor);
	}

}

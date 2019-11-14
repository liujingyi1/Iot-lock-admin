package com.rgk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rgk.entity.MSupplier;
import com.rgk.pojo.JGridPage;
import com.rgk.pojo.ReturnObject;
import com.rgk.service.ISupplierService;

/**
 * 	供应商管理
 *
 */
@RestController
@RequestMapping("/supplier")
public class SupplierController {
	@Autowired
	private ISupplierService supplierService;
	
	/**
	 * 添加
	 * @return
	 */
	@RequestMapping("/add")
	public ReturnObject add(){
		return supplierService.add();
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	public ReturnObject delete(String id) {
		return supplierService.delete(id);
	}
	
	/**
	 * 修改
	 * @return
	 */
	@RequestMapping("/modify")
	public ReturnObject modify() {
		return supplierService.modify();
	}
	
	/**
	 * 查询
	 * @param page
	 * @param rows
	 * @param sidx
	 * @param sord
	 * @return
	 */
	@RequestMapping("/list")
	public JGridPage<MSupplier> list(@RequestParam(value="page",defaultValue="0")Integer page, 
			@RequestParam(value="rows",defaultValue="20")Integer rows, 
			@RequestParam(value="sidx", required=false, defaultValue="createdDate")String sidx, 
			@RequestParam(value="sord",defaultValue="DESC")String sord) {
		
		
		
		return null;
	}
	
	
	
	

}

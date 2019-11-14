package com.rgk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rgk.entity.MRoom;
import com.rgk.pojo.JGridPage;
import com.rgk.pojo.ReturnObject;
import com.rgk.service.IRoomService;

@RestController
@RequestMapping("/room")
public class RoomController {

	@Autowired
	IRoomService  roomService;
	
	@RequestMapping("/save")
	public ReturnObject save(MRoom room) {
		
		return roomService.save(room);
	}
	
	@RequestMapping("/all")
	public ReturnObject findAll() {
		return roomService.findAll();
	}
	
	@RequestMapping("/del")
	public ReturnObject deleteRoom(String id) {
		return roomService.deleteRoom(id);
	}
	
	@RequestMapping("/list")
	public JGridPage<MRoom> findByPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "rows", defaultValue = "20") Integer rows,
			@RequestParam(value = "sidx", required = false, defaultValue = "id") String sidx,
			@RequestParam(value = "sord", defaultValue = "DESC") String sord) {
		
		return roomService.findByPage(page, rows, sidx, sord);
	}
	
	@RequestMapping("/findByFloor")
	public ReturnObject findByFloor(@RequestParam String floorId) {
		return roomService.findByFloor(floorId);
	}
}

package com.rgk.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.rgk.entity.MCard;
import com.rgk.pojo.JGridPage;
import com.rgk.pojo.ReturnObject;

@FeignClient("rgkCloud-Iot-lock")
public interface ICardService {
	
	@GetMapping("/card/save")
	public ReturnObject saveCard(@RequestBody MCard card);
	
	@GetMapping("/card/delete")
	public ReturnObject delCard(@RequestParam String id);
	
	@GetMapping("/card/deleteBatch")
	public ReturnObject deleteBatch(@RequestParam String id);
	
	@GetMapping("/card/modify")
	public ReturnObject updateCard(@RequestBody MCard card);
	
	@GetMapping("/card/list")
	public JGridPage<MCard> findByPage(@RequestParam Integer page,@RequestParam Integer rows,@RequestParam String sidx, @RequestParam String sord);
	
	@GetMapping("/card/sendInfo")
	public ReturnObject sendCardInfo(@RequestParam String id, @RequestParam String villageId, @RequestParam String buildingId);
}

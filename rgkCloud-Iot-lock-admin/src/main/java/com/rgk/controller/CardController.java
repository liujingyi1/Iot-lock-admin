package com.rgk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rgk.entity.MCard;
import com.rgk.pojo.JGridPage;
import com.rgk.pojo.ReturnObject;
import com.rgk.service.ICardService;

@RestController
@RequestMapping("/card")
public class CardController {
	
	@Autowired
	ICardService cardService;
	
	@RequestMapping("/save")
	public ReturnObject saveCard(MCard card) {
		 return cardService.saveCard(card);
	}
	
	@RequestMapping("/delete")
	public ReturnObject deleteCard(String id) {
		 return cardService.delCard(id);
	}
	
	@RequestMapping("/deleteBatch")
	public ReturnObject deleteBatch(String id) {
		System.out.println("deleteBatch ids="+id);
		return cardService.deleteBatch(id);
	}
	
	@RequestMapping("/modify")
	public ReturnObject updateCard(MCard card) {
		System.out.println("updateCard card="+card.getId());
		 return cardService.updateCard(card);
	}
	
	@RequestMapping("/list")
	public JGridPage<MCard> findByPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "rows", defaultValue = "20") Integer rows,
			@RequestParam(value = "sidx", required = false, defaultValue = "id") String sidx,
			@RequestParam(value = "sord", defaultValue = "DESC") String sord,
			String filters) {
		System.out.println("list findByPage page"+page+" rows="+rows+" sidx="+sidx+" sord="+sord);
		System.out.println("filters="+filters);
		return cardService.findByPage(page, rows, sidx, sord);
	}
	
	@RequestMapping("/sendInfo")
	public ReturnObject sendCardInfo(String id, String villageId, String buildingId) {
		 return cardService.sendCardInfo(id, villageId, buildingId);
	}
}

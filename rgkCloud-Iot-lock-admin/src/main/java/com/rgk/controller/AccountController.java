package com.rgk.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;

@Controller
public class AccountController {
	private Log log = LogFactory.getLog(getClass());


	@RequestMapping("/home")
	public String homePage(HttpServletRequest request) {
//		Enumeration<String> sn = request.getSession().getAttributeNames();
//		while (sn.hasMoreElements()) {
//			String string = (String) sn.nextElement();
//			log.info(string);
//		}
		Object obj = request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
		log.info(JSON.toJSONString(obj));
		log.info("-----homePage------");
		return "home";
	}

	@GetMapping(value = "/devices.html")
	public String devices() {
		log.info("------ devices -----");
		return "devices";
	}

	@GetMapping("/village.html")
	public String village() {
		log.info("------ villages -----");
		return "village";
	}

	@GetMapping("/building.html")
	public String building() {
		log.info("------ building -----");
		return "building";
	}

	@GetMapping("/member.html")
	public String member() {
		log.info("------ member -----");
		return "member";
	}

	@GetMapping("/member-create.html")
	public String memberCreate() {
		log.info("------ memberCreate -----");
		return "member-create";
	}
	
	
	@GetMapping("/floor.html")
	public String floorCreate() {
		log.info("------ floorCreate -----");
		return "floor";
	}
	
	@GetMapping("/room.html")
	public String roomCreate() {
		log.info("------ roomCreate -----");
		return "room";
	}

	@GetMapping("/cards.html")
	public String cardsCreate() {
		log.info("------ cardCreate -----");
		return "cards";
	}
	
}

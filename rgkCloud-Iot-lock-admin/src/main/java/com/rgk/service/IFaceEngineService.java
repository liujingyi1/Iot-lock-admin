package com.rgk.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.rgk.bean.People;

import feign.Headers;

@Configuration
//@FeignClient(url="${spring.faceEngine.url}",name="engine")

@FeignClient(url="http://orion.readsense.cn:80/v1/api",name="engine")
public interface IFaceEngineService {
	
	@RequestMapping(value="/people",method=RequestMethod.POST)
	@Headers({"AppKey: ${faceEngine.AppKey}","AppSecret: AppSecret"})
	public JSONObject createPeople(@RequestParam("name") String name);
	
	@RequestMapping(value="/people/{personId}/add_image",method=RequestMethod.POST)
	@Headers({"AppKey: ${faceEngine.AppKey}","AppSecret: AppSecret"})
	public People addImage(@PathVariable("personId") String personId, byte[] image);
	
}

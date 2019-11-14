package com.rgk.controller;

import java.io.IOException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rgk.entity.MMember;
import com.rgk.pojo.JGridPage;
import com.rgk.pojo.ReturnObject;
import com.rgk.service.IMemberService;
import com.rgk.utils.IdcardUtil;

@RestController
@RequestMapping("/member")
public class MemberController {
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private IMemberService memberService;

	@RequestMapping("/save")
	public ReturnObject saveMember(MMember member) {
		ReturnObject res = new ReturnObject();
		res = memberService.saveMember(member);
		return res;
	}

	@RequestMapping("/del")
	public ReturnObject delMember(String id) {
		return memberService.delMember(id);
	}
	
	@RequestMapping("/deleteBatch")
	public ReturnObject deleteBatch(String id) {
		return memberService.deleteBatch(id);
	}
	
	@RequestMapping("/findByBuilding")
	public ReturnObject findByBuilding(String buildingId) {
		return memberService.findAllByBuilding(buildingId);
	}
	
	@RequestMapping("/idcardIsValidate")
	public boolean idcardIsValidate(String ID) {
		return IdcardUtil.validateCard(ID);
	}
	
	/**
	 * 成员列表
	 * @param page
	 * @param rows
	 * @param sidx
	 * @param sord
	 * @return
	 */
	@RequestMapping("/list")
	public JGridPage<MMember> membersList(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "rows", defaultValue = "20") Integer rows,
			@RequestParam(value = "sidx", required = false, defaultValue = "createdDate") String sidx,
			@RequestParam(value = "sord", defaultValue = "DESC") String sord) {
		return memberService.findByPage(page, rows, sidx, sord);
	}
	
	/**
	 * 上传人脸特征图片
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/uploadFace")
	public ReturnObject uploadFaceImg(@RequestParam("file") MultipartFile file) throws IOException {
		return memberService.uploadFaceImg(file);
	}
	
	/**
	 * 下发人脸特征值
	 * @param id
	 * @return
	 */
	@RequestMapping("/facialFeatures")
	public ReturnObject facialFeatures(String id, String picUrl, String villageId, String buildingId) {
		return memberService.sendFacialFeatures(id, picUrl, villageId, buildingId);
	}
	
	@RequestMapping("/findPhonesByVillage")
	public List<String> findMembersByVillageId(String villageId) {
		 return memberService.findPhonesByVillageId(villageId);
		 
	}
	
	@RequestMapping("/findPhonesByBuilding")
	public List<String> findMemebersByBuildingId(@RequestParam(value="buildingId[]") String[] buildingId) {
		return memberService.findPhonesByBuildingId(buildingId);
	}

}

package com.rgk.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.rgk.entity.MMember;
import com.rgk.pojo.JGridPage;
import com.rgk.pojo.ReturnObject;

@FeignClient("rgkCloud-Iot-lock")
public interface IMemberService {
	/**
	 * 添加/修改人员信息
	 * @param member
	 * @return
	 */
	@GetMapping("/member/save")
	public ReturnObject saveMember(@RequestBody MMember member);
	/**
	 * 删除指定人员信息
	 * @param memberId
	 * @return
	 */
	@GetMapping("/member/del")
	public ReturnObject delMember(@RequestParam String id);
	
	/**
	 * 获取指定楼栋中的人员
	 * @param buildingId
	 * @return 
	 */
	@GetMapping("/member/findByBuilding")
	public ReturnObject findAllByBuilding(@RequestParam String buildingId);
	
	@GetMapping("/member/list")
	public JGridPage<MMember> findByPage(@RequestParam int page, @RequestParam Integer rows, @RequestParam String sidx, @RequestParam String sord);
	
	@GetMapping("/member/deleteBatch")
	public ReturnObject deleteBatch(@RequestParam String id);
	
	
	@GetMapping("/member/uploadFace")
	public ReturnObject uploadFaceImg(@RequestParam("file") MultipartFile file);
	
	/**
	 * 下发人脸特征值
	 * @param id
	 * @param picUrl
	 * @return
	 */
	@GetMapping("/member/facialFeatures")
	public ReturnObject sendFacialFeatures(@RequestParam String id, @RequestParam String picUrl, @RequestParam String villageId, @RequestParam String buildingId);
	
//	public ReturnObject findAllRoomsByPhone(String phone);
	
	@GetMapping("/member/facialFeatures")
	public List<String> findPhonesByVillageId(@RequestParam String villageId);
	
	@GetMapping("/member/findPhonesByBuilding")
	public List<String> findPhonesByBuildingId(@RequestParam(value="buildingId[]") String[] buildingId);
}

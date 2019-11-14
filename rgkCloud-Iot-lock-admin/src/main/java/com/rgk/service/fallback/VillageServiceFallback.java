package com.rgk.service.fallback;

import org.springframework.stereotype.Component;

import com.rgk.entity.MVillage;
import com.rgk.pojo.JGridPage;
import com.rgk.pojo.ReturnObject;
import com.rgk.service.IVillageService;

@Component
public class VillageServiceFallback implements IVillageService {

	@Override
	public ReturnObject saveVillage(MVillage village) {
		return new ReturnObject(0, "", "");
	}

	@Override
	public ReturnObject delVillage(String id) {
		return new ReturnObject(0, "", "");
	}

	@Override
	public JGridPage<MVillage> findByPage(int page, int rows, String sidx, String sord) {
		return new JGridPage<MVillage>();
	}

	@Override
	public ReturnObject findAll() {
		return new ReturnObject();
	}

	@Override
	public ReturnObject deleteBatch(String id) {
		return new ReturnObject(0, "", "");
	}

}

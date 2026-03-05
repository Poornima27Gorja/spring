package com.lpu.mobileApp.service;

import java.util.List;

import com.lpu.mobileApp.dto.MobileRequestDto;
import com.lpu.mobileApp.dto.MobileResponseDto;

public interface MobileServices {
	MobileResponseDto saveMobile(MobileRequestDto m);
	List<MobileResponseDto> findallMobiles();
	MobileResponseDto findMobikleById(int id);
	MobileResponseDto updateMobile(int id, MobileRequestDto m);
	void deleteMobileById(int id);
	List<MobileResponseDto> findByBrandName(String name);
}

package com.lpu.mobileApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.lpu.mobileApp.dto.MobileRequestDto;
import com.lpu.mobileApp.dto.MobileResponseDto;
import com.lpu.mobileApp.entity.Mobile;
import com.lpu.mobileApp.exception.ResourceNotFoundException;
import com.lpu.mobileApp.repository.MobileRepository;
import com.lpu.mobileApp.repository.UserMapper;

@Service
@Primary
public class MobileServiceImp implements MobileServices{
	
	@Autowired
	MobileRepository mr;
	
	@Autowired
	UserMapper um;

	@Override
	@CachePut(value = "mobile", key = "#result.id")
	public MobileResponseDto saveMobile(MobileRequestDto m) {
		Mobile m1 = um.toEntity(m);
		Mobile m2 = mr.save(m1);
		return um.toDto(m2);
	}

	@Override
	public List<MobileResponseDto> findallMobiles() {
		List<Mobile> l= mr.findAll();
		List<MobileResponseDto> lr = new ArrayList<>();
		l.forEach((m) -> lr.add(um.toDto(m)));
		return lr;
	}

	@Override
	@Cacheable(value = "mobile", key="#id")
	public MobileResponseDto findMobikleById(int id) {
		Mobile m = mr.findById(id).orElseThrow(() -> new ResourceNotFoundException("mobile not found for id " + id));
		return um.toDto(m);
	}

	@Override
	@CachePut(value = "mobile", key = "#id")
	public MobileResponseDto updateMobile(int id, MobileRequestDto m) {
		Mobile m1 = mr.findById(id).orElseThrow(() -> new ResourceNotFoundException("mobile not found for id " + id));
		m1.setBrandName(m.getBrandName());
		m1.setColor(m.getColor());
		m1.setModelName(m.getModelName());
		m1.setPrice(m.getPrice());
		m1.setRam(m.getRam());
		m1.setStorage(m.getStorage());
		
		Mobile m2 = mr.save(m1);
		return um.toDto(m2);
	}

	@Override
	@CacheEvict(value = "mobile", key = "#id")
	public void deleteMobileById(int id) {
		Mobile m = mr.findById(id).orElseThrow(() -> new ResourceNotFoundException("No mobile id "+ id + " to delete"));
		mr.delete(m);
	}

	@Override
	public List<MobileResponseDto> findByBrandName(String name) {
		List<Mobile> l= mr.findByBrandName(name);
		List<MobileResponseDto> lr = new ArrayList<>();
		l.forEach((m) -> lr.add(um.toDto(m)));
		return lr;
	}

	
}

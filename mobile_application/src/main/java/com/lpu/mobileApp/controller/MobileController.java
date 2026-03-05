package com.lpu.mobileApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.mobileApp.dto.MobileRequestDto;
import com.lpu.mobileApp.dto.MobileResponseDto;
import com.lpu.mobileApp.service.MobileServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class MobileController {
	@Autowired
	private MobileServices ms;
	
	@PostMapping("mobile")
	public ResponseEntity<MobileResponseDto> saveMobile(@Valid @RequestBody MobileRequestDto m){
		MobileResponseDto r = ms.saveMobile(m);
		return new ResponseEntity<>(r, HttpStatus.CREATED);
	}
	
	@GetMapping("mobile")
	public ResponseEntity<List<MobileResponseDto>> findallMobile(){
		List<MobileResponseDto> lm = ms.findallMobiles();
		return new ResponseEntity<>(lm, HttpStatus.OK);
	}

	@GetMapping("mobile/{id}")
	public ResponseEntity<MobileResponseDto> findById(@PathVariable int id){
		MobileResponseDto m = ms.findMobikleById(id);
		return new ResponseEntity<>(m, HttpStatus.OK);
	}

	@PutMapping("mobile/{id}")
	public ResponseEntity<MobileResponseDto> updateMobile(@PathVariable int id, @RequestBody MobileRequestDto m){
		MobileResponseDto m1 = ms.updateMobile(id, m);
		return new ResponseEntity<>(m1, HttpStatus.OK);
	}
	
	@DeleteMapping("mobile/{id}")
	public ResponseEntity<String> deleteMobileId(@PathVariable int id) {
		ms.deleteMobileById(id);
		return new ResponseEntity<>("Deleted", HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("mobile/brand/{name}")
	public ResponseEntity<List<MobileResponseDto>> findByBrandName(String name){
		List<MobileResponseDto> m = ms.findByBrandName(name);
		return new ResponseEntity<>(m, HttpStatus.OK);
	}
}

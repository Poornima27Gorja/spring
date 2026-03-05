package com.lpu.mobileApp.repository;

import org.mapstruct.Mapper;

import com.lpu.mobileApp.dto.MobileRequestDto;
import com.lpu.mobileApp.dto.MobileResponseDto;
import com.lpu.mobileApp.entity.Mobile;

@Mapper(componentModel = "spring")
public interface UserMapper{
	
	Mobile toEntity(MobileRequestDto rt);
	MobileResponseDto toDto(Mobile m);
}

package com.lpu.mobileApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lpu.mobileApp.entity.Mobile;

@Repository
public interface MobileRepository extends JpaRepository<Mobile, Integer>{
	
	List<Mobile> findByBrandName(String bn);
}

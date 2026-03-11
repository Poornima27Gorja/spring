package com.lpu.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lpu.users.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

}
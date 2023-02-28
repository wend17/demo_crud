package com.wendy.demo.user.repository;

import com.wendy.demo.user.domain.dto.User;
import com.wendy.demo.user.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpa extends JpaRepository <UserEntity,Long> {



}

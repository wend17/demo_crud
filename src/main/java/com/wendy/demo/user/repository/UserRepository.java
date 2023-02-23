package com.wendy.demo.user.repository;

import com.wendy.demo.user.domain.entity.UserEntity;

import java.util.List;

public interface UserRepository {

    List<UserEntity> findAll();
}

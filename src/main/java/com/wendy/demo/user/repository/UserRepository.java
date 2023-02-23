package com.wendy.demo.user.repository;

import com.wendy.demo.user.domain.entity.UserEntity;


import java.util.List;
import java.util.Optional;

public interface UserRepository {

    List<UserEntity> findAll();

    UserEntity save (UserEntity userEntity);

    UserEntity update (UserEntity userEntity);
    Optional<UserEntity> findBydId(long id);

    void  deleteById (Long id);



}

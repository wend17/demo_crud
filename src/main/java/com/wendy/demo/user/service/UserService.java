package com.wendy.demo.user.service;

import com.wendy.demo.user.domain.dto.User;
import com.wendy.demo.user.domain.entity.UserEntity;

import java.util.List;
import java.util.Optional;


public interface UserService {

    List<User> findAll();

    User save (User user);

    User update (User user);

    void  deleteById (Long id);

    User findBydId(long id);
}

package com.wendy.demo.user.service;

import com.wendy.demo.user.domain.dto.User;

import java.util.List;



public interface UserService {

    List<User> findAll();

    User save (User user);

    User update (User user);

    void  deleteById (Long id);
}

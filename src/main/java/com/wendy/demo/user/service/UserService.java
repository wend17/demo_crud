package com.wendy.demo.user.service;

import com.wendy.demo.user.domain.entity.UserEntity;
import com.wendy.demo.user.domain.output.UserOutput;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    List<UserOutput> findAll();

}

package com.wendy.demo.user.repository;

import com.wendy.demo.user.domain.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private UserJpa userJpa;

    public UserRepositoryImpl(UserJpa userJpa) {
        this.userJpa = userJpa;
    }

    @Override
    public List<UserEntity> findAll() {
        return userJpa.findAll();
    }
}

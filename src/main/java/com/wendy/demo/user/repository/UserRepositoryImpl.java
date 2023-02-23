package com.wendy.demo.user.repository;

import com.wendy.demo.user.domain.entity.UserEntity;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


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

    @Override
    public UserEntity save(UserEntity userEntity) {
        return userJpa.save(userEntity);
    }

    @Override
    public UserEntity update(UserEntity userEntity) {
        return userJpa.save(userEntity);
    }

    @Override
    public Optional<UserEntity> findBydId(long id) {
        return userJpa.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        userJpa.deleteById(id);
    }


}

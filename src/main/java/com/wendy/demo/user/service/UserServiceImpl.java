package com.wendy.demo.user.service;

import com.wendy.demo.user.domain.dto.Msm;
import com.wendy.demo.user.domain.entity.UserEntity;

import com.wendy.demo.user.domain.dto.User;
import com.wendy.demo.user.exceptions.MessageCode;
import com.wendy.demo.user.exceptions.DemoException;
import com.wendy.demo.user.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll().stream()
                .map(e -> mapUsera(e))
                .collect(Collectors.toList());
    }

    @Override
    public User save(User user) {
        return mapUsera(userRepository.save(mapUserb(user)));
    }

    @Override
    public User update(User user) {
        userRepository.findBydId(user.getId())
                .orElseThrow(()->new DemoException(MessageCode.ERROR_02));
        return  mapUsera(userRepository.update(mapUserb(user)));
    }

    @Override
    public Msm deleteById(Long id) {
        userRepository.findBydId(id)
                .orElseThrow(()->new DemoException(MessageCode.USER_NOTFOUND));
        userRepository.deleteById(id);
        Msm msm = new Msm();
        msm.setMsm("Usuario eliminado correctamente");
        return msm ;

    }


    @Override
    public User findBydId(long id) {
        UserEntity entity = userRepository.findBydId(id)
                .orElseThrow(()->new DemoException(MessageCode.USER_NOTFOUND));
        return mapUsera(entity);
    }


    private User mapUsera(UserEntity e) {
        User user = new User();
        user.setId(e.getId());
        user.setName(e.getName());
        user.setSurnames(e.getSurnames());
        user.setEmail(e.getEmail());
        user.setDocumentType(e.getDocumentType());
        user.setDocumentNumber(e.getDocumentNumber());
        user.setActive(e.isActive());
        user.setBirthday(e.getBirthday());
        return user;
    }

    private UserEntity mapUserb(User e) {
        UserEntity entity = new UserEntity();
        entity.setName(e.getName());
        entity.setId(e.getId());
        entity.setSurnames(e.getSurnames());
        entity.setEmail(e.getEmail());
        entity.setDocumentType(e.getDocumentType());
        entity.setDocumentNumber(e.getDocumentNumber());
        entity.setActive(e.isActive());
        entity.setBirthday(e.getBirthday());
        return entity;
    }


}

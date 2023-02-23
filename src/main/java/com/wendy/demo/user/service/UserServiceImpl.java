package com.wendy.demo.user.service;

import com.wendy.demo.user.domain.output.UserOutput;
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
    public List<UserOutput> findAll() {
        return userRepository.findAll().stream()
                .map(e->UserOutput.builder()
                        .id(e.getId())
                        .email(e.getEmail())
                        .name(e.getName())
                        .surnames(e.getSurnames())
                        .documentType(e.getDocumentType())
                        .documentNumber(e.getDocumentNumber())
                        .birthday(e.getBirthday())
                        .active(e.isActive())
                        .build())
                .collect(Collectors.toList());
    }
}

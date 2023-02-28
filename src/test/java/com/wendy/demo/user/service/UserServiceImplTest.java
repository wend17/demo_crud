package com.wendy.demo.user.service;

import com.wendy.demo.user.domain.dto.Msm;
import com.wendy.demo.user.domain.dto.User;
import com.wendy.demo.user.domain.entity.UserEntity;
import com.wendy.demo.user.exceptions.DemoException;
import com.wendy.demo.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private User user;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        user = new User();
        user.setId(1L);
        user.setName("Karen");
        user.setSurnames("Rojas Rosas");
        user.setEmail("karen@gmail.com");
        user.setDocumentType("DNI");
        user.setDocumentNumber("45347586");
        user.setActive(true);
    }

    @Test
    void findAll() {
        when(userRepository.findAll()).thenReturn(Arrays.<UserEntity>asList());
        assertNotNull(userService.findAll());
    }

    @Test
    void save() {
        UserEntity userEntity = new UserEntity();
        when(userRepository.save(any())).thenReturn(userEntity);
        User dos = userService.save(user);
        assertNotNull(dos);
    }


    @Test
    void update() {

        UserEntity userEntity = new UserEntity();
        when(userRepository.findBydId(anyLong())).thenReturn(Optional.of(userEntity));
        when(userRepository.update(any())).thenReturn(userEntity);
        User dos = userService.update(user, user.getId());
        assertNotNull(dos);

    }

    @Test
    void findBydId() {
        UserEntity userId = new UserEntity();
        userId.setId(1L);
        userId.setName("Rosa");
        userId.setSurnames("Perez");
        when(userRepository.findBydId(anyLong())).thenReturn((Optional<UserEntity>) Optional.of((userId)));
        User existingUser = userService.findBydId(userId.getId());
        assertNotNull(existingUser);
        assertThat(existingUser.getId()).isNotEqualTo(null);
    }

    @Test
    void findByIdException() {
        when(userRepository.findBydId(anyLong())).thenThrow(DemoException.class);
        assertThrows(DemoException.class,
                () -> {
                    User user = userService.findBydId(1L);
                });
    }

    @Test
    void deleteById() {
        UserEntity deleteUserId = new UserEntity();
        deleteUserId.setId(1L);
        deleteUserId.setName("Rosa");
        deleteUserId.setSurnames("Perez");
        deleteUserId.setEmail("karen@gmail.com");
        deleteUserId.setDocumentType("DNI");
        deleteUserId.setDocumentNumber("45347586");
        deleteUserId.setActive(true);
        when(userRepository.findBydId(anyLong())).thenReturn((Optional<UserEntity>) Optional.of((deleteUserId)));
        Msm existingUser = userService.deleteById(deleteUserId.getId());
        assertNotNull(existingUser);
        assertThat(existingUser.getMsm()).isNotEqualTo(null);
    }


}


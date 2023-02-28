package com.wendy.demo.user.repository;

import com.wendy.demo.user.domain.entity.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class UserRepositoryTest {
    @Mock
    private UserJpa userJpa;

    @InjectMocks
    private UserRepositoryImpl userRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll() {
        when(userJpa.findAll()).thenReturn(Arrays.<UserEntity>asList());
        assertNotNull(userRepository.findAll());
    }

    @Test
    void save() {
        UserEntity userEntity = new UserEntity();
        when(userJpa.save(any())).thenReturn(userEntity);
        UserEntity dos = userRepository.save(userEntity);
        assertNotNull(dos);
    }

    @Test
    void update() {

        UserEntity userEntity = new UserEntity();
        when(userJpa.findById(anyLong())).thenReturn(Optional.of(userEntity));
        when(userJpa.save(any())).thenReturn(userEntity);
        UserEntity dos = userRepository.update(userEntity);
        assertNotNull(dos);

    }

    @Test
    void findBydId() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setName("Rosa");
        userEntity.setSurnames("Perez");
        when(userJpa.findById(1L)).thenReturn(Optional.of(userEntity));
        Optional<UserEntity> dos = userRepository.findBydId(1L);
        assertTrue(dos.isPresent());
    }

    @Test
    void deleteById() {
        Mockito.doNothing().when(userJpa).deleteById(any());
        userRepository.deleteById(1L);
    }
}

package com.wendy.demo.user.repository;

import com.wendy.demo.user.domain.entity.UserEntity;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserJpaTest {

    @Autowired
    private UserJpa userJpa;

    @BeforeEach
    void setUp() {
    }


    @Test
    void findAll() {
        List<UserEntity> list = userJpa.findAll();
        Assert.assertEquals(1, list.size());
    }

    @Test
    void save() {
        UserEntity user = new UserEntity();
        user.setName("wendy2");
        user.setActive(true);
        userJpa.save(user);
        List<UserEntity> list = userJpa.findAll();
        Assert.assertEquals(2, list.size());
    }

    @Test
    void update() {
        UserEntity user = new UserEntity();
        user.setId(1000L);
        user.setName("wendy3");
        user.setActive(true);
        userJpa.save(user);
        Optional<UserEntity> optional = userJpa.findById(1000L);
        Assert.assertTrue(optional.isPresent());
        Assert.assertEquals("wendy3", optional.get().getName());
    }

    @Test
    void findBydId() {
        Optional<UserEntity> optional = userJpa.findById(1000L);
        Assert.assertTrue(optional.isPresent());
    }

    @Test
    void deleteById() {
        userJpa.deleteById(1000L);
        List<UserEntity> list = userJpa.findAll();
        Assert.assertEquals(1, list.size());
    }
}
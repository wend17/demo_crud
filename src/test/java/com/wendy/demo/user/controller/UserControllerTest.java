package com.wendy.demo.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wendy.demo.user.domain.dto.Msm;
import com.wendy.demo.user.domain.dto.User;
import com.wendy.demo.user.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class UserControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private UserService userService;

    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void findAll() throws Exception {
        User user1 = new User();
        user1.setName("oscar");
        User user2 = new User();
        user2.setSurnames("Rojas");
        User user3 = new User();
        user3.setEmail("oscar@gmail.com");
        User user4 = new User();
        user4.setDocumentType("DNI");
        List<User> users = Arrays.asList(user1, user2, user3, user4);
        when(userService.findAll()).thenReturn(users);
        mvc.perform(get("/user").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value("oscar"))
                .andExpect(jsonPath("$[1].surnames").value("Rojas"))
                .andExpect(jsonPath("$[2].email").value("oscar@gmail.com"))
                .andExpect(jsonPath("$[3].documentType").value("DNI"))
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(content().json(objectMapper.writeValueAsString(users)));
    }

    @Test
    void save() throws Exception {
        User user = new User();
        user.setId(null);
        user.setName("Karol");
        user.setSurnames("Rojas");
        user.setEmail("karol@gmail.com");
        user.setDocumentType("DNI");
        user.setDocumentNumber("76543509");
        user.setActive(true);
        when(userService.save(any())).then(invocation -> {
            User u = invocation.getArgument(0);
            u.setId(3L);
            return u;
        });

        mvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user)))

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(3)))
                .andExpect(jsonPath("$.name", is("Karol")))
                .andExpect(jsonPath("$.surnames", is("Rojas")));
        verify(userService).save((any()));

    }

    private static Optional<User> crearUser01() {
        User user = new User();
        user.setId(1L);
        user.setName("Rosa");
        user.setSurnames("Peres");
        return Optional.of(user);
    }

    @Test
    void findById() throws Exception {
        when(userService.findBydId(1L)).thenReturn(crearUser01().orElseThrow());
        mvc.perform(get("/user/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Rosa"))
                .andExpect(jsonPath("$.surnames").value("Peres"));
        verify(userService).findBydId(1L);

    }

    @Test
    void deleteUser() throws Exception {
        Msm msm = new Msm();
        msm.setMsm("");
        when(userService.deleteById(1L)).thenReturn((msm));
        mvc.perform(delete("/user/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    }

    @Test
    void updateUser() throws Exception {
        long id = 1L;
        User updateUser = new User();
        updateUser.setId(1L);
        updateUser.setName("Ricardo");

        when(userService.findBydId(id)).thenReturn(updateUser);
        mvc.perform(put("/user/update/1",id).contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updateUser)))
                .andExpect(status().isOk())
                .andDo(print());



    }
}
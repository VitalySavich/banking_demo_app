package com.vssoftdev.banking_demo_app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vssoftdev.banking_demo_app.entity.User;
import com.vssoftdev.banking_demo_app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MainController {

    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;

    @GetMapping("/api/main")
    public String mainListener(){
        return "Banking App";
    }

    @GetMapping("/api/user")
    public String getUser(@RequestParam int id) throws JsonProcessingException {
        log.info("Get User By Id Operation");

        Optional<User> user = userRepository.findById(id);
        return objectMapper.writeValueAsString(user);
    }

    @GetMapping("/api/user/all")
    public List<User> getAllUsers() {
        log.info("Get All Users Operation");
        return userRepository.findAll();
    }

    @PostMapping("/api/user/add")
    public User addUser(@RequestParam String name, @RequestParam String password){

        User user = new User(name, new Date(), password);
        return userRepository.save(user);
    }

    @PostMapping("/api/user/create")
    public User createUser(@RequestBody User user){
        log.info("Create User Operation");

        return userRepository.save(user);
    }


}

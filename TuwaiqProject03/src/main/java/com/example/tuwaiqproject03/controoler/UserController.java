package com.example.tuwaiqproject03.controoler;

import com.example.tuwaiqproject03.DTO.API;
import com.example.tuwaiqproject03.model.User;
import com.example.tuwaiqproject03.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    Logger logger = LoggerFactory.getLogger(UserController.class);
    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        logger.info("getUsers it's used");
        return ResponseEntity.status(201).body(userService.getUsers());
    }

    @PostMapping
    public ResponseEntity<API> addUser(@RequestBody @Valid User user){
        String message= userService.addUser(user);
        logger.info("addUser it's used");
        return ResponseEntity.status(200).body(new API(message,200));
    }
}

package com.appdev1.expy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appdev1.expy.entity.UserEntity;
import com.appdev1.expy.service.userService;

@RestController
@RequestMapping("api/users")

public class userController {
    @Autowired
    userService userServ;

        @PostMapping("/insertUser")
        public UserEntity createUser(@RequestBody UserEntity user) {
            return userServ.createUser(user);
        }

        @GetMapping("/getAllUsers")
        public List<UserEntity> getAllUsers() {
            return userServ.getAllUsers();
        }

        @GetMapping("/{id}")
        public ResponseEntity<UserEntity> getUserById(@PathVariable int id) {
            return userServ.getUserById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        @PutMapping("/updateUser")
        public UserEntity updateUser(@RequestParam int user_id, @RequestBody UserEntity userDetails) {
            return userServ.updateUser(user_id, userDetails); 
        }
        
        @DeleteMapping("/deleteUser/{user_id}")
        public String deleteUser(@PathVariable int user_id) {
            return userServ.deleteUser(user_id);
        }
}

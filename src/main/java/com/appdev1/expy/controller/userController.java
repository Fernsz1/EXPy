package com.appdev1.expy.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.appdev1.expy.entity.userEntity;
import com.appdev1.expy.service.userService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("api/users")

public class userController {
    @Autowired
    userService userServ;

        @PostMapping("/insertUser")
        public userEntity createUser(@RequestBody userEntity user) {
            return userServ.createUser(user);
        }

        @GetMapping("/getAllUsers")
        public String getMethodName(@RequestParam String param) {
            return new String();
        }

        @PutMapping("/updateUser}")
        public userEntity updateUser(@RequestParam int user_id, @RequestBody userEntity userDetails) {
            return userServ.updateUser(user_id, userDetails); 
        }
        
        @DeleteMapping("/deleteUser")
        public String deleteUser(@PathVariable int user_id) {
            return userServ.deleteUser(user_id);
        }
}

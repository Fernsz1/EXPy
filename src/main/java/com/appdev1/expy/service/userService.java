package com.appdev1.expy.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.appdev1.expy.repository.userRepository;
import com.appdev1.expy.entity.userEntity;

@Service
public class userService {
@Autowired
private userRepository userRepository;

    public userEntity createUser(userEntity user) {
         return userRepository.save(user);
    }

    public List<userEntity> getAllUsers() {
        return userRepository.findAll();
    }
    public userEntity updateUser(int user_id, userEntity userDetails) {
        userEntity user = new userEntity();
        try{
            user = userRepository.findById(user_id).orElseThrow(() -> new Exception("User not found"));
            user.setUsername(userDetails.getUsername());
            user.setEmail(userDetails.getEmail());
            user.setPassword_hash(userDetails.getPassword_hash());
            user.setRole(userDetails.getRole());
            user.setStatus(userDetails.getStatus());
            user.setTotal_xp(userDetails.getTotal_xp());
            user.setLevel(userDetails.getLevel());
            user.setCurrentStreak(userDetails.getCurrentStreak());
            user.setCohortIds(userDetails.getCohortIds());
            user.setBadgeNames(userDetails.getBadgeNames());
       
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("User not found with id: " + user_id);
             
        }finally {
            return userRepository.save(user);
        }
    }

    public String deleteUser(int user_id) {
        String msg="";

        if(userRepository.findById(user_id)!=null){
            userRepository.deleteById(user_id); 
            msg="USER"+user_id+" DELETED SUCCESSFULLY";
        }else{
            msg="USER"+user_id+" NOT FOUND";
        }
        return msg;
    }
}
    


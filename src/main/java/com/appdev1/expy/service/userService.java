package com.appdev1.expy.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev1.expy.entity.InstructorEntity;
import com.appdev1.expy.entity.StudentEntity;
import com.appdev1.expy.entity.UserEntity;
import com.appdev1.expy.repository.StudentRepository;
import com.appdev1.expy.repository.instructorRepository;
import com.appdev1.expy.repository.userRepository;

@Service
public class userService {
    @Autowired
    private userRepository userRepository;
    
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private instructorRepository instructorRepository;

    public UserEntity createUser(UserEntity user) {
         return userRepository.save(user);
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> getUserById(int id) {
        return userRepository.findById(id);
    }

    public UserEntity updateUser(int user_id, UserEntity userDetails) {
        UserEntity user = new UserEntity();
        try{
            user = userRepository.findById(user_id).orElseThrow(() -> new NoSuchElementException("User not found"));
            user.setUsername(userDetails.getUsername());
            user.setEmail(userDetails.getEmail());
            user.setPassword_hash(userDetails.getPassword_hash());
            user.setRole(userDetails.getRole());
            user.setStatus(userDetails.getStatus());
       
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("User not found with id: " + user_id);
             
        }
        return userRepository.save(user);
    }

    public String deleteUser(int id) {
        Optional<UserEntity> userOpt = userRepository.findById(id);
        if (!userOpt.isPresent()) {
            return "User not found";
        }
        UserEntity user = userOpt.get();
        if (user instanceof StudentEntity) {
            studentRepository.deleteById(id);
            return "Student user deleted";
        } else if (user instanceof InstructorEntity) {
            instructorRepository.deleteById(id);
            return "Instructor user deleted";
        } else {
            userRepository.deleteById(id);
            return "User deleted";
        }
}

}
    


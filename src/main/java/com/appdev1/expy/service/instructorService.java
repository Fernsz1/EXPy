package com.appdev1.expy.service;

import java.util.List;
import java.util.Optional;

import org.openqa.selenium.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev1.expy.entity.InstructorEntity;
import com.appdev1.expy.entity.StudentEntity;
import com.appdev1.expy.entity.UserEntity;
import com.appdev1.expy.repository.instructorRepository;
import com.appdev1.expy.repository.userRepository;


@Service
public class instructorService {

    @Autowired
    instructorRepository instructorRepository;

    @Autowired
    private userRepository userRepository;

    @Autowired
    private userService userService;

    public instructorService(instructorRepository instructorRepository, 
                          userRepository userRepository,
                          userService userService) {
        this.instructorRepository = instructorRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    //C
    public InstructorEntity createInstructor (InstructorEntity admin) {
        return instructorRepository.save(admin);
    }

    //R
    public List<InstructorEntity> getAllInstructor() {
        return instructorRepository.findAll();
    }

    public Optional<InstructorEntity> getInstructorById(int id) {
        return instructorRepository.findById(id);
    }

    //U
    public InstructorEntity updateInstructor(int instructor_id, InstructorEntity updatedInstructor) {
        InstructorEntity instructor = instructorRepository.findById(instructor_id)
                .orElseThrow(() -> new NoSuchElementException("Instructor not found with id: " + instructor_id));

        instructor.setUsername(updatedInstructor.getUsername());
        instructor.setEmail(updatedInstructor.getEmail());
        instructor.setPassword_hash(updatedInstructor.getPassword_hash());
        instructor.setRole(updatedInstructor.getRole());
        instructor.setStatus(updatedInstructor.getStatus());
        instructor.setBio(updatedInstructor.getBio());
        // instructor.setCohorts(updatedDetails.getCohorts());
        // instructor.setReports(updatedDetails.getReports());
        // instructor.setActivities(updatedDetails.getActivities());
        
        return instructorRepository.save(instructor);
    }


    //D
    public String deleteInstructor(int id) {
        Optional<UserEntity> userOpt = userRepository.findById(id);
        if (!userOpt.isPresent()) {
            return "Instructor with id " + id + " not found";
        }
        UserEntity user = userOpt.get();
        if (!(user instanceof InstructorEntity)) {
            return "Instructor with id " + id + " not found";
        }

        return userService.deleteUser(id);
    }

}

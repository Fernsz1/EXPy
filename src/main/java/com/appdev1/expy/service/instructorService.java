package com.appdev1.expy.service;

import java.util.List;
import java.util.Optional;

import org.openqa.selenium.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev1.expy.entity.InstructorEntity;
import com.appdev1.expy.entity.StudentEntity;
import com.appdev1.expy.repository.instructorRepository;


@Service
public class instructorService {

    @Autowired
    instructorRepository instructorRepository;

    public instructorService(instructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
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
    public InstructorEntity updateInstructor(int instructor_id, InstructorEntity updatedDetails) {
        InstructorEntity instructor = instructorRepository.findById(instructor_id)
                .orElseThrow(() -> new NoSuchElementException("Instructor not found with id: " + instructor_id));

        instructor.setBio(updatedDetails.getBio());
        // instructor.setCohorts(updatedDetails.getCohorts());
        // instructor.setReports(updatedDetails.getReports());
        // instructor.setActivities(updatedDetails.getActivities());
        
        return instructorRepository.save(instructor);
    }


    //D
    public String deleteInstructor(int id) {
        Optional<InstructorEntity> instructorOpt = instructorRepository.findById(id);
        if (instructorOpt.isPresent()) {
            instructorRepository.deleteById(id);
            return "Instructor with id " + id + " deleted successfully";
        } else {
            return "Instructor with id " + id + " not found";
        }
    }

}

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

import com.appdev1.expy.entity.InstructorEntity;
import com.appdev1.expy.service.instructorService;

@RestController
@RequestMapping("/api/instructors")
public class instructorController {

    @Autowired
    instructorService instructorService;

    public instructorController(instructorService instructorService) {
        this.instructorService = instructorService;
    }

    //C
    @PostMapping("/insertInstructor")
    public InstructorEntity createInstructor(@RequestBody InstructorEntity admin) {
        return instructorService.createInstructor(admin);
    }

    //R
    @GetMapping("/getAllInstructors")
    public List<InstructorEntity> getAllInstructor() {
        return instructorService.getAllInstructor();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstructorEntity> getInstructorById(@PathVariable int id) {
        return instructorService.getInstructorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //U
    @PutMapping("/updateInstructor")
    public InstructorEntity updateInstructor(@RequestParam int instructor_id, @RequestBody InstructorEntity updatedInstructorData) {
        return instructorService.updateInstructor(instructor_id, updatedInstructorData);
    }

    //D
    @DeleteMapping("/deleteInstructor/{instructor_id}")
    public String deleteInstructor(@PathVariable int instructor_id) {
        return instructorService.deleteInstructor(instructor_id);
    }
}

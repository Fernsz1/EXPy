package com.appdev1.expy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.appdev1.expy.entity.courseEntity;
import com.appdev1.expy.service.courseService;

@RestController
@RequestMapping(method = RequestMethod.GET, path = "/api/courses")
public class courseController {

    @Autowired
    private courseService courseServ;

    @GetMapping("/hello")
    public String returnString() {
        return "Hello World";
    }
    
    @PostMapping("/createCourse")
    public courseEntity postCourseRecord(@RequestBody courseEntity course) {
        return courseServ.createCourse(course);
    }

    @GetMapping("/getAllCourses")
    public List<courseEntity> getAllCourses() {
        return courseServ.getAllCourses();
    }
    
}

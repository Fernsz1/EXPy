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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appdev1.expy.entity.CourseEntity;
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
    public CourseEntity postCourseRecord(@RequestBody CourseEntity course) {
        return courseServ.createCourse(course);
    }

    @GetMapping("/getAllCourses")
    public List<CourseEntity> getAllCourses() {
        return courseServ.getAllCourses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseEntity> getCourseById(@PathVariable int id) {
        return courseServ.getCourseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PutMapping("/updateCourse")
    public CourseEntity updateCourse(@RequestParam int course_id, @RequestBody CourseEntity course) {
        return courseServ.updateCourse(course_id, course);
    }

    @DeleteMapping("/deleteCourse/{course_id}")
    public String deleteCourse(@PathVariable int course_id) {
        return courseServ.deleteCourse(course_id);
    }

}
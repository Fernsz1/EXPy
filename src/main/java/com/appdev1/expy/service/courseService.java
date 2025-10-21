package com.appdev1.expy.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev1.expy.entity.CourseEntity;
import com.appdev1.expy.repository.courseRepository;

@Service
public class courseService {

    @Autowired
    courseRepository courseRepository;

    public courseService() {
        super();
    }

    // C
    public CourseEntity createCourse(CourseEntity course) {
        return courseRepository.save(course);
    }

    // R
    public List<CourseEntity> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<CourseEntity> getCourseById(int id) {
        return courseRepository.findById(id);
    }

    // U
    public CourseEntity updateCourse(int course_id, CourseEntity course) {
        CourseEntity newCourse = null;
        try {
            newCourse = courseRepository.findById(course_id).get();
            newCourse.setTitle(course.getTitle());
            newCourse.setDescription(course.getDescription());
    
            courseRepository.save(newCourse);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Error updating cohort: " + e.getMessage());
        }
        
        return newCourse;
    }

     //D
     public String deleteCourse(int course_id) {
        String msg = "";
        try {
            if (courseRepository.findById(course_id) != null) {
                courseRepository.deleteById(course_id);
                msg = "Course with ID " + course_id + " deleted successfully.";
            } else {
                msg = "Course with ID " + course_id + " not found.";
            }
        } catch (Exception e) {
            msg = "Error deleting course: " + e.getMessage();
        } 

        return msg;
    }
    
}

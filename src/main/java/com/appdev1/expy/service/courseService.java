package com.appdev1.expy.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.appdev1.expy.entity.courseEntity;
import com.appdev1.expy.repository.courseRepository;

@Service
public class courseService {

    @Autowired
    courseRepository courseRep;

    public courseService() {
        super();
    }

    public courseEntity createCourse(courseEntity course) {
        return courseRep.save(course);
    }

    public List<courseEntity> getAllCourses() {
        return courseRep.findAll();
    }
    
}

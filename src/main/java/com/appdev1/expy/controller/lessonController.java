package com.appdev1.expy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.appdev1.expy.entity.lessonEntity;
import com.appdev1.expy.service.lessonService;


@RestController
@RequestMapping(method = RequestMethod.GET, path = "/api/lessons")
public class lessonController {
    @Autowired
    private lessonService lessonService;

    @GetMapping("/hello")
    public String returnString() {
        return "Hello World";
    }
    
    @PostMapping("/createLesson")
    public lessonEntity postCourseRecord(@RequestBody lessonEntity lesson) {
        return lessonService.createLesson(lesson);
    }

    @GetMapping("/getAllLessons")
    public List<lessonEntity> getAllLessons() {
        return lessonService.getAllLessons();
    }

    @PutMapping("/updateLesson")
    public lessonEntity updateLesson(@RequestParam int lesson_id, @RequestBody lessonEntity lesson) {
        return lessonService.updateLesson(lesson_id, lesson);
    }

    @DeleteMapping("/deleteLesson")
    public String deleteLesson(@PathVariable int lesson_id) {
        return lessonService.deleteLesson(lesson_id);
    }
}

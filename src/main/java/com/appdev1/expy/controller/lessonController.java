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

import com.appdev1.expy.entity.LessonEntity;
import com.appdev1.expy.service.lessonService;


@RestController
@RequestMapping("/api/lessons")
public class lessonController {
    @Autowired
    private lessonService lessonService;

    @GetMapping("/hello")
    public String returnString() {
        return "Hello World";
    }
    
    @PostMapping("/createLesson")
    public LessonEntity postCourseRecord(@RequestBody LessonEntity lesson) {
        return lessonService.createLesson(lesson);
    }

    @GetMapping("/getAllLessons")
    public List<LessonEntity> getAllLessons() {
        return lessonService.getAllLessons();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LessonEntity> getLessonById(@PathVariable int id) {
        return lessonService.getLessonById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/updateLesson")
    public LessonEntity updateLesson(@RequestParam int lesson_id, @RequestBody LessonEntity lesson) {
        return lessonService.updateLesson(lesson_id, lesson);
    }

    @DeleteMapping("/deleteLesson/{lesson_id}")
    public String deleteLesson(@PathVariable int lesson_id) {
        return lessonService.deleteLesson(lesson_id);
    }
}

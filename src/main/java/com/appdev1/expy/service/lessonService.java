package com.appdev1.expy.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev1.expy.entity.LessonEntity;
import com.appdev1.expy.repository.lessonRepository;

@Service
public class lessonService {
    @Autowired
    lessonRepository lessonRep;

    public lessonService() {
        super();
    }

    //C
    public LessonEntity createLesson(LessonEntity lesson) {
        return lessonRep.save(lesson);
    }

    //R
    public List<LessonEntity> getAllLessons() {
        return lessonRep.findAll();
    }

    public Optional<LessonEntity> getLessonById(int id) {
        return lessonRep.findById(id);
    }

    //U
    public LessonEntity updateLesson(int lesson_id, LessonEntity lesson) {
        LessonEntity newLesson;
        try {
            newLesson = lessonRep.findById(lesson_id).get();
            newLesson.setTitle(lesson.getTitle());
            newLesson.setContent(lesson.getContent());
            newLesson.setDifficulty(lesson.getDifficulty());
            newLesson.setXp_reward(lesson.getXp_reward());
            newLesson.setOrder_index(lesson.getOrder_index());
            lessonRep.save(newLesson);
            return lessonRep.save(newLesson);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Lesson with ID " + lesson_id + " not found.");
        } 
    }

    //D
    public String deleteLesson(int lesson_id) {
        String msg = "";

        if(lessonRep.findById(lesson_id) != null){
            lessonRep.deleteById(lesson_id);
            msg = "Lesson with ID " + lesson_id + " has been deleted.";
        } else {
            msg = "Lesson with ID " + lesson_id + " does not exist.";
        }
        return msg;
    }
}

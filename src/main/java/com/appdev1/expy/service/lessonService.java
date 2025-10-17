package com.appdev1.expy.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev1.expy.entity.lessonEntity;
import com.appdev1.expy.repository.lessonRepository;

@Service
public class lessonService {
    @Autowired
    lessonRepository lessonRep;

    public lessonService() {
        super();
    }

    //C
    public lessonEntity createLesson(lessonEntity lesson) {
        return lessonRep.save(lesson);
    }

    //R
    public List<lessonEntity> getAllLessons() {
        return lessonRep.findAll();
    }

    //U
    @SuppressWarnings("finally")
    public lessonEntity updateLesson(int lesson_id, lessonEntity lesson) {
        lessonEntity newLesson = new lessonEntity();
        try {
            newLesson = lessonRep.findById(lesson_id).get();
            newLesson.setTitle(lesson.getTitle());
            newLesson.setContent(lesson.getContent());
            newLesson.setDifficulty(lesson.getDifficulty());
            newLesson.setXpReward(lesson.getXpReward());
            newLesson.setOrderIndex(lesson.getOrderIndex());

            lessonRep.save(newLesson);
            return newLesson;

        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Lesson with ID " + lesson_id + " not found.");

        } finally {
            return lessonRep.save(newLesson);
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

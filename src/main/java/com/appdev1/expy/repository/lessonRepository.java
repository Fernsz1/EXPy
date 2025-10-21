package com.appdev1.expy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appdev1.expy.entity.LessonEntity;

@Repository
public interface lessonRepository extends JpaRepository<LessonEntity, Integer> {

}

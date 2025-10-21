package com.appdev1.expy.entity;


import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tblActivity")
public class ActivityEntity {
     @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int activity_id;
    private String type;
    private String title;
    private String instructions;
    private String starter_code;
    private String hints;
    
    @ElementCollection
    private List<String> test_cases;

    private int xp_reward;

    @ManyToOne
    @JoinColumn(name="lesson_id")
    private LessonEntity lesson;

    @ManyToOne
    @JoinColumn(name = "instructor_id",  referencedColumnName = "user_id")
    private InstructorEntity instructor;

    @ManyToMany(mappedBy = "activities")
    private List<StudentEntity> students;

    public ActivityEntity() {
        super();
    }

    public int getActivity_id() {
        return activity_id;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getStarter_code() {
        return starter_code;
    }

    public void setStarter_code(String starter_code) {
        this.starter_code = starter_code;
    }

    public String getHints() {
        return hints;
    }

    public void setHints(String hints) {
        this.hints = hints;
    }

    public List<String> getTest_cases() {
        return test_cases;
    }

    public void setTest_cases(List<String> test_cases) {
        this.test_cases = test_cases;
    }

    public int getXp_reward() {
        return xp_reward;
    }

    public void setXp_reward(int xp_reward) {
        this.xp_reward = xp_reward;
    }

    public LessonEntity getLesson() {
        return lesson;
    }

    public void setLesson(LessonEntity lesson) {
        this.lesson = lesson;
    }

    public InstructorEntity getInstructor() {
        return instructor;
    }

    public void setInstructor(InstructorEntity instructor) {
        this.instructor = instructor;
    }

    public List<StudentEntity> getStudents() {
        return students;
    }

    public void setStudents(List<StudentEntity> students) {
        this.students = students;
    }

    
}

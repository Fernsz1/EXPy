package com.appdev1.expy.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tblCohort")
public class CohortEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cohort_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;
    
    @ManyToOne
    @JoinColumn(name="instructor_id", referencedColumnName = "user_id", nullable=false)
    private InstructorEntity instructor;

    @ManyToOne
    @JoinColumn(name="course_id", referencedColumnName = "course_id", nullable=false)
    private CourseEntity course;

    @ManyToMany
    @JoinTable(
        name = "cohort_student",
        joinColumns = @JoinColumn(name = "cohort_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName= "user_id")
    )
    private Set<UserEntity> students = new HashSet<>();

    public CohortEntity() {
        super();
    }

    public CohortEntity(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public int getCohort_id() {
        return cohort_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public InstructorEntity getInstructor() {
        return instructor;
    }

    public void setInstructor(InstructorEntity instructor) {
        this.instructor = instructor;
    }

    public CourseEntity getCourse() {
        return course;
    }

    public void setCourse(CourseEntity course) {
        this.course = course;
    }

    public Set<UserEntity> getStudents() {
        return students;
    }

    public void setStudents(Set<UserEntity> students) {
        this.students = students;
    }

    

}
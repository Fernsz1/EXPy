package com.appdev1.expy.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "cohort_id" 
) // this shows the ID instead of the full object to prevent circular reference -z
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
    @JsonIdentityReference(alwaysAsId = true) //shows only ID to prevent circular reference -z
    private InstructorEntity instructor;

    @ManyToOne
    @JoinColumn(name="course_id", referencedColumnName = "course_id", nullable=false)
    //@JsonBackReference(value = "course-cohorts") //prevents circular reference during serialization -z
    private CourseEntity course;

    @ManyToMany
    @JoinTable(
        name = "cohort_student",
        joinColumns = @JoinColumn(name = "cohort_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName= "user_id")
    )
    @JsonIdentityReference(alwaysAsId = true) //shows only IDs to prevent circular reference -z
    private Set<StudentEntity> students = new HashSet<>();

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

    public Set<StudentEntity> getStudents() {
        return students;
    }

    public void setStudents(Set<StudentEntity> students) {
        this.students = students;
    }

    

}
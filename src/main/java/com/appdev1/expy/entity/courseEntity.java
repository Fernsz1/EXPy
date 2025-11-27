package com.appdev1.expy.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblCourse")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int course_id;
    
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "course-modules") //prevents circular reference during serialization -z
    @JsonIdentityReference(alwaysAsId = true) //shows only IDs to prevent circular reference -z
    private List<ModuleEntity> modules = new ArrayList<>();

    @OneToMany(mappedBy = "course")
    @JsonManagedReference(value = "course-cohorts") //prevents circular reference during serialization -z
    @JsonIdentityReference(alwaysAsId = true) //shows only IDs to prevent circular reference -z
    private List<CohortEntity> cohorts = new ArrayList<>();

    public CourseEntity() {
        super();
    }

    public int getCourse_id() {
        return course_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ModuleEntity> getModules() {
        return modules;
    }

    public void setModules(List<ModuleEntity> modules) {
        this.modules = modules;
    }

    public List<CohortEntity> getCohorts() {
        return cohorts;
    }

    public void setCohorts(List<CohortEntity> cohorts) {
        this.cohorts = cohorts;
    }



}
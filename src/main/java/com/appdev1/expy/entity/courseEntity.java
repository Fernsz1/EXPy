package com.appdev1.expy.entity;

import java.util.ArrayList;
import java.util.List;

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
@Table(name = "course")
public class courseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int course_id;
    
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    // One course contains many modules
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<moduleEntity> modules = new ArrayList<>();

    public courseEntity() {
        super();
    }

    public courseEntity(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public courseEntity(int course_id, String title, String description) {
        this.course_id = course_id;
        this.title = title;
        this.description = description;
    }

    // Getters and Setters
    public int getCourseId() { 
        return course_id; 
    }
    
    public void setCourseId(int course_id) { 
        this.course_id = course_id; 
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

    public void setModules(List<moduleEntity> modules) { 
        this.modules = modules; 
    }

    public void addModule(moduleEntity module) {
        modules.add(module);
        module.setCourse(this);
    }

}
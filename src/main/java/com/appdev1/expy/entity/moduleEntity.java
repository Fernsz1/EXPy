package com.appdev1.expy.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblModule")
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "module_id" 
)
public class ModuleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int module_id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int order_index;

    @ManyToOne(optional = false)
    @JoinColumn(name = "course_id", nullable = false)
    //@JsonBackReference(value = "course-modules")
    @JsonIdentityReference(alwaysAsId = true)
    private CourseEntity course;

    @OneToMany(mappedBy = "module")
    //@JsonManagedReference(value = "module-lessons")
    @JsonIdentityReference(alwaysAsId = true)
    private List<LessonEntity> lessons;

    public ModuleEntity() {}

    public ModuleEntity(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    public int getModule_id() {
        return module_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public int getOrder_index() {
        return order_index;
    }

    public void setOrder_index(int order_index) {
        this.order_index = order_index;
    }

    public CourseEntity getCourse() {
        return course;
    }

    public void setCourse(CourseEntity course) {
        this.course = course;
    }

    public List<LessonEntity> getLessons() {
        return lessons;
    }

    public void setLessons(List<LessonEntity> lessons) {
        this.lessons = lessons;
    }

    
}

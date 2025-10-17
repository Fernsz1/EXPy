package com.appdev1.expy.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "module_entity")
public class ModuleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int module_id;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private CourseEntity course;

    public ModuleEntity() {}

    public ModuleEntity(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    public int getModuleId() {
        return module_id;
    }

    public void setModuleId(int module_id) {
        this.module_id = module_id;
    }

    public String getModuleCode() {
        return code;
    }

    public void setModuleCode(String code) {
        this.code = code;
    }

    public String getModuleName() {
        return name;
    }

    public void setModuleName(String name) {
        this.name = name;
    }

    public String getModuleDescription() {
        return description;
    }

    public void setModuleDescription(String description) {
        this.description = description;
    }

    public CourseEntity getCourse() {
        return course;
    }

    public void setCourse(CourseEntity course) {
        this.course = course;
    }
}

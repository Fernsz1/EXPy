package com.appdev1.expy.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class lessonEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int lessonId;
    private String title;
    private String content;
    private String difficulty;
    private int xpReward;
    private int orderIndex;

    @OneToMany(mappedBy="lesson")
    private List<activityEntity> activities;

    @ManyToOne
    @JoinColumn(name="module_id", nullable=false)
    private ModuleEntity module;

}

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
    private int lesson_id;
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

    public int getLesson_id() {
        return lesson_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int getXpReward() {
        return xpReward;
    }

    public void setXpReward(int xpReward) {
        this.xpReward = xpReward;
    }

    public int getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(int orderIndex) {
        this.orderIndex = orderIndex;
    }

    public List<activityEntity> getActivities() {
        return activities;
    }

    public void setActivities(List<activityEntity> activities) {
        this.activities = activities;
    }

    public ModuleEntity getModule() {
        return module;
    }

    public void setModule(ModuleEntity module) {
        this.module = module;
    }

}

package com.appdev1.expy.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tblLesson")
public class LessonEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int lesson_id;
    private String title;
    private String content;
    private String difficulty;
    private int xp_reward;
    private int order_index;

    @OneToMany(mappedBy="lesson")
    private List<ActivityEntity> activities;

    @ManyToOne
    @JoinColumn(name="module_id", nullable=false)
    private ModuleEntity module;

    public LessonEntity() {
        super();
    }

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

    public int getXp_reward() {
        return xp_reward;
    }

    public void setXp_reward(int xp_reward) {
        this.xp_reward = xp_reward;
    }

    public int getOrder_index() {
        return order_index;
    }

    public void setOrder_index(int order_index) {
        this.order_index = order_index;
    }

    public List<ActivityEntity> getActivities() {
        return activities;
    }

    public void setActivities(List<ActivityEntity> activities) {
        this.activities = activities;
    }

    public ModuleEntity getModule() {
        return module;
    }

    public void setModule(ModuleEntity module) {
        this.module = module;
    }

    
}

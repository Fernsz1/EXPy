package com.appdev1.expy.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;
import jakarta.persistence.ElementCollection;
import com.appdev1.expy.entity.userEntity;
import com.appdev1.expy.entity.lessonEntity;

@Entity
@Table(name="tblActivity")
public class activityEntity {
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

    @OneToMany(mappedBy = "activity")
    private List<userEntity> users;
    
    @OneToMany(mappedBy = "activity")
    private List<lessonEntity> lessons;

    //missing connection to Lesson Entity

    public activityEntity() {
        super();
    }

    public void setActivity_id(int activity_id) {
        this.activity_id = activity_id;
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
    public List<userEntity> getUsers() {
        return users;
    }
    public void setUsers(List<userEntity> users) {
        this.users = users;
    }
    public List<lessonEntity> getLessons() {
        return lessons;
    }
    public void setLessons(List<lessonEntity> lessons) {
        this.lessons = lessons;
    }

}

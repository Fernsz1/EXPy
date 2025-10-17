package com.appdev1.expy.entity;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
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
@Table(name="cohorts")
public class cohortEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cohort_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;
    
    @ElementCollection
    @CollectionTable(name = "cohort_members", joinColumns = @JoinColumn(name = "cohort_id"))
    @Column(name = "member_id")
    private List<Integer> member_ids = new LinkedList<>();

    // Many cohorts can belong to one module
    @ManyToOne
    @JoinColumn(name = "module_id", nullable = false)
    private moduleEntity module;

    // Many-to-many relationship with User (a cohort has many users, users can be in many cohorts)
    @ManyToMany
    @JoinTable(
        name = "user_cohort",
        joinColumns = @JoinColumn(name = "cohort_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<userEntity> users = new HashSet<>();

    // Many-to-many relationship with Lesson (attempts)
    @ManyToMany
    @JoinTable(
        name = "cohort_lesson_attempts",
        joinColumns = @JoinColumn(name = "cohort_id"),
        inverseJoinColumns = @JoinColumn(name = "lesson_id")
    )
    
    private Set<lessonEntity> attemptedLessons = new HashSet<>();

    public cohortEntity() {
        super();
    }

    public cohortEntity(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Getters and Setters
    public int getCohortId() { 
        return cohort_id; 
    }
    
    public void setCohortId(int cohort_id) { 
        this.cohort_id = cohort_id; 
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

    public List<Integer> getMemberIds() { 
        return member_ids; 
    }
    
    public void setMemberIds(List<Integer> member_ids) { 
        this.member_ids = member_ids; 
    }

    public moduleEntity getModule() { 
        return module; 
    }
    
    public void setModule(moduleEntity module) { 
        this.module = module; 
    }

    public Set<userEntity> getUsers() { 
        return users; 
    }
    
    public void setUsers(Set<userEntity> users) { 
        this.users = users; 
    }

    public Set<lessonEntity> getAttemptedLessons() { 
        return attemptedLessons; 
    }
    
    public void setAttemptedLessons(Set<lessonEntity> attemptedLessons) { 
        this.attemptedLessons = attemptedLessons; 
    }

}
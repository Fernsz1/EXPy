package com.appdev1.expy.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

public class cohortEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cohortId;

    private String name;
    private String description;
    private List<Integer> memberIds;

    public cohortEntity() {
        super();
    }

    public cohortEntity(int cohortId, String name, String description, List<Integer> memberIds) {
        this.cohortId = cohortId;
        this.name = name;
        this.description = description;
        this.memberIds = memberIds;
    }

    public int getCohortId() { return cohortId; }
    // public void setCohortId(int cohortId) { this.cohortId = cohortId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }


}  
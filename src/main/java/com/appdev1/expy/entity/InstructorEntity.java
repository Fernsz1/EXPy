package com.appdev1.expy.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblInstructor")
@PrimaryKeyJoinColumn(name = "user_id")
public class InstructorEntity extends UserEntity {

    private String bio;

    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ReportEntity> reports = new ArrayList<>();

    @OneToMany(mappedBy = "instructor")
    private List<CohortEntity> cohorts = new ArrayList<>();

    @OneToMany(mappedBy = "instructor")
    private List<ActivityEntity> activities = new ArrayList<>();

    public InstructorEntity() {}

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<ReportEntity> getReports() {
        return reports;
    }

    public void setReports(List<ReportEntity> reports) {
        this.reports = reports;
    }

    public List<CohortEntity> getCohorts() {
        return cohorts;
    }

    public void setCohorts(List<CohortEntity> cohorts) {
        this.cohorts = cohorts;
    }

    public List<ActivityEntity> getActivities() {
        return activities;
    }

    public void setActivities(List<ActivityEntity> activities) {
        this.activities = activities;
    }



}

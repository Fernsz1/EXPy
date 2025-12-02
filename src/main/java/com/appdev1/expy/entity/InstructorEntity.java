package com.appdev1.expy.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblInstructor")
@PrimaryKeyJoinColumn(name = "user_id")
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "user_id"  // use the inherited field from UserEntity
)
public class InstructorEntity extends UserEntity {

    private String bio;

    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL, orphanRemoval = true)
    //@JsonManagedReference(value = "instructor-reports") //-no need since back reference is removed- prevents circular reference during serialization -z
    @JsonIdentityReference(alwaysAsId = true) //shows only IDs to prevent circular reference -z
    private List<ReportEntity> reports = new ArrayList<>();

    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL)
    //@JsonManagedReference(value = "instructor-cohorts") //prevents circular reference during serialization -z
    @JsonIdentityReference(alwaysAsId = true) //shows only IDs to prevent circular reference -z 
    private List<CohortEntity> cohorts = new ArrayList<>();

    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL)
    //@JsonManagedReference(value = "instructor-activities") //prevents circular reference during serialization -z
    @JsonIdentityReference(alwaysAsId = true) //shows only IDs to prevent circular reference -z
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

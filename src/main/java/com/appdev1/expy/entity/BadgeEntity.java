package com.appdev1.expy.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblBadge")
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "badge_id" 
) // this shows the ID instead of the full object to prevent circular reference -z
public class BadgeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int badge_id;

    private String name;
    private String description;
    private String imageUrl;
    private String criteria;

    @ManyToMany(mappedBy = "badges")
    //@JsonIgnore //hides students who have this badge to prevent circular reference -z
    @JsonIdentityReference(alwaysAsId=true)
    private Set<StudentEntity> students = new HashSet<>();
    
    public BadgeEntity(){
        super();
    }

    public int getBadge_id() {
        return badge_id;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public Set<StudentEntity> getStudents() {
        return students;
    }

    public void setStudents(Set<StudentEntity> students) {
        this.students = students;
    }

}

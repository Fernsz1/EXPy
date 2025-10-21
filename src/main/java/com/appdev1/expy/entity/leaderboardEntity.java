package com.appdev1.expy.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tblLeaderboard")
public class LeaderboardEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int leaderboard_id;
    private String name;
    private String periodType;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "leaderboard_users",
        joinColumns = @JoinColumn(name = "leaderboard_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "user_id")
    )
    private List<UserEntity> students;

    public LeaderboardEntity() {
        super();
    }

    public int getLeaderboard_id() {
        return leaderboard_id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPeriodType() {
        return periodType;
    }

    public void setPeriodType(String periodType) {
        this.periodType = periodType;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public List<UserEntity> getStudents() {
        return students;
    }

    public void setStudents(List<UserEntity> students) {
        this.students = students;
    }

    
}
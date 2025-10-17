package com.appdev1.expy.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class leaderboardEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int leaderboard_id;
    private String name;
    private String periodType;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @OneToMany(mappedBy="user")
    List<userEntity> users;

    public int getLeaderboardId() {
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

    public List<userEntity> getUsers() {
        return users;
    }

    public void setUsers(List<userEntity> users) {
        this.users = users;
    }

}
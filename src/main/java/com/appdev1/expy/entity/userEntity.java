package com.appdev1.expy.entity;


import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="tblUser")
public class userEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int user_id;
    private String username;
    private String email;
    private String password_hash;
    private String role;
    private String status;
    private int total_xp;
    private int level;
    private int currentStreak;

    @ElementCollection
    private List<Integer> cohortIds;

    @ElementCollection
    private List<String> badgeNames;

    @ManyToOne
    @JoinColumn(name = "leaderboard_id")
    private leaderboardEntity leaderboard;
    //missing connection to Leaderboard Entity

    @OneToMany(mappedBy = "user")
    private List<activityEntity> activities;


    public userEntity() {
        super();
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password) {
        this.password_hash = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotal_xp() {
        return total_xp;
    }

    public void setTotal_xp(int total_xp) {
        this.total_xp = total_xp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCurrentStreak() {
        return currentStreak;
    }

    public void setCurrentStreak(int currentStreak) {
        this.currentStreak = currentStreak;
    }

    public List<Integer> getCohortIds() {
        return cohortIds;
    }

    public void setCohortIds(List<Integer> cohortIds) {
        this.cohortIds = cohortIds;
    }

    public List<String> getBadgeNames() {
        return badgeNames;
    }

    public void setBadgeNames(List<String> badgeNames) {
        this.badgeNames = badgeNames;
    }

    public leaderboardEntity getLeaderboards() {
        return leaderboard;
    }
    public void setLeaderboards(leaderboardEntity leaderboard) {
        this.leaderboard = leaderboard;
    }

}

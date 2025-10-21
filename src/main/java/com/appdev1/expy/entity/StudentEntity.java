package com.appdev1.expy.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblStudent")
public class StudentEntity extends UserEntity {

    private int total_exp;
    private int level;
    private int current_streak;

    @OneToMany(mappedBy = "student")
    private List<ReportEntity> reports;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinTable(
        name = "student_activity",
        joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "activity_id")
    )
    private Set<ActivityEntity> activities = new HashSet<>();
    
    @ManyToMany(mappedBy = "students")
    private Set<CohortEntity> cohorts = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinTable(
        name = "student_leaderboard",
        joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "leaderboard_id")
    )
    private Set<LeaderboardEntity> leaderboards = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinTable(
        name = "student_badge",
        joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "badge_id")
    )
    private Set<BadgeEntity> badges = new HashSet<>();

    public StudentEntity() {
        super();
    }

    public int getTotal_exp() {
        return total_exp;
    }

    public void setTotal_exp(int total_exp) {
        this.total_exp = total_exp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCurrent_streak() {
        return current_streak;
    }

    public void setCurrent_streak(int current_streak) {
        this.current_streak = current_streak;
    }

    public List<ReportEntity> getReports() {
        return reports;
    }

    public void setReports(List<ReportEntity> reports) {
        this.reports = reports;
    }

    public Set<ActivityEntity> getActivities() {
        return activities;
    }

    public void setActivities(Set<ActivityEntity> activities) {
        this.activities = activities;
    }

    public Set<CohortEntity> getCohorts() {
        return cohorts;
    }

    public void setCohorts(Set<CohortEntity> cohorts) {
        this.cohorts = cohorts;
    }

    public Set<LeaderboardEntity> getLeaderboards() {
        return leaderboards;
    }

    public void setLeaderboards(Set<LeaderboardEntity> leaderboards) {
        this.leaderboards = leaderboards;
    }

    public Set<BadgeEntity> getBadges() {
        return badges;
    }

    public void setBadges(Set<BadgeEntity> badges) {
        this.badges = badges;
    }


}

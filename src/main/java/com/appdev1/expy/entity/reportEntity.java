package com.appdev1.expy.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "report_entity")
public class reportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reportId;

    private String type;
    private LocalDateTime generatedDate;
    private String data;

    // Optional many-to-one relationship to AdminEntity
    @ManyToOne(optional = true)
    @JoinColumn(name = "admin_id", referencedColumnName = "admin_id")
    private adminEntity admin;

    // Optional many-to-one relationship to UserEntity
    @ManyToOne(optional = true)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private userEntity user;

    public reportEntity() {}

    public reportEntity(String type, LocalDateTime generatedDate, String data, adminEntity admin, userEntity user) {
        this.type = type;
        this.generatedDate = generatedDate;
        this.data = data;
        this.admin = admin;
        this.user = user;
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getGeneratedDate() {
        return generatedDate;
    }

    public void setGeneratedDate(LocalDateTime generatedDate) {
        this.generatedDate = generatedDate;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public adminEntity getAdmin() {
        return admin;
    }

    public void setAdmin(adminEntity admin) {
        this.admin = admin;
    }

    public userEntity getUser() {
         return user;
    }

    public void setUser(userEntity user) {
        this.user = user;
    }
}

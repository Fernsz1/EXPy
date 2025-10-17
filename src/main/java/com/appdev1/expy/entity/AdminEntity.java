package com.appdev1.expy.entity;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "admin_entity")
public class AdminEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int admin_id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password_hash;

    @Column(nullable = false)
    private String role;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ReportEntity> reports = new ArrayList<>();

    public AdminEntity() {}

    public AdminEntity(String username, String email, String password_hash, String role) {
        this.username = username;
        this.email = email;
        this.password_hash = password_hash;
        this.role = role;
    }

    public int getAdminId() {
        return admin_id; 
    }

    public void setAdminId(int admin_id) {
        this.admin_id = admin_id;
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

    public String getPasswordHash() { 
        return password_hash; 
    }

    public void setPasswordHash(String password_hash) { 
        this.password_hash = password_hash;
    }

    public String getRole() { 
        return role; 
    }

    public void setRole(String role) { 
        this.role = role; 
    }

    public List<ReportEntity> getReports() {
        return reports;
    }

    public void setReports(List<ReportEntity> reports) {
        this.reports = reports;
    }
}

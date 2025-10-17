package com.appdev1.expy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "admin_entity")
public class AdminEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;

    private String username;
    private String email;
    private String passwordHash;
    private String role;

    public AdminEntity() {}

    public AdminEntity(String username, String email, String passwordHash, String role) {
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.role = role;
    }

    public Long getAdminId() {
        return adminId; 
    }

    public void setAdminId(Long adminId) { 
        this.adminId = adminId;
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
        return passwordHash; 
    }

    public void setPasswordHash(String passwordHash) { 
        this.passwordHash = passwordHash;
    }

    public String getRole() { 
        return role; 
    }
    public void setRole(String role) { 
        this.role = role; 
    }
}

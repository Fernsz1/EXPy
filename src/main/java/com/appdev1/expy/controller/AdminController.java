package com.appdev1.expy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appdev1.expy.entity.AdminEntity;
import com.appdev1.expy.service.AdminService;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    @Autowired
    AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    //C
    @PostMapping("/insertAdmin")
    public AdminEntity createAdmin(@RequestBody AdminEntity admin) {
        return adminService.createAdmin(admin);
    }

    //R
    @GetMapping("/getAllAdmins")
    public List<AdminEntity> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminEntity> getAdminById(@PathVariable int id) {
        return adminService.getAdminById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //U
    @PutMapping("/updateAdmin")
    public AdminEntity updateAdmin(@RequestParam int adminid, @RequestBody AdminEntity updatedAdminDetails) {
        return adminService.updateAdmin(adminid, updatedAdminDetails);
    }

    //D
    @DeleteMapping("/deleteAdmin")
    public String deleteAdmin(@PathVariable int adminid) {
        return adminService.deleteAdmin(adminid);
    }
}

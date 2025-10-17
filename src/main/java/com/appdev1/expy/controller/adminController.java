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

import com.appdev1.expy.entity.adminEntity;

@RestController
@RequestMapping("/api/admins")
public class adminController {

    @Autowired
    com.appdev1.expy.service.adminService adminService;

    public adminController(com.appdev1.expy.service.adminService adminService) {
        this.adminService = adminService;
    }

    //C
    @PostMapping("/insertAdmin")
    public adminEntity createAdmin(@RequestBody adminEntity admin) {
        return adminService.createAdmin(admin);
    }

    //R
    @GetMapping("/getAllAdmins")
    public List<adminEntity> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/{id}")
    public ResponseEntity<adminEntity> getAdminById(@PathVariable int id) {
        return adminService.getAdminById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //U
    @PutMapping("/updateAdmin")
    public adminEntity updateAdmin(@RequestParam int adminid, @RequestBody adminEntity updatedAdminDetails) {
        return adminService.updateAdmin(adminid, updatedAdminDetails);
    }

    //D
    @DeleteMapping("/deleteAdmin")
    public String deleteAdmin(@PathVariable int adminid) {
        return adminService.deleteAdmin(adminid);
    }
}

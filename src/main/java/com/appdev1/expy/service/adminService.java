package com.appdev1.expy.service;

import java.util.List;
import java.util.Optional;

import org.openqa.selenium.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev1.expy.entity.adminEntity;

@Service
public class adminService {

    @Autowired
    com.appdev1.expy.repository.adminRepository adminRepository;

    public adminService(com.appdev1.expy.repository.adminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    //C
    public adminEntity createAdmin(adminEntity admin) {
        return adminRepository.save(admin);
    }

    //R
    public List<adminEntity> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Optional<adminEntity> getAdminById(int id) {
        return adminRepository.findById(id);
    }

    //U
    public adminEntity updateAdmin(int adminid, adminEntity updatedAdminDetails) {
        adminEntity admin;
        try {
            admin = adminRepository.findById(adminid)
                    .orElseThrow(() -> new NoSuchElementException("Admin " + adminid + " does not exist"));
            admin.setUsername(updatedAdminDetails.getUsername());
            admin.setPasswordHash(updatedAdminDetails.getPasswordHash());
        } catch (NoSuchElementException ex) {
            throw ex;
        }
        return adminRepository.save(admin);
    }

    //D
    public String deleteAdmin(int adminid) {
        String msg = "";
        if (adminRepository.findById(adminid) != null){
            adminRepository.deleteById(adminid);
            msg = "Admin with id " + adminid + " deleted successfully";
        } else {
            msg = "Admin with id " + adminid + " not found";
            return msg;
        }
        return msg;
    }
}

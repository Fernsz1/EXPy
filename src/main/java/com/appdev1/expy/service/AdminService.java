package com.appdev1.expy.service;

import java.util.List;
import java.util.Optional;

import org.openqa.selenium.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev1.expy.entity.AdminEntity;
import com.appdev1.expy.repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    //C
    public AdminEntity createAdmin(AdminEntity admin) {
        return adminRepository.save(admin);
    }

    //R
    public List<AdminEntity> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Optional<AdminEntity> getAdminById(Long id) {
        return adminRepository.findById(id);
    }

    //U
    public AdminEntity updateAdmin(Long adminid, AdminEntity updatedAdminDetails) {
        AdminEntity admin;
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
    public String deleteAdmin(Long adminid) {
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

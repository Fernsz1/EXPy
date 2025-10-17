package com.appdev1.expy.service;

import java.util.List;
import java.util.Optional;

import org.openqa.selenium.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev1.expy.entity.moduleEntity;

@Service
public class moduleService {

    @Autowired
    com.appdev1.expy.repository.moduleRepository moduleRepository;

    public moduleService(com.appdev1.expy.repository.moduleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    // C
    public moduleEntity createModule(moduleEntity module) {
        return moduleRepository.save(module);
    }

    // R
    public List<moduleEntity> getAllModules() {
        return moduleRepository.findAll();
    }

    public Optional<moduleEntity> getModuleById(int id) {
        return moduleRepository.findById(id);
    }

    // U
    public moduleEntity updateModule(int moduleId, moduleEntity updatedModuleDetails) {
        moduleEntity module;
        try {
            module = moduleRepository.findById(moduleId)
                    .orElseThrow(() -> new NoSuchElementException("Module " + moduleId + " does not exist"));
            module.setModuleCode(updatedModuleDetails.getModuleCode());
            module.setModuleName(updatedModuleDetails.getModuleName());
            module.setModuleDescription(updatedModuleDetails.getModuleDescription());
        } catch (NoSuchElementException ex) {
            throw ex;
        }
        return moduleRepository.save(module);
    }

    // D
    public String deleteModule(int moduleId) {
        String msg = "";
        if (moduleRepository.findById(moduleId).isPresent()) {
            moduleRepository.deleteById(moduleId);
            msg = "Module with id " + moduleId + " deleted successfully";
        } else {
            msg = "Module with id " + moduleId + " not found";
        }
        return msg;
    }
}

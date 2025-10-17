package com.appdev1.expy.service;

import java.util.List;
import java.util.Optional;

import org.openqa.selenium.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev1.expy.entity.ModuleEntity;
import com.appdev1.expy.repository.ModuleRepository;

@Service
public class ModuleService {

    @Autowired
    ModuleRepository moduleRepository;

    public ModuleService(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    // C
    public ModuleEntity createModule(ModuleEntity module) {
        return moduleRepository.save(module);
    }

    // R
    public List<ModuleEntity> getAllModules() {
        return moduleRepository.findAll();
    }

    public Optional<ModuleEntity> getModuleById(int id) {
        return moduleRepository.findById(id);
    }

    // U
    public ModuleEntity updateModule(int moduleId, ModuleEntity updatedModuleDetails) {
        ModuleEntity module;
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

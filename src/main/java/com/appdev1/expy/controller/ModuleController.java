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

import com.appdev1.expy.entity.ModuleEntity;
import com.appdev1.expy.service.ModuleService;

@RestController
@RequestMapping("/api/modules")
public class ModuleController {

    @Autowired
    ModuleService moduleService;

    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    // C
    @PostMapping("/insertModule")
    public ModuleEntity createModule(@RequestBody ModuleEntity module) {
        return moduleService.createModule(module);
    }

    // R
    @GetMapping("/getAllModules")
    public List<ModuleEntity> getAllModules() {
        return moduleService.getAllModules();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModuleEntity> getModuleById(@PathVariable int id) {
        return moduleService.getModuleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // U
    @PutMapping("/updateModule")
    public ModuleEntity updateModule(@RequestParam int moduleId, @RequestBody ModuleEntity updatedModuleDetails) {
        return moduleService.updateModule(moduleId, updatedModuleDetails);
    }

    // D
    @DeleteMapping("/deleteModule/{moduleId}")
    public String deleteModule(@PathVariable int moduleId) {
        return moduleService.deleteModule(moduleId);
    }
}

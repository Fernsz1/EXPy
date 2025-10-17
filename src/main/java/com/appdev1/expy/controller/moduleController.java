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

import com.appdev1.expy.entity.moduleEntity;

@RestController
@RequestMapping("/api/modules")
public class moduleController {

    @Autowired
    com.appdev1.expy.service.moduleService moduleService;

    public moduleController(com.appdev1.expy.service.moduleService moduleService) {
        this.moduleService = moduleService;
    }

    // C
    @PostMapping("/insertModule")
    public moduleEntity createModule(@RequestBody moduleEntity module) {
        return moduleService.createModule(module);
    }

    // R
    @GetMapping("/getAllModules")
    public List<moduleEntity> getAllModules() {
        return moduleService.getAllModules();
    }

    @GetMapping("/{id}")
    public ResponseEntity<moduleEntity> getModuleById(@PathVariable int id) {
        return moduleService.getModuleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // U
    @PutMapping("/updateModule")
    public moduleEntity updateModule(@RequestParam int moduleId, @RequestBody moduleEntity updatedModuleDetails) {
        return moduleService.updateModule(moduleId, updatedModuleDetails);
    }

    // D
    @DeleteMapping("/deleteModule/{moduleId}")
    public String deleteModule(@PathVariable int moduleId) {
        return moduleService.deleteModule(moduleId);
    }
}

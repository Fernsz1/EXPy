package com.appdev1.expy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.appdev1.expy.entity.reportEntity;
import com.appdev1.expy.service.reportService;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class reportController {

    @Autowired
    private reportService reportService;

    // CREATE
    @PostMapping("/create")
    public reportEntity createReport(@RequestBody reportEntity report) {
        return reportService.createReport(report);
    }

    // READ ALL
    @GetMapping("/getAll")
    public List<reportEntity> getAllReports() {
        return reportService.getAllReports();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<reportEntity> getReportById(@PathVariable int id) {
        return reportService.getReportById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public reportEntity updateReport(@PathVariable int id, @RequestBody reportEntity updatedReport) {
        return reportService.updateReport(id, updatedReport);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public String deleteReport(@PathVariable int id) {
        return reportService.deleteReport(id);
    }
}

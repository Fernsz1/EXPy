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
import org.springframework.web.bind.annotation.RestController;

import com.appdev1.expy.entity.ReportEntity;
import com.appdev1.expy.service.reportService;

@RestController
@RequestMapping("/api/reports")
public class reportController {

    @Autowired
    private reportService reportService;

    // CREATE
    @PostMapping("/create")
    public ReportEntity createReport(@RequestBody ReportEntity report) {
        return reportService.createReport(report);
    }

    // READ ALL
    @GetMapping("/getAll")
    public List<ReportEntity> getAllReports() {
        return reportService.getAllReports();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<ReportEntity> getReportById(@PathVariable int id) {
        return reportService.getReportById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public ReportEntity updateReport(@PathVariable int report_id, @RequestBody ReportEntity updatedReport) {
        return reportService.updateReport(report_id, updatedReport);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public String deleteReport(@PathVariable int id) {
        return reportService.deleteReport(id);
    }
}

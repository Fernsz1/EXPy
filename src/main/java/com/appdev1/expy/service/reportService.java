package com.appdev1.expy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.appdev1.expy.entity.reportEntity;
import com.appdev1.expy.repository.reportRepository;

import java.util.List;
import java.util.Optional;

@Service
public class reportService {

    @Autowired
    private reportRepository reportRepository;

    // CREATE
    public reportEntity createReport(reportEntity report) {
        return reportRepository.save(report);
    }

    // READ ALL
    public List<reportEntity> getAllReports() {
        return reportRepository.findAll();
    }

    // READ BY ID
    public Optional<reportEntity> getReportById(int id) {
        return reportRepository.findById(id);
    }

    // UPDATE
    public reportEntity updateReport(int id, reportEntity updatedReport) {
        return reportRepository.findById(id).map(report -> {
            report.setType(updatedReport.getType());
            report.setGeneratedDate(updatedReport.getGeneratedDate());
            report.setData(updatedReport.getData());
            report.setAdmin(updatedReport.getAdmin());
            // report.setUser(updatedReport.getUser());
            return reportRepository.save(report);
        }).orElseThrow(() -> new RuntimeException("Report not found with ID: " + id));
    }

    // DELETE
    public String deleteReport(int id) {
        if (reportRepository.existsById(id)) {
            reportRepository.deleteById(id);
            return "Report deleted successfully!";
        } else {
            return "Report not found!";
        }
    }
}

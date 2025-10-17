package com.appdev1.expy.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.appdev1.expy.entity.cohortEntity;
import com.appdev1.expy.repository.cohortRepository;

@Service
public class cohortService {

    @Autowired
    cohortRepository cohortRepository;

    public cohortService() {
        super();
    }

    //C
    public cohortEntity createCohort(cohortEntity cohort) {
        return cohortRepository.save(cohort);
    }

    //R
    public List<cohortEntity> getAllCohorts() {
        return cohortRepository.findAll();
    }

    //U
    public cohortEntity updateCohort(int cohort_id, cohortEntity cohort) {
        cohortEntity existingCohort = null;
        try {
            existingCohort = cohortRepository.findById(cohort_id).get();
            existingCohort.setName(cohort.getName());
            existingCohort.setDescription(cohort.getDescription());
            existingCohort.setMemberIds(cohort.getMemberIds());
    
            cohortRepository.save(existingCohort);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Error updating cohort: " + e.getMessage());
        }
        
        return existingCohort;
    }
    
    //D
    public String deleteCohort(int cohort_id) {
        String msg = "";
        try {
            if (cohortRepository.findById(cohort_id) != null) {
                cohortRepository.deleteById(cohort_id);
                msg = "Cohort with ID " + cohort_id + " deleted successfully.";
            } else {
                msg = "Cohort with ID " + cohort_id + " not found.";
            }
        } catch (Exception e) {
            msg = "Error deleting cohort: " + e.getMessage();
        } 
        
        return msg;
    }
    
}

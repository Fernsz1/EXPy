package com.appdev1.expy.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev1.expy.entity.CohortEntity;
import com.appdev1.expy.repository.cohortRepository;

@Service
public class cohortService {

    @Autowired
    cohortRepository cohortRepository;

    public cohortService() {
        super();
    }

    //C
    public CohortEntity createCohort(CohortEntity cohort) {
        return cohortRepository.save(cohort);
    }

    //R
    public List<CohortEntity> getAllCohorts() {
        return cohortRepository.findAll();
    }

    //U
    public CohortEntity updateCohort(int cohort_id, CohortEntity cohort) {
        CohortEntity existingCohort = null;
        try {
            existingCohort = cohortRepository.findById(cohort_id).get();
            existingCohort.setName(cohort.getName());
            existingCohort.setDescription(cohort.getDescription());
    
            cohortRepository.save(existingCohort);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Error updating cohort: " + e.getMessage());
        }
        
        return existingCohort;
    }

    public Optional<CohortEntity> getCohortById(int id) {
        return cohortRepository.findById(id);
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

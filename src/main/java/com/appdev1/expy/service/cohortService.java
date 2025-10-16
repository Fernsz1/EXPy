package com.appdev1.expy.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.appdev1.expy.entity.cohortEntity;
import com.appdev1.expy.repository.cohortRepository;

@Service
public class cohortService {

    @Autowired
    cohortRepository cohortRep;

    public cohortService() {
        super();
    }

    public cohortEntity createCohort(cohortEntity cohort) {
        return cohortRep.save(cohort);
    }

    public List<cohortEntity> getAllCohorts() {
        return cohortRep.findAll();
    }
    
}

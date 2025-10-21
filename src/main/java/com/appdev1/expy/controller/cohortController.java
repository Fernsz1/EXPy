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

import com.appdev1.expy.entity.CohortEntity;
import com.appdev1.expy.service.cohortService;

@RestController
@RequestMapping("/api/cohorts")
public class cohortController {

    @Autowired
    private cohortService cohortServ;

    @GetMapping("/hello")
    public String returnString() {
        return "Hello World";
    }

    @PostMapping("/insertCohort")
    public CohortEntity postCohortRecord(@RequestBody CohortEntity cohort) {
        return cohortServ.createCohort(cohort);
    }

    @GetMapping("/getAllCohorts")
    public List<CohortEntity> getAllCohorts() {
        return cohortServ.getAllCohorts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CohortEntity> getCohortById(@PathVariable int id) {
        return cohortServ.getCohortById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
 
    @PutMapping("/updateCohort")
    public CohortEntity updateCohort(@RequestParam int cohort_id, @RequestBody CohortEntity cohort) {
        return cohortServ.updateCohort(cohort_id, cohort);
    }

    @DeleteMapping("/deleteCohort/{cohort_id}")
    public String deleteCohort(@PathVariable int cohort_id) {
        return cohortServ.deleteCohort(cohort_id);
    }
    
}

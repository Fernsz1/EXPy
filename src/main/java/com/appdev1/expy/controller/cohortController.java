package com.appdev1.expy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.appdev1.expy.entity.cohortEntity;
import com.appdev1.expy.service.cohortService;

@RestController
@RequestMapping(method = RequestMethod.GET, path = "/api/cohorts")
public class cohortController {

    @Autowired
    private cohortService cohortServ;

    @GetMapping("/hello")
    public String returnString() {
        return "Hello World";
    }

    @PostMapping("/createCohort")
    public cohortEntity postCohortRecord(@RequestBody cohortEntity cohort) {
        return cohortServ.createCohort(cohort);
    }

    @GetMapping("/getAllCohorts")
    public List<cohortEntity> getAllCohorts() {
        return cohortServ.getAllCohorts();
    }
    
}

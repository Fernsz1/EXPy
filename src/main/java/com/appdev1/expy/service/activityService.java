package com.appdev1.expy.service;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev1.expy.entity.ActivityEntity;
import com.appdev1.expy.repository.activityRepository;

@Service
public class activityService {
    @Autowired
    private activityRepository activityRepository;  

    public ActivityEntity createActivity(ActivityEntity activity) {
         return activityRepository.save(activity);
    }

    public List<ActivityEntity> getAllActivities() {
        return activityRepository.findAll();
    }

    public Optional<ActivityEntity> getActivityById(int id) {
        return activityRepository.findById(id);
    }

    public ActivityEntity updateActivity(int activity_id, ActivityEntity activityDetails) {
        ActivityEntity activity = new ActivityEntity();
        try{
            activity = activityRepository.findById(activity_id).orElseThrow(() -> new NoSuchElementException("Activity not found"));
            activity.setType(activityDetails.getType());
            activity.setTitle(activityDetails.getTitle());
            activity.setInstructions(activityDetails.getInstructions());
            activity.setStarter_code(activityDetails.getStarter_code());
            activity.setHints(activityDetails.getHints());
            activity.setTest_cases(activityDetails.getTest_cases());
            activity.setXp_reward(activityDetails.getXp_reward());
            // activity.setLessons(activityDetails.getLessons());
            // activity.setUsers(activityDetails.getUsers());
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Activity not found with id: " + activity_id); 
        }
            
        return activityRepository.save(activity);
        
    }

    public String deleteActivity(int activity_id) {
        String msg="";

        if(activityRepository.findById(activity_id)!=null){
            activityRepository.deleteById(activity_id); 
            msg="ACTIVITY"+activity_id+" DELETED SUCCESSFULLY";
        }else{
            msg="ACTIVITY"+activity_id+" NOT FOUND";
        }
        return msg;
    }




}

package com.appdev1.expy.service;


import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.appdev1.expy.repository.activityRepository;
import com.appdev1.expy.entity.activityEntity;
import com.appdev1.expy.entity.lessonEntity;

@Service
public class activityService {
    @Autowired
    private activityRepository activityRepository;  

    public activityEntity createActivity(activityEntity activity) {
         return activityRepository.save(activity);
    }

    public List<activityEntity> getAllActivities() {
        return activityRepository.findAll();
    }

    public activityEntity updateActivity(int activity_id, activityEntity activityDetails) {
        activityEntity activity = new activityEntity();
        try{
            activity = activityRepository.findById(activity_id).orElseThrow(() -> new Exception("Activity not found"));
            activity.setType(activityDetails.getType());
            activity.setTitle(activityDetails.getTitle());
            activity.setInstructions(activityDetails.getInstructions());
            activity.setStarter_code(activityDetails.getStarter_code());
            activity.setHints(activityDetails.getHints());
            activity.setTest_cases(activityDetails.getTest_cases());
            activity.setXp_reward(activityDetails.getXp_reward());
            activity.setLessons(activityDetails.getLessons());
            activity.setUsers(activityDetails.getUsers());
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Activity not found with id: " + activity_id); 
        }finally {
            return activityRepository.save(activity);
        }
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

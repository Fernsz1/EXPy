package com.appdev1.expy.controller;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.appdev1.expy.entity.activityEntity;
import com.appdev1.expy.service.activityService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("api/activities")
public class activityController {
    @Autowired
    activityService activityServ;

        @PostMapping("/insertActivity")
        public activityEntity createActivity(@RequestBody activityEntity activity) {
            return activityServ.createActivity(activity);
        }

        @GetMapping("/getAllActivities")
        public List<activityEntity> getAllActivities() {
            return activityServ.getAllActivities();
        }

        @PutMapping("/updateActivity")
        public activityEntity updateActivity(@RequestParam int activity_id, @RequestBody activityEntity activityDetails) {
            return activityServ.updateActivity(activity_id, activityDetails); 
        }
        
        @DeleteMapping("/deleteActivity")
        public String deleteActivity(@PathVariable int activity_id) {
            return activityServ.deleteActivity(activity_id);
        }
}

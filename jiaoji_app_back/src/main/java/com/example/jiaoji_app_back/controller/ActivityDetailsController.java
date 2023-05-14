/*author: qyl*/
package com.example.jiaoji_app_back.controller;

import com.example.jiaoji_app_back.entity.ActivityDetails;
import com.example.jiaoji_app_back.model.Message;
import com.example.jiaoji_app_back.repository.ActivityDetailsRepository;
import com.example.jiaoji_app_back.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
public class ActivityDetailsController {
    @Autowired
    private ActivityService activityService;
    private final ActivityDetailsRepository activityDetailsRepository;

    public ActivityDetailsController(ActivityDetailsRepository activityDetailsRepository) {
        this.activityDetailsRepository = activityDetailsRepository;
    }




//    @GetMapping("/activityDetails5")
//    public Map<String, Object> getList1(){
//        List<ActivityDetails> activityList = activityDetailsRepository.findPassedActivity();
//        Map<String, Object> map = new HashMap<>();
//        map.put("Activities",activityList);
//        return map;
//    }
    @GetMapping("/activityDetails")
    public Message getList(){
        return activityService.getActivityList();
    }
    @GetMapping("/getPassedActivities")
    public Message getPassedList2(){
        return activityService.getPassedActivity();
    }
    @PostMapping("/changeStatus")
    public Message changeStatus(@RequestBody Map<String,Object> body){
        Long id = Long.valueOf(body.get("id").toString());
        String status = (String) body.get("status");
        String comments = (String) body.get("comments");
        return activityService.changeStatus(id, status,comments);
    }
    @PostMapping("/handleSignup")
    public Message handleSignup(@RequestBody Map<String,Object> body){
        Long userId = Long.valueOf(body.get("userId").toString());
        Long activityId = Long.valueOf(body.get("activityId").toString());
//        String status = (String) body.get("status");
//        String comments = (String) body.get("comments");
        return activityService.handleSignup(userId,activityId);
    }

}

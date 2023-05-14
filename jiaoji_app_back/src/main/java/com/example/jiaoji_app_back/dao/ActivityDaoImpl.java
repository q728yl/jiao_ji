package com.example.jiaoji_app_back.dao;

import com.example.jiaoji_app_back.entity.ActivityDetails;
import com.example.jiaoji_app_back.repository.ActivityDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActivityDaoImpl implements ActivityDao {
    @Autowired
    private ActivityDetailsRepository activityDetailsRepository;
    @Override
    public List<ActivityDetails> getAllActivities() {
        return activityDetailsRepository.findAllActivity();
    }
    @Override
    public  List<ActivityDetails> getPassedActivity(){
        return activityDetailsRepository.findPassedActivity();
    }
    @Override
    public  ActivityDetails changeStatus(Long id, String status, String comments){
        return activityDetailsRepository.changeStatus(id,status,comments);
    }
    @Override
    public  ActivityDetails handleSignup(Long userId, Long activityId){
        return activityDetailsRepository.handleSignup(userId,activityId);
    }

}

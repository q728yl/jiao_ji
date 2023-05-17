package com.example.jiaoji_app_back.dao;
import com.example.jiaoji_app_back.entity.ActivityDetails;
import com.example.jiaoji_app_back.entity.ActivityResponse;

import java.util.List;

public interface ActivityDao {

        public List<ActivityDetails> getAllActivities();

        public List<ActivityResponse> getMyActivities(int userId) ;

        public  List<ActivityDetails> getPassedActivity();

        public  ActivityDetails changeStatus(Long id, String status, String comments);

        public  void updateActivityRemainingNumber(Long activityId,Long remainingNumber);

        public ActivityDetails getActivityById(Long activityId);

        public void release(String name, String content, String location, String signupTime, String activityTime, String departments, String signupRestriction, String college, String grade, String club, Long recruitmentNumber, Long remainingNumber, String organizer, Long suScore, Long laborHour, String status, String comments);

        public void addReleaseRecord(Long userId, Long num);

        public Long getActivityCount();
}
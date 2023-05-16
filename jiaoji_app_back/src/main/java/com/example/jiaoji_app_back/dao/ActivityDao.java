package com.example.jiaoji_app_back.dao;

import com.example.jiaoji_app_back.entity.ActivityDetails;

import java.util.List;

public interface ActivityDao {
        List<ActivityDetails> getAllActivities();

        List<ActivityDetails> getPassedActivity();

        ActivityDetails changeStatus(Long id, String status, String comments);

        ActivityDetails handleSignup(Long userId, Long activityId);

        ActivityDetails getPassedActivityByAId(Long activityId);

        void updateActivityRemainingNumber(Long activityId,Long remainingNumber);
}

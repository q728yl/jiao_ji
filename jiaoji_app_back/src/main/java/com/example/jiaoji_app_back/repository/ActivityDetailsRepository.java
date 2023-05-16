package com.example.jiaoji_app_back.repository;

import com.example.jiaoji_app_back.entity.ActivityDetails;

import java.util.List;

public interface ActivityDetailsRepository {

    List<ActivityDetails> findAllActivity();
    List<ActivityDetails> findPassedActivity();

    ActivityDetails changeStatus(Long id, String status, String comments);

    ActivityDetails handleSignup(Long userId, Long activityId);

    ActivityDetails getPassedActivityById(Long activityId);

   void updateActivityRemainingNumber(Long activityId,Long remainingNumber);
}

package com.example.jiaoji_app_back.repository;

import com.example.jiaoji_app_back.entity.ActivityDetails;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
public interface ActivityDetailsRepository extends JpaRepository<ActivityDetails,Integer> {
    ActivityDetails findById(Long activityId);
    List<ActivityDetails> findAll();

    List<ActivityDetails> findAllByStatusGreaterThanAndStatusLessThan(String startStatus, String endStatus);
    List<ActivityDetails> findByStatus(String Status);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO activity_details (name, content, location, signupTime, activityTime, departments, signupRestriction, college, grade, club, recruitmentNumber, remainingNumber, organizer, suScore, laborHour, status, comments) " +
            "VALUES ( :name, :content, :location, :signupTime, :activityTime, :departments, :signupRestriction, :college, :grade, :club, :recruitmentNumber, :remainingNumber, :organizer, :suScore, :laborHour, :status, :comments)",
            nativeQuery = true)
    void insertRecord( @Param("name") String name, @Param("content") String content,
                      @Param("location") String location, @Param("signupTime") String signupTime,
                      @Param("activityTime") String activityTime, @Param("departments") String departments,
                      @Param("signupRestriction") String signupRestriction, @Param("college") String college,
                      @Param("grade") String grade, @Param("club") String club,
                      @Param("recruitmentNumber") Long recruitmentNumber, @Param("remainingNumber") Long remainingNumber,
                      @Param("organizer") String organizer, @Param("suScore") Long suScore,
                      @Param("laborHour") Long laborHour, @Param("status") String status,
                      @Param("comments") String comments);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO activity_release (user_id,act_id) " +
            "VALUES ( :user_id, :act_id)",
            nativeQuery = true)
    void addReleaseRecord(@Param("user_id")Long userId,@Param("act_id") Long num);

  
    @Transactional
    @Query(value = "SELECT COUNT(*) FROM activity_details", nativeQuery = true)
    Long getActivityCount();
}

//    List<ActivityDetails> insertRecord(Long userId, String name, String content, String location, String signupTime, String activityTime, String departments, String signupRestriction, String college, String grade, String club, Long recruitmentNumber, Long remainingNumber, String organizer, Long suScore, Long laborHour, String status, String comments);

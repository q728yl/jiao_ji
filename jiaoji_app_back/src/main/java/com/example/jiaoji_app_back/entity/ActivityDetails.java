/*author: qyl*/
package com.example.jiaoji_app_back.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

@Table(name ="activity_details")
public class ActivityDetails {
    @Id
    private Long id;
    private String name;
    private String content;
    private String location;
    private String signupTime;
    private String activityTime;
    private String departments;
    private String signupRestriction;
    private String college;
    private String grade;
    private String club;
    private Long recruitmentNumber;
    private Long remainingNumber;
    private String organizer;
    private Long suScore;
    private Long laborHour;
    private String status;
    private String comments;

    public ActivityDetails(Long id, String name, String content, String location, String signupTime, String activityTime, String departments, String signupRestriction, String college, String grade, String club, Long recruitmentNumber, Long remainingNumber,String organizer, Long suScore, Long laborHour, String status, String comments) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.location = location;
        this.signupTime = signupTime;
        this.activityTime = activityTime;
        this.departments = departments;
        this.signupRestriction = signupRestriction;
        this.college = college;
        this.grade = grade;
        this.club = club;
        this.recruitmentNumber = recruitmentNumber;
        this.remainingNumber = remainingNumber;
        this.organizer = organizer;
        this.suScore = suScore;
        this.laborHour = laborHour;
        this.status = status;
        this.comments = comments;
    }


}

/*author: qyl*/
package com.example.jiaoji_app_back.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor

@Table(name ="activity_details")
public class ActivityDetails {


    @Id
    private Long id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "content")
    private String content;
    @Basic
    @Column(name = "location")
    private String location;
    @Basic
    @Column(name = "signupTime")

    private String signupTime;
    @Basic
    @Column(name = "activityTime")
    private String activityTime;
    @Basic
    @Column(name = "departments")
    private String departments;
    @Basic
    @Column(name = "signupRestriction")
    private String signupRestriction;
    @Basic
    @Column(name = "college")
    private String college;
    @Basic
    @Column(name = "grade")
    private String grade;
    @Basic
    @Column(name = "club")
    private String club;
    @Basic
    @Column(name = "recruitmentNumber")
    private Long recruitmentNumber;
    @Basic
    @Column(name = "remainingNumber")
    private Long remainingNumber;
    @Basic
    @Column(name = "organizer")
    private String organizer;
    @Basic
    @Column(name = "suScore")
    private Long suScore;
    @Basic
    @Column(name = "laborHour")
    private Long laborHour;
    @Basic
//
//    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private String status;
//    public void setStatus(Status status){
//        this.status = status;
//    }
    @Basic
    @Column(name = "comments")

    private String comments;
//    private String photo;

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
//        this.photo = photo;
    }


}
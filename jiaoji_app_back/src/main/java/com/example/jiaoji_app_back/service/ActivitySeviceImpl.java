package com.example.jiaoji_app_back.service;

import com.example.jiaoji_app_back.dao.ActivityDao;
import com.example.jiaoji_app_back.entity.ActivityDetails;
import com.example.jiaoji_app_back.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivitySeviceImpl implements ActivityService {

        @Autowired
        private ActivityDao activityDao;
        @Override
        public Message getActivityList() {
            List<ActivityDetails> activityDetailsList= activityDao.getAllActivities();
            if(activityDetailsList!= null){
                return new Message("获取活动列表成功",true,activityDetailsList);
            }else{
                return new Message("获取活动列表失败",false,null);
            }
        }
        @Override
        public Message getPassedActivity(){
            List<ActivityDetails> activityDetailsList= activityDao.getPassedActivity();
            if(activityDetailsList!= null){
                return new Message("获取活动列表成功",true,activityDetailsList);
            }else{
                return new Message("获取活动列表失败",false,null);
            }
        }
        @Override
        public Message changeStatus(Long id, String status, String comments){
            ActivityDetails activityDetailsList= activityDao.changeStatus(id,status,comments);
            if(activityDetailsList!= null){
                return new Message("改变活动状态成功",true,activityDetailsList);
            }else{
                return new Message("改变活动状态失败",false,null);
            }
        }
        @Override
        public Message handleSignup(Long userId, Long activityId){
            ActivityDetails activityDetailsList= activityDao.handleSignup(userId,activityId);
            if(activityDetailsList!= null){
                return new Message("报名成功",true,activityDetailsList);
            }else{
                return new Message("报名失败",false,null);
            }
        }
    }


package com.example.jiaoji_app_back.dao;


import com.example.jiaoji_app_back.entity.User;
import com.example.jiaoji_app_back.entity.UserAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

public interface UserDao {

    UserAuth checkUser(String username, String password);

    User findByUserId(int userId);
}
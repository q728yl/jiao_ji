package com.example.jiaoji_app_back.daoimpl;

import com.example.jiaoji_app_back.dao.UserDao;
import com.example.jiaoji_app_back.entity.User;
import com.example.jiaoji_app_back.entity.UserAuth;
import com.example.jiaoji_app_back.repository.UserAuthRepository;
import com.example.jiaoji_app_back.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;




@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    UserAuthRepository userAuthRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public UserAuth checkUser(String username, String password){

        return userAuthRepository.checkUser(username,password);
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User findByUserId(int userId) {
        return entityManager.find(User.class, userId);
    }


}

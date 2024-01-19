package com.example.tweetwave.domain.api;

import com.example.tweetwave.domain.user.User;
import com.example.tweetwave.domain.user.UserDao;

import java.time.LocalDateTime;

public class UserService {
    private UserDao userDao = new UserDao();

    public void userRegistration(UserRegistrationDto userRegistrationDto){
        User user = UserMapper.map(userRegistrationDto);
        userDao.saveUser(user);
    }


}

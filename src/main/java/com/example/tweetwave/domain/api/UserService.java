package com.example.tweetwave.domain.api;

import com.example.tweetwave.domain.user.User;
import com.example.tweetwave.domain.user.UserDao;
import org.apache.commons.codec.digest.DigestUtils;

import java.time.LocalDateTime;

public class UserService {
    private UserDao userDao = new UserDao();

    public void userRegistration(UserRegistrationDto userRegistrationDto){
        User user = UserMapper.map(userRegistrationDto);
        hashPassWithSha256(user);
        userDao.save(user);
    }

    private void hashPassWithSha256(User user) {
        String sha256Pass = DigestUtils.sha256Hex(user.getPassword());
        user.setPassword(sha256Pass);
    }

    private static class UserMapper {
        static User map(UserRegistrationDto userRegistrationDto){
            return new User(
                    userRegistrationDto.getUsername(),
                    userRegistrationDto.getEmail(),
                    userRegistrationDto.getPassword(),
                    LocalDateTime.now()
            );
        }
    }

}

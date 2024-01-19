package com.example.tweetwave.domain.api;

import java.time.LocalDateTime;

public class UserRegistrationDto {
    private String username;
    private String email;
    private String password;

    public UserRegistrationDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

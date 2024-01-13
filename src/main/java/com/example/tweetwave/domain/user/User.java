package com.example.tweetwave.domain.user;

import java.time.LocalDateTime;

public class User {
    private Integer id;
    private String userName;
    private String email;
    private String password;
    private LocalDateTime registrationDate;

    public User(String userName, String email, String password, LocalDateTime registrationDate) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.registrationDate = registrationDate;
    }

    public User(Integer id, String userName, String email, String password, LocalDateTime registrationDate) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.registrationDate = registrationDate;
    }

    public Integer getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }
}

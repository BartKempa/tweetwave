package com.example.tweetwave.domain.tweet;

import java.text.DateFormat;
import java.time.LocalDateTime;

public class Tweet {
    private Integer id;
    private Integer userId;
    private String description;
    private LocalDateTime dateAdded;
    private String url;

    public Tweet(Integer id, Integer userId, String description, LocalDateTime dateAdded, String url) {
        this.id = id;
        this.userId = userId;
        this.description = description;
        this.dateAdded = dateAdded;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public String getUrl() {
        return url;
    }
}

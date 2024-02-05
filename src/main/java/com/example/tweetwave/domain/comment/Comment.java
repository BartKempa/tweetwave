package com.example.tweetwave.domain.comment;

import java.time.LocalDateTime;

public class Comment {
    private Integer id;
    private Integer userId;
    private Integer tweetId;
    private LocalDateTime dateAdded;
    private String description;

    public Comment(Integer userId, Integer tweetId, LocalDateTime dateAdded, String description) {
        this.userId = userId;
        this.tweetId = tweetId;
        this.dateAdded = dateAdded;
        this.description = description;
    }

    public Comment(Integer id, Integer userId, Integer tweetId, LocalDateTime dateAdded, String description) {
        this.id = id;
        this.userId = userId;
        this.tweetId = tweetId;
        this.dateAdded = dateAdded;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getTweetId() {
        return tweetId;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

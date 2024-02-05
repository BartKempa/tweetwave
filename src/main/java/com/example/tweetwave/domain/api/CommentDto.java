package com.example.tweetwave.domain.api;

import java.time.LocalDateTime;

public class CommentDto {
    private String userName;
    private Integer tweetId;
    private String description;

    public CommentDto(String userName, Integer tweetId, String description) {
        this.userName = userName;
        this.tweetId = tweetId;
        this.description = description;
    }

    public String getUserName() {
        return userName;
    }

    public Integer getTweetId() {
        return tweetId;
    }

    public String getDescription() {
        return description;
    }
}

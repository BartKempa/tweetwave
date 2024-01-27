package com.example.tweetwave.domain.rate;

import java.time.LocalDateTime;

public class Rate {
    private Integer userId;
    private Integer tweetId;
    private Type type;
    private LocalDateTime dateAdded;

    public Rate(Integer userId, Integer tweetId, Type type, LocalDateTime dateAdded) {
        this.userId = userId;
        this.tweetId = tweetId;
        this.type = type;
        this.dateAdded = dateAdded;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getTweetId() {
        return tweetId;
    }

    public Type getType() {
        return type;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public enum Type{
        LIKE, DISLIKE
    }
}

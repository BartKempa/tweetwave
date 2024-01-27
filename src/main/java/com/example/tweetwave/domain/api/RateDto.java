package com.example.tweetwave.domain.api;

public class RateDto {
    private String userName;
    private Integer tweetId;
    private String type;

    public RateDto(String userName, Integer tweetId, String type) {
        this.userName = userName;
        this.tweetId = tweetId;
        this.type = type;
    }

    public String getUserName() {
        return userName;
    }

    public Integer getTweetId() {
        return tweetId;
    }

    public String getType() {
        return type;
    }
}

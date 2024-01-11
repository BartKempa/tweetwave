package com.example.tweetwave.domain.api;

import java.time.LocalDateTime;

public class TweetDto {
    private String description;
    private LocalDateTime dateAdded;
    private String url;

    public TweetDto(String description, LocalDateTime dateAdded, String url) {
        this.description = description;
        this.dateAdded = dateAdded;
        this.url = url;
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

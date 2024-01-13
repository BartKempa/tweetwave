package com.example.tweetwave.domain.api;

import java.time.LocalDateTime;

public class TweetDto {
    private String description;
    private LocalDateTime dateAdded;
    private String url;
    private String tweetAuthor;

    public TweetDto(String description, LocalDateTime dateAdded, String url, String tweetAuthor) {
        this.description = description;
        this.dateAdded = dateAdded;
        this.url = url;
        this.tweetAuthor = tweetAuthor;
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

    public String getTweetAuthor() {
        return tweetAuthor;
    }
}

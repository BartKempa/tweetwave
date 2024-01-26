package com.example.tweetwave.domain.api;

import jakarta.servlet.http.Part;

import java.time.LocalDateTime;

public class TweetDto {
    private Integer id;
    private String description;
    private LocalDateTime dateAdded;
    private String url;
    private String tweetAuthor;
    private byte[] filePart;

    public TweetDto(Integer id, String description, LocalDateTime dateAdded, String url, String tweetAuthor, byte[] filePart) {
        this.id = id;
        this.description = description;
        this.dateAdded = dateAdded;
        this.url = url;
        this.tweetAuthor = tweetAuthor;
        this.filePart = filePart;
    }

    public TweetDto(String description, LocalDateTime dateAdded, String url, String tweetAuthor, byte[] filePart) {
        this.description = description;
        this.dateAdded = dateAdded;
        this.url = url;
        this.tweetAuthor = tweetAuthor;
        this.filePart = filePart;
    }

    public Integer getId() {
        return id;
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

    public byte[] getFilePart() {
        return filePart;
    }
}

package com.example.tweetwave.domain.api;

import java.time.LocalDateTime;

public class CommentDto {
    private String commentAuthor;
    private Integer tweetId;
    private LocalDateTime dateAdded;
    private String description;

    public CommentDto(String commentAuthor, Integer tweetId, LocalDateTime dateAdded, String description) {
        this.commentAuthor = commentAuthor;
        this.tweetId = tweetId;
        this.dateAdded = dateAdded;
        this.description = description;
    }

    public String getCommentAuthor() {
        return commentAuthor;
    }

    public Integer getTweetId() {
        return tweetId;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }
}

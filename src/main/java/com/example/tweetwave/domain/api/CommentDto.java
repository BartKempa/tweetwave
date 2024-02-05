package com.example.tweetwave.domain.api;

import java.time.LocalDateTime;

public class CommentDto {
    private String commentAuthor;
    private Integer tweetId;
    private String description;

    public CommentDto(String commentAuthor, Integer tweetId, String description) {
        this.commentAuthor = commentAuthor;
        this.tweetId = tweetId;
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
}

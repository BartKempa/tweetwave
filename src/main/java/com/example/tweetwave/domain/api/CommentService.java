package com.example.tweetwave.domain.api;

import com.example.tweetwave.domain.comment.Comment;
import com.example.tweetwave.domain.comment.CommentDao;
import com.example.tweetwave.domain.tweet.TweetDao;
import com.example.tweetwave.domain.user.UserDao;

import java.time.LocalDateTime;

public class CommentService {
    private CommentDao commentDao = new CommentDao();
    private CommentMapper commentMapper = new CommentMapper();

    public void add(CommentDto commentDto){
        Comment commentToSave = commentMapper.map(commentDto);
        commentDao.save(commentToSave);
    }
    private static class CommentMapper{
        private final UserDao userDao = new UserDao();
        Comment map(CommentDto commentDto){
            return  new Comment(
                    userDao.findByUserName(commentDto.getCommentAuthor())
                            .orElseThrow()
                            .getId(),
                    commentDto.getTweetId(),
                    LocalDateTime.now(),
                    commentDto.getDescription()
            );
        }
    }



}

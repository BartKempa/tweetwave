package com.example.tweetwave.domain.api;

import com.example.tweetwave.domain.comment.Comment;
import com.example.tweetwave.domain.comment.CommentDao;
import com.example.tweetwave.domain.tweet.TweetDao;
import com.example.tweetwave.domain.user.UserDao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class CommentService {
    private CommentDao commentDao = new CommentDao();
    private CommentMapper commentMapper = new CommentMapper();

    public void add(CommentDto commentDto){
        Comment commentToSave = commentMapper.map(commentDto);
        commentDao.save(commentToSave);
    }

    public List<CommentDto> findAll(){
        return commentDao.findAllComments()
                .stream()
                .map(commentMapper::map)
                .collect(Collectors.toList());
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

        CommentDto map(Comment comment){
            return new CommentDto(
                    userDao.findById(comment.getUserId()).orElseThrow().getUsername(),
                    comment.getTweetId(),
                    comment.getDateAdded(),
                    comment.getDescription()
            );
        }
    }



}

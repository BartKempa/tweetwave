package com.example.tweetwave.domain.api;

import com.example.tweetwave.domain.tweet.Tweet;
import com.example.tweetwave.domain.tweet.TweetDao;
import com.example.tweetwave.domain.user.UserDao;

import java.util.List;
import java.util.stream.Collectors;

public class TweetService {
    private final TweetDao tweetDao = new TweetDao();
    private TweetMapper tweetMapper = new TweetMapper();


    public List<TweetDto> findAll(){
        return tweetDao.findAll()
                .stream()
                .map(tweetMapper::map)
                .collect(Collectors.toList());
    }


    private static class TweetMapper {
        private final UserDao userDao = new UserDao();
        TweetDto map(Tweet tweet) {
            return new TweetDto(
                    tweet.getDescription(),
                    tweet.getDateAdded(),
                    tweet.getUrl(),
                    userDao.findById(tweet.getUserId()).orElseThrow().getUserName());
        }
    }
}

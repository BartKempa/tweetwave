package com.example.tweetwave.domain.api;

import com.example.tweetwave.domain.tweet.Tweet;
import com.example.tweetwave.domain.tweet.TweetDao;

import java.util.List;
import java.util.stream.Collectors;

public class TweetService {
    private final TweetDao tweetDao = new TweetDao();

    public List<TweetDto> findAll(){
        return tweetDao.findAll()
                .stream()
                .map(TweetMapper::map)
                .collect(Collectors.toList());
    }


    private static class TweetMapper {
        static TweetDto map(Tweet tweet) {
            return new TweetDto(tweet.getDescription(), tweet.getDateAdded(), tweet.getUrl());
        }
    }
}

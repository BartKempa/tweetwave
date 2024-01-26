package com.example.tweetwave.domain.api;

import com.example.tweetwave.domain.tweet.Tweet;
import com.example.tweetwave.domain.tweet.TweetDao;
import com.example.tweetwave.domain.user.UserDao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TweetService {
    private final TweetDao tweetDao = new TweetDao();
    private TweetMapper tweetMapper = new TweetMapper();


    public byte[] getPhotoById(String photoId){
        return tweetDao.findTweetById(Integer.parseInt(photoId))
                .orElseThrow()
                .getFilePart();
    }

    public List<TweetDto> findAll(){
        return tweetDao.findAll()
                .stream()
                .map(tweetMapper::map)
                .collect(Collectors.toList());
    }

    public void add(TweetDto tweetDto){
        Tweet tweetToSave = tweetMapper.map(tweetDto);
        tweetDao.save(tweetToSave);
    }

    private static class TweetMapper {
        private final UserDao userDao = new UserDao();
        TweetDto map(Tweet tweet) {
            return new TweetDto(
                    tweet.getId(),
                    tweet.getDescription(),
                    tweet.getDateAdded(),
                    tweet.getUrl(),
                    userDao.findById(tweet.getUserId()).orElseThrow().getUsername(),
                    tweet.getFilePart());
        }

        Tweet map(TweetDto tweetDto) {
            return new Tweet(
                    userDao.findByUserName(tweetDto.getTweetAuthor())
                            .orElseThrow()
                            .getId(),
                    tweetDto.getDescription(),
                    LocalDateTime.now(),
                    tweetDto.getUrl(),
                    tweetDto.getFilePart()
            );
        }
    }
}

package com.example.tweetwave.domain.api;

import com.example.tweetwave.domain.rate.Rate;
import com.example.tweetwave.domain.rate.RateDao;
import com.example.tweetwave.domain.user.UserDao;

import java.time.LocalDateTime;

public class RateService {
    private RateDao rateDao = new RateDao();
    private RateMapper rateMapper = new RateMapper();

    public void addRate(RateDto rateDto){
        Rate rateToSave = rateMapper.map(rateDto);
        rateDao.save(rateToSave);
    }

    private static class RateMapper{
        private final UserDao userDao = new UserDao();

        Rate map(RateDto rateDto){
            return new Rate(
                    userDao.findByUserName(rateDto.getUserName()).orElseThrow().getId(),
                    rateDto.getTweetId(),
                    Rate.Type.valueOf(rateDto.getType()),
                    LocalDateTime.now()
            );

        }
    }
}

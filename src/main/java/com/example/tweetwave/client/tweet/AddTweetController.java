package com.example.tweetwave.client.tweet;

import com.example.tweetwave.domain.api.TweetDto;
import com.example.tweetwave.domain.api.TweetService;
import com.example.tweetwave.domain.tweet.Tweet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;

@WebServlet("/tweet/add")
@MultipartConfig(maxFileSize = 16177215)
public class AddTweetController extends HttpServlet {
    private TweetService tweetService = new TweetService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/add-tweet.jsp").forward(req, resp);
    }


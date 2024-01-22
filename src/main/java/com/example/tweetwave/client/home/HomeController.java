package com.example.tweetwave.client.home;

import com.example.tweetwave.domain.api.TweetDto;
import com.example.tweetwave.domain.api.TweetService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet("")
public class HomeController extends HttpServlet {
    private TweetService tweetService = new TweetService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TweetDto> tweets = tweetService.findAll();
        req.setAttribute("tweets", tweets);
        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
    }
}

package com.example.tweetwave.client.tweet;

import com.example.tweetwave.domain.api.CommentDto;
import com.example.tweetwave.domain.api.CommentService;
import com.example.tweetwave.domain.api.TweetDto;
import com.example.tweetwave.domain.api.TweetService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpMethodConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/tweet")
@ServletSecurity(
        httpMethodConstraints = {
                @HttpMethodConstraint(value = "GET", rolesAllowed = "USER")
        }
)
public class SingleTweetController extends HttpServlet {
    private TweetService tweetService = new TweetService();
    private CommentService commentService = new CommentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int tweetId = Integer.parseInt(req.getParameter("id"));
        TweetDto tweet = tweetService.findSingleTweet(tweetId)
                .orElseThrow();
        List<CommentDto> comments = commentService.findAll(tweetId);
        req.setAttribute("comments", comments);
        req.setAttribute("tweet", tweet);
        req.getRequestDispatcher("/WEB-INF/views/tweet.jsp").forward(req, resp);
    }
}

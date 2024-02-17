package com.example.tweetwave.client.user;

import com.example.tweetwave.domain.api.TweetDto;
import com.example.tweetwave.domain.api.TweetService;
import com.example.tweetwave.domain.api.UserService;
import com.example.tweetwave.domain.user.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpMethodConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/user")
@ServletSecurity(
        httpMethodConstraints = {
                @HttpMethodConstraint(value = "POST", rolesAllowed = "USER")
        }
)
public class UserController extends HttpServlet {
    TweetService tweetService = new TweetService();
    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getUserPrincipal().getName();



        List<TweetDto> allUserTweets = tweetService.findAllUserTweets(Integer.parseInt(req.getParameter("user_id")));
        req.setAttribute("allUserTweets", allUserTweets);
        req.getRequestDispatcher("/WEB-INF/views/user.jsp").forward(req, resp);
    }
}

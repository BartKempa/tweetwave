package com.example.tweetwave.client.signup;

import com.example.tweetwave.domain.api.UserRegistrationDto;
import com.example.tweetwave.domain.api.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/signup")
public class SignupController extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserRegistrationDto userRegistrationDto = getUserInfo(req);
        userService.userRegistration(userRegistrationDto);
        resp.sendRedirect(req.getContextPath());
    }

    private UserRegistrationDto getUserInfo(HttpServletRequest req) {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        return new UserRegistrationDto(username, email, password);
    }


}

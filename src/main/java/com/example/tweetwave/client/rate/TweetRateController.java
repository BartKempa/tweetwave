package com.example.tweetwave.client.rate;

import com.example.tweetwave.domain.api.RateDto;
import com.example.tweetwave.domain.api.RateService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpMethodConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/tweet/rate")
@ServletSecurity(
        httpMethodConstraints = {
                @HttpMethodConstraint(value = "GET", rolesAllowed = "USER")
        }
)
public class TweetRateController extends HttpServlet {
    private RateService rateService = new RateService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RateDto rateDto = createTweetRate(req);
        rateService.addRate(rateDto);
        resp.sendRedirect(req.getContextPath() + "/");
    }

    private RateDto createTweetRate(HttpServletRequest req) {
        return new RateDto(
                req.getUserPrincipal().getName(),
                Integer.parseInt(req.getParameter("tweetId")),
                req.getParameter("type")
        );
    }

}

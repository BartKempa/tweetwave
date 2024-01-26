package com.example.tweetwave.client.photo;

import com.example.tweetwave.domain.api.TweetService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/photo/*")
public class PhotoController extends HttpServlet {
    private TweetService tweetService = new TweetService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String photoId = req.getPathInfo().substring(1);
        byte[] photoData = tweetService.getPhotoById(photoId);
        if (photoData != null) {
            resp.setContentType("image/jpeg");
            resp.setContentLength(photoData.length);
            resp.getOutputStream().write(photoData);
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}

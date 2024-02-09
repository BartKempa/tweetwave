package com.example.tweetwave.client.comment;

import com.example.tweetwave.domain.api.CommentDto;
import com.example.tweetwave.domain.api.CommentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpMethodConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/comment/add")
@ServletSecurity(
        httpMethodConstraints = {
                @HttpMethodConstraint(value = "POST", rolesAllowed = "USER")
        }
)
public class AddCommentController extends HttpServlet {
        CommentService commentService = new CommentService();

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                CommentDto commentDto = createCommentDto(req);
                commentService.add(commentDto);
                resp.sendRedirect(req.getContextPath() + "/");
        }

        private CommentDto createCommentDto(HttpServletRequest req) {
                String commentAuthor = req.getUserPrincipal().getName();
                Integer tweetId = Integer.valueOf(req.getParameter("id"));
                LocalDateTime dateAdded = LocalDateTime.now();
                String description = req.getParameter("description");
                return new CommentDto(commentAuthor, tweetId, dateAdded, description);
        }


}

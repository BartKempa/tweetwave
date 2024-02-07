package com.example.tweetwave.domain.comment;

import com.example.tweetwave.configuration.DataSourceProvider;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CommentDao {
    private DataSource dataSource;

    public CommentDao() {
        try {
            dataSource = DataSourceProvider.getDataSource();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(Comment comment){
        final String query = """
                INSERT INTO 
                    comment (user_id, tweet_id, date_added, description)
                VALUES 
                    (?, ?, ?, ?)
                """;
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
           statement.setInt(1, comment.getUserId());
           statement.setInt(1, comment.getTweetId());
           statement.setObject(3, comment.getDateAdded());
           statement.setString(4, comment.getDescription());
           statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next())
                comment.setId(generatedKeys.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Comment> findAllComments(int tweet_id){
        final String query ="""
                SELECT 
                    id, user_id, tweet_id, date_added, description
                FROM 
                    comment
                WHERE
                    tweet_id = ?
                """;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, tweet_id);
            ResultSet resultSet = statement.executeQuery();
            List<Comment> allComments = new ArrayList<>();
            while (resultSet.next())
                allComments.add(mapRow(resultSet));
            return allComments;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int countCommentsByTweetId(int tweetId){
        final String query ="""
                SELECT COUNT(tweet_id)
                FROM
                    comment
                WHERE
                    tweet_id = ?
                """;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, tweetId);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private Comment mapRow(ResultSet resultSet) throws SQLException {
        return new Comment(
                resultSet.getInt("id"),
                resultSet.getInt("user_id"),
                resultSet.getInt("tweet_id"),
                (LocalDateTime) resultSet.getObject("date_added"),
                resultSet.getString("description")
        );
    }
}

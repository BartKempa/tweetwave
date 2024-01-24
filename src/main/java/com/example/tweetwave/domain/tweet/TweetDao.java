package com.example.tweetwave.domain.tweet;

import com.example.tweetwave.configuration.DataSourceProvider;
import jakarta.servlet.http.Part;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TweetDao {
    private final DataSource dataSource;
    private InputStream inputStream = null;

    public TweetDao() {
        try {
            this.dataSource = DataSourceProvider.getDataSource();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Tweet> findAll(){
        final String query = """
                SELECT 
                    id, user_id, description, date_added, url, photo
                FROM 
                    tweet
                """;
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(query);
            List<Tweet> allTweets = new ArrayList<>();
            while (resultSet.next()){
               Tweet tweet = mapRow(resultSet);
               allTweets.add(tweet);
            }
            return allTweets;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    private Tweet mapRow(ResultSet resultSet) throws SQLException {

        int tweetId = resultSet.getInt("id");
        int userId = resultSet.getInt("user_id");
        String description = resultSet.getString("description");
        LocalDateTime dateAdded = (LocalDateTime) resultSet.getObject("date_added");
        String url = resultSet.getString("url");
        byte[] photo = resultSet.getBytes("photo");
        return new Tweet(tweetId, userId, description, dateAdded, url, photo);
    }

}

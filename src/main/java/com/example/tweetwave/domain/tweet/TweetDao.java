package com.example.tweetwave.domain.tweet;

import com.example.tweetwave.configuration.DataSourceProvider;
import jakarta.servlet.http.Part;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.sql.DataSource;
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

    public void save(Tweet tweet){
        final String query = """
                INSERT INTO 
                    tweet (user_id, description, date_added, url, photo)
                VALUES
                    (?,?,?,?,?)    
                """;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, tweet.getUserId());
            statement.setString(2, tweet.getDescription());
            statement.setObject(3, tweet.getDateAdded());
            statement.setString(4, tweet.getUrl());

            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()){
                tweet.setId(generatedKeys.getInt(1));
            }


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
        Part photo = (Part) resultSet.getObject("photo");
        return new Tweet(tweetId, userId, description, dateAdded, url, photo);
    }

}

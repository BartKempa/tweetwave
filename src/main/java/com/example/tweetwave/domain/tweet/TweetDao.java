package com.example.tweetwave.domain.tweet;

import com.example.tweetwave.configuration.DataSourceProvider;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TweetDao {
    private final DataSource dataSource;

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
                    id, user_id, description, date_added, url
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
        return new Tweet(tweetId, userId, description, dateAdded, url);
    }

}

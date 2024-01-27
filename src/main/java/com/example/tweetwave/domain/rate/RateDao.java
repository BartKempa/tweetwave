package com.example.tweetwave.domain.rate;

import com.example.tweetwave.configuration.DataSourceProvider;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RateDao {
    private final DataSource dataSource;
    public RateDao() {
        try {
            dataSource = DataSourceProvider.getDataSource();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(Rate rate){
        final String query = """
                INSERT INTO
                    rate(user_id, tweet_id, type, date_added)
                VALUES
                    (?, ?, ?, ?)
                ON DUPLICATE KEY UPDATE
                    type = ?
                """;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, rate.getUserId());
            statement.setInt(2, rate.getTweetId());
            statement.setString(3, rate.getType().toString());
            statement.setObject(4, rate.getDateAdded());
            statement.setString(5, rate.getType().toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

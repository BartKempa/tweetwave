package com.example.tweetwave.domain.comment;

import com.example.tweetwave.configuration.DataSourceProvider;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

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
}

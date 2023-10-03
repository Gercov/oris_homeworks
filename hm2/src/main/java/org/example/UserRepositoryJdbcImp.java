package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryJdbcImp implements UserRepository {
    private Connection connection;

    public UserRepositoryJdbcImp(Connection connection) {
        this.connection = connection;
    }
    @Override
    public List<User> findByLogin(String login) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM \"User\" WHERE login = '" + login + "'");
            List<User> result = new ArrayList<>();

            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getInt("age"),
                        resultSet.getString("login")
                );
                if (user.getLogin().equals(login)) {
                    result.add(user);
                }
                if (result.isEmpty()) {
                    System.out.println("По введенному логину ничего не найдено...");
                }
                for (int i = 0; i < result.size(); i++) {
                    System.out.println(user.getFirstName() + " " + user.getLastName());
                }
                return result;
            }
            return result;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}

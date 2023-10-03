package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class MainRepository {
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "root";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/testdb";

    public static void main(String[] args) throws Exception{
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        UserRepository userRepository = new UserRepositoryJdbcImp(connection);
        List<User> users = userRepository.findByLogin("gercovv");
    }
}

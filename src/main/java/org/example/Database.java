package org.example;

import java.sql.*;

public class Database {

    private static final Database INSTANCE = new Database();
    private static Connection connection;

    private Database() {
        String url = PropReader.getConnectionUrl();

        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new RuntimeException("Connecting uncreateble");
        }
    }

    public static Database getInstance() { return INSTANCE;}
    public static Connection getConnection() { return connection;}

    public static int executeUpdate(String query) {
        try(Statement statement = connection.createStatement()) {
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException("Cannot run query");
        }
    }

    public static void executeResult(String query) {
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()) {
                TestData td = new TestData(resultSet.getInt("id"), resultSet.getString("name"));
                System.out.println("postgres ------>>>> " + td.toString());
            }
        } catch(SQLException e) {
            System.out.println(String.format("Exception. Reason: %s", e.getMessage()));
            throw new RuntimeException("Can not run query.");
        }
    }

//    public void execute(String query) {
//        try(Statement statement = connection.createStatement()) {
//
//        }
//    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;

public class Database {

    private static final Database INSTANCE = new Database();
    private static Connection connection;

    private Database() {
        String jdbcUrl = "jdbc:postgresql://localhost:32768/ladatabase";
        String username = "postgres";
        String password = "123";

        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Connected yupi");
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

//    public static void executeResult(String query) {
//        try(Statement statement = connection.createStatement()) {
//            ResultSet resultSet = statement.executeQuery(query);
//            while(resultSet.next()) {
//                TestData td = new TestData(resultSet.getInt("id"), resultSet.getString("name"));
//                System.out.println("postgres ------>>>> " + td.toString());
//            }
//        } catch(SQLException e) {
//            System.out.println(String.format("Exception. Reason: %s", e.getMessage()));
//            throw new RuntimeException("Can not run query.");
//        }
//    }

    public static void executeResult(String query) {
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()) {
                MaxProjectCountClient maxProjectCountClient = new MaxProjectCountClient(resultSet.getString("name"), resultSet.getInt("count"));
                System.out.println("postgres ------>>>> " + maxProjectCountClient.toString());
            }
        } catch(SQLException e) {
            System.out.println(String.format("Exception. Reason: %s", e.getMessage()));
            throw new RuntimeException("Can not run query.");
        }
    }

//public void execute(String fileName) {
//    try(Statement statement = connection.createStatement()) {
//        String content = new String(Files.readAllBytes(Paths.get(fileName)));
//        statement.execute(content);
//    } catch(SQLException e) {
//        System.out.println(String.format("Exception. Reason: %s", e.getMessage()));
//        throw new RuntimeException("Can not run query.");
//    } catch(IOException e) {
//        throw new RuntimeException(e);
//    }
//}

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

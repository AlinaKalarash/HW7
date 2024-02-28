package org.example;

import org.example.service.*;

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

    public static void maxProjectCountClientResult(String query) {
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

    public static void longestProjectResult(String query) {
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()) {
                LongestProject longestProject = new LongestProject(resultSet.getInt("id"), resultSet.getInt("duration"));
                System.out.println("postgres ------>>>> " + longestProject.toString());
            }
        } catch(SQLException e) {
            System.out.println(String.format("Exception. Reason: %s", e.getMessage()));
            throw new RuntimeException("Can not run query.");
        }
    }

    public static void maxSalaryWorkerResult(String query) {
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()) {
                MaxSalaryWorker maxSalaryWorker = new MaxSalaryWorker(resultSet.getString("name"), resultSet.getInt("salary"));
                System.out.println("postgres ------>>>> " + maxSalaryWorker.toString());
            }
        } catch(SQLException e) {
            System.out.println(String.format("Exception. Reason: %s", e.getMessage()));
            throw new RuntimeException("Can not run query.");
        }
    }

    public static void printProjectPricesResult(String query) {
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()) {
                PrintProjectPrices printProjectPrices = new PrintProjectPrices(resultSet.getInt("id"), resultSet.getInt("project_cost"));
                System.out.println("postgres ------>>>> " + printProjectPrices.toString());
            }
        } catch(SQLException e) {
            System.out.println(String.format("Exception. Reason: %s", e.getMessage()));
            throw new RuntimeException("Can not run query.");
        }
    }

        public static void youngestEldestWorkersResult(String query) {
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()) {
                YoungestEldestWorkers youngestEldestWorkers = new YoungestEldestWorkers(resultSet.getString("type"), resultSet.getString("name"), resultSet.getInt("birthday"));
                System.out.println("postgres ------>>>> " + youngestEldestWorkers.toString());
            }
        } catch(SQLException e) {
            System.out.println(String.format("Exception. Reason: %s", e.getMessage()));
            throw new RuntimeException("Can not run query.");
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

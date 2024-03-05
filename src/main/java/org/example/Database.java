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
    public static int executeUpdate(long id, String name, int birthday, String level, int salary) {
        try(PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO worker (ID, NAME, BIRTHDAY, LEVEL, SALARY) VALUES (?, ?, ?, ?, ?)")) {
            preparedStatement.setLong(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, birthday);
            preparedStatement.setString(4, level);
            preparedStatement.setInt(5, salary);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Cannot run query");
        }
    }
    public static int executeUpdate(long id, int clientId) {
        try(PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO client (ID, CLIENT_ID) VALUES (?, ?)")) {
            preparedStatement.setLong(1, id);
            preparedStatement.setInt(2, clientId);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Cannot run query");
        }
    }

    public static int executeUpdate(long id, int clientId, String  start, String  finish) {
        try(PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO project (ID, CLIENT_ID, START_DATE, FINISH_DATE) VALUES (?, ?, ?, ?)")) {
            preparedStatement.setLong(1, id);
            preparedStatement.setInt(2, clientId);
            preparedStatement.setDate(3, Date.valueOf(start));
            preparedStatement.setDate(4, Date.valueOf(finish));
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Cannot run query");
        }
    }

    public static int executeUpdate(long projectId, long workerId) {
        try(PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES (?, ?)")) {
            preparedStatement.setLong(1, projectId);
            preparedStatement.setLong(2, workerId);
            return preparedStatement.executeUpdate();
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

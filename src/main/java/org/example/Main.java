package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

////        Connection connection = Database.getConnection();
//
//        Database database = Database.getInstance();
//
//
////        database.executeUpdate("INSERT INTO test_table VALUES (7, 'Oleg')");
//        database.executeResult("SELECT * FROM mytable");

        String jdbcUrl = "jdbc:postgresql://localhost:32768/ladatabase";
        String username = "postgres";
        String password = "123";

            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connected yupi");



            connection.close();
    }
}
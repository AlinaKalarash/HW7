package org.example;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

//        Connection connection = Database.getConnection();

        Database database = Database.getInstance();


//        database.executeUpdate("INSERT INTO test_table VALUES (7, 'Oleg')");
        database.executeResult("SELECT * FROM mytable");
    }
}
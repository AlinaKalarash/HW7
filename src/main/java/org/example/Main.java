package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("src/main/resources/sql/init_db.sql");
        System.out.println("It's reader: "+file);

        Scanner scanner = new Scanner(file);

        StringBuilder builder = new StringBuilder();

        while (scanner.hasNext()) {
            builder.append(scanner.nextLine()).append("\n");
        }
        System.out.println("-----------------");
        System.out.println(builder);



        Database database = Database.getInstance();



//        database.executeResult("SELECT * FROM mytable");

        System.out.println("----------------- \n");
        try {
            database.executeUpdate(builder.toString());
        } catch (Exception e) {
            System.out.println("Error");
        }
//        TestData td = new TestData(resultSet.getInt("id"), resultSet.getString("name"));
        TestData td = null;



//        database.executeResult("SELECT * FROM mytable");

        Connection conn = Database.getInstance().getConnection();
        System.out.println("\n\n\n----------------- \nThe connection: " + conn + "\n-----------------");


        database.closeConnection();
    }
}
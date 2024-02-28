package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.Scanner;

public class DatabaseInitService {


    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("src/main/resources/sql/init_db.sql");

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

//        database.executeResult("SELECT * FROM mytable");

        Connection conn = Database.getInstance().getConnection();
        System.out.println("\n\n\n----------------- \nThe connection: " + conn + "\n-----------------");


        database.closeConnection();
    }
}

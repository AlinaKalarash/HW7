package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.Scanner;

public class DatabasePopulateService {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("src/main/resources/sql/populate_db.sql");
        System.out.println("It's reader: "+file);

        Scanner scanner = new Scanner(file);

        StringBuilder builder = new StringBuilder();

        while (scanner.hasNext()) {
            builder.append(scanner.nextLine()).append("\n");
        }
        System.out.println("-----------------");
        System.out.println(builder);



        Database database = Database.getInstance();



        System.out.println("----------------- \n");
        try {
            database.executeUpdate(builder.toString());
        } catch (Exception e) {
            System.out.println("Error");
        }


        Connection conn = Database.getInstance().getConnection();
        System.out.println("\n\n\n----------------- \nThe connection: " + conn + "\n-----------------");


        database.closeConnection();
    }
}

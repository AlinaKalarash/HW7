package org.example;

import org.example.service.DatabaseQueryService;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.Scanner;

public class DatabaseInitService {


    public static void main(String[] args) throws FileNotFoundException {

        StringBuilder builder = new DatabaseQueryService().fileReader("init_db.sql");

//        File file = new File("src/main/resources/sql/init_db.sql");
//        Scanner scanner = new Scanner(file);
//        StringBuilder builder = new StringBuilder();
//        while (scanner.hasNext()) {
//            builder.append(scanner.nextLine()).append("\n");
//        }

        Database database = Database.getInstance();


        try {
            database.executeUpdate(builder.toString());
        } catch (Exception e) {
            System.out.println("Error");
        }

        Connection conn = Database.getInstance().getConnection();

        database.closeConnection();
    }
}

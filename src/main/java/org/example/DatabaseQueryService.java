package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DatabaseQueryService {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("src/main/resources/sql/find_max_projects_client.sql");

        Scanner scanner = new Scanner(file);

        StringBuilder builder = new StringBuilder();

        while (scanner.hasNext()) {
            builder.append(scanner.nextLine()).append("\n");
        }
        System.out.println(builder);

        Database database = Database.getInstance();

        database.executeResult(builder.toString());



        database.closeConnection();
    }


}

package org.example.service;

import org.example.Database;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DatabaseQueryService {
    public static void main(String[] args) throws FileNotFoundException {


        Database database = Database.getInstance();
        DatabaseQueryService service = new DatabaseQueryService();

        database.maxProjectCountClientResult(service.fileReader("find_max_projects_client.sql").toString());

        System.out.println("\n\n\n----------------------------\n\n\n");

        database.longestProjectResult(service.fileReader("find_longest_project.sql").toString());

        System.out.println("\n\n\n----------------------------\n\n\n");

        database.maxSalaryWorkerResult(service.fileReader("find_max_salary_worker.sql").toString());

        System.out.println("\n\n\n----------------------------\n\n\n");

        database.printProjectPricesResult(service.fileReader("print_project_prices.sql").toString());

        System.out.println("\n\n\n----------------------------\n\n\n");

        database.youngestEldestWorkersResult(service.fileReader("find_youngest_eldest_workers.sql").toString());



        database.closeConnection();
    }

    public StringBuilder fileReader(String filesName) throws FileNotFoundException {
        File file = new File("src/main/resources/sql/" + filesName);
        Scanner scanner = new Scanner(file);
        StringBuilder builder = new StringBuilder();
        while (scanner.hasNext()) {
            builder.append(scanner.nextLine()).append("\n");
        }

        return builder;
    }
}

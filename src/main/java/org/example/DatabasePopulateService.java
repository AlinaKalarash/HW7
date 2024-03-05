package org.example;

import org.example.service.DatabaseQueryService;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.Scanner;

public class DatabasePopulateService {
    public static void main(String[] args) throws FileNotFoundException {

        StringBuilder builder = new DatabaseQueryService().fileReader("populate_db.sql");

//        File file = new File("src/main/resources/sql/populate_db.sql");
//        Scanner scanner = new Scanner(file);
//        StringBuilder builder = new StringBuilder();
//
//        while (scanner.hasNext()) {
//            builder.append(scanner.nextLine()).append("\n");
//        }

        Database database = Database.getInstance();

        try {
            database.executeUpdate("DELETE FROM worker");
            database.executeUpdate("DELETE FROM client");
            database.executeUpdate("DELETE FROM project");
            database.executeUpdate("DELETE FROM project_worker");
        } catch (Exception e) {
            System.out.println("Cannot delete");
        }


//        try {
//            database.executeUpdate(builder.toString());
//        } catch (Exception e) {
//            System.out.println("Error");
//        }

        try {
            database.executeUpdate(2L, "Emily Johnson", 1985, "Junior", 1200);
            database.executeUpdate(3L, "Michael Brown", 1982, "Middle", 2500);
            database.executeUpdate(4L, "Sarah Davis", 1988, "Senior", 6000);
            database.executeUpdate(5L, "Christopher Wilson", 1995, "Junior", 1100);
            database.executeUpdate(6L, "Jessica Martinez", 1992, "Middle", 2700);
            database.executeUpdate(7L, "William Taylor", 1983, "Senior", 7000);
            database.executeUpdate(8L, "Jennifer Anderson", 1987, "Trainee", 900);
            database.executeUpdate(9L, "David Thomas", 1993, "Middle", 3000);
            database.executeUpdate(10L, "Amanda Garcia", 1980, "Senior", 8000);

        } catch (Exception e) {
            System.out.println("ERROR1");
        }

        try {
            database.executeUpdate(1L, 1);
            database.executeUpdate(2L, 2);
            database.executeUpdate(3L, 3);
            database.executeUpdate(4L, 4);
            database.executeUpdate(5L, 5);
        } catch (Exception e) {
            System.out.println("ERROR2");
        }

        try {
            database.executeUpdate(1L, 1, "2023-01-01", "2023-04-30");
            database.executeUpdate(2L, 2, "2022-09-15", "2023-05-31");
            database.executeUpdate(3L, 3, "2022-11-10", "2023-03-20");
            database.executeUpdate(4L, 4, "2023-02-20", "2023-06-30");
            database.executeUpdate(5L, 5, "2022-12-05", "2023-07-15");
            database.executeUpdate(6L, 6, "2023-01-20", "2023-08-10");
            database.executeUpdate(7L, 7, "2023-03-10", "2023-10-05");
            database.executeUpdate(8L, 8, "2022-10-01", "2023-09-30");
            database.executeUpdate(9L, 9, "2023-04-15", "2024-01-10");
            database.executeUpdate(10L, 10, "2022-12-20", "2023-11-30");

        } catch (Exception e) {
            System.out.println("ERROR3");
        }

        try {
            database.executeUpdate(2L, 4L);
            database.executeUpdate(3L, 6L);
            database.executeUpdate(4L, 7L);
            database.executeUpdate(5L, 9L);
        } catch (Exception e) {
            System.out.println("ERROR4");
        }


        database.closeConnection();
    }
}

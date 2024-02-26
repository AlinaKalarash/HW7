package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropReader {

    public static String getConnectionUrl() {
        try (InputStream input = PropReader.class.getClassLoader().getResourceAsStream("application.properties")) {

            Properties properties = new Properties();

            if(input == null) {
                return null;
            }

            properties.load(input);

            return new StringBuilder("jdbc:postgresql://")
                    .append(properties.getProperty("postgres.db.host"))
                    .append(":")
                    .append(properties.getProperty("postgres.db.port"))
                    .append("/")
                    .append(properties.getProperty("postgres.db.database"))
                    .append("?currentSchema=public")
                    .toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}

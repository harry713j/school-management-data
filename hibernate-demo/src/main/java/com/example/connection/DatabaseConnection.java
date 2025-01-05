package com.example.connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DatabaseConnection {
    private static SessionFactory sessionFactory;

    public static Session createSession(){
        Properties properties = new Properties();

        try(FileInputStream inputStream = new FileInputStream(new File("src/main/resources/db.properties"))) {
            properties.load(inputStream);
        }catch (IOException e){
            System.err.println("Failed to load database credentials file: " + e.getMessage());
        }

        String url = properties.getProperty("db.url");
        String username = properties.getProperty("db.username");
        String password = properties.getProperty("db.password");
        String driver = properties.getProperty("db.driver");

        Configuration config = new Configuration();

        config.setProperty("hibernate.connection.url", url);
        config.setProperty("hibernate.connection.username", username);
        config.setProperty("hibernate.connection.password", password);
        config.setProperty("hibernate.connection.driver_class", driver);

        sessionFactory = config.configure("hibernate.cfg.xml").buildSessionFactory();

        return sessionFactory.getCurrentSession();
    }
}

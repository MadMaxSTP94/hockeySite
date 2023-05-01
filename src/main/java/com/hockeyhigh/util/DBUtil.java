package com.hockeyhigh.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    private Connection connection;
    public static DBUtil instance;

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/hockeysite";
    private static final String DB_USER = "postgres";
    private static final String DB_PASS = "postgres";

    private DBUtil() {
        try{
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            System.out.println("Connection is denied!!!");
        }
        catch (Exception ex){
            System.out.println("Could not get connection! (-_-)");
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DBUtil getInstance() {
        if(instance == null)
            instance = new DBUtil();
        return instance;
    }
}

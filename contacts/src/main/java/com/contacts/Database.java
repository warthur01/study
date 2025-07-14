package com.contacts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:postgresql:db-study.csb8icuwabi3.us-east-1.rds.amazonaws.com:5432/agenda";
    private static final String USER = "postgres";
    private static final String PASSWORD = "ASTimperial12";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}


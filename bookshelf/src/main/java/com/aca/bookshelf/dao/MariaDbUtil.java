package com.aca.bookshelf.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDbUtil {

    private static String connectionUrl =
            "jdbc:mariadb://localhost:3306/mybooks?user=root&password=s!mpl3Pa$s";

    public static Connection getConnection(){
        Connection connection = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(connectionUrl);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        Connection connection = MariaDbUtil.getConnection();
        if (null != connection){
            System.out.println("Connected");
        } else {
            System.out.println("No connection");
        }
    }
}

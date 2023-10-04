package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private static String url = "jdbc:mysql://localhost:3306/platziDB2";
    private static String user = "black-programmer";
    private static String password = "N3wPassw0rd*";

    private static Connection myConnection;

    public static Connection getInstance() throws SQLException {
        if(myConnection == null){
            myConnection = DriverManager.getConnection(url,user,password);
        }
        return myConnection;
    }
}

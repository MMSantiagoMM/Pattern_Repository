package org.example.main;

import org.example.util.DataBaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {

    try
        (Connection myConnection = DataBaseConnection.getInstance();
        Statement myStatement = myConnection.createStatement();
         ResultSet myResult = myStatement.executeQuery("SELECT * FROM employees");)
    {

        while (myResult.next()){
            System.out.println("first_name");
        }

    }catch (SQLException e){
        e.printStackTrace();
        System.out.println("Something wrong happened" + e );
    }




    }
}
package org.example.main;

import org.example.model.Employee;
import org.example.repository.EmployeeRepository;
import org.example.repository.Repository;
import org.example.util.DataBaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class Main2 {
    public static void main(String[] args) throws SQLException {

        try(Connection myConnection = DataBaseConnection.getInstance()){
            Repository<Employee> repository = new EmployeeRepository();

            repository.findAll().forEach(System.out::println);
        }



    }
}

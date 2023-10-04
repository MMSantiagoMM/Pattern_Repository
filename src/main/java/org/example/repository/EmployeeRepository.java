package org.example.repository;

import org.example.model.Employee;
import org.example.util.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements Repository<Employee> {

    private Connection getConnection() throws SQLException {
        return DataBaseConnection.getInstance();
    }

    @Override
    public List<Employee> findAll() throws SQLException {
        List<Employee>employees = new ArrayList<>();
        try(Statement myStatement = getConnection().createStatement();
            ResultSet myResult = myStatement.executeQuery("SELECT * FROM employee")){
            while (myResult.next()){
                Employee e = createEmployee(myResult);
                employees.add(e);
            }
        }
        return employees;
    }



    @Override
    public Employee getById(Integer id) throws SQLException {
        Employee employee = null;
        try(PreparedStatement myPrepared = getConnection()
                .prepareStatement("SELECT * FROM employees WHERE id = ?")){
            myPrepared.setInt(1,id);
            try (ResultSet myResult = myPrepared.executeQuery()){
                if(myResult.next()){
                    employee = createEmployee(myResult);
                }
            }
        }
        return employee;
    }

    @Override
    public void save(Employee employee) {

    }

    @Override
    public void delete(Integer id) {

    }


    private Employee createEmployee(ResultSet myResult) throws SQLException {
        Employee e = new Employee();
        e.setId(myResult.getInt("id"));
        e.setFirstName(myResult.getString("first_name"));
        e.setPa_surname(myResult.getString("pa_surname"));
        e.setMa_surname(myResult.getString("ma_surname"));
        e.setEmail(myResult.getString("email"));
        e.setSalary(myResult.getFloat("salary"));
        return e;
    }
}


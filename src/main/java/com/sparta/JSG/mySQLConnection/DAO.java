package com.sparta.JSG.mySQLConnection;
import com.sparta.JSG.empoyee.Employee;
import com.sparta.JSG.manager.EmployeeManager;

import java.sql.*;
import java.util.Arrays;
import java.util.HashMap;

public class DAO extends Employee{

    EmployeeManager[] employeeManagersArray;

    private final String INSERT_QUERY = "INSERT INTO employee_data VALUES (?,?,?,?,?,?,?,?,?,?)";

    private final String URL = "jdbc:mysql://localhost/employees?user=root&password=Se2852jayY!";

    public void runSQLQuery(HashMap<String, EmployeeManager> newHashMap){
        try(Connection connection = DriverManager.getConnection(URL)){
            PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);

            for (EmployeeManager values : newHashMap.values()) {
                statement.setInt(1, values.getEmpId());
                statement.setString(2, values.getNamePrefix());
                statement.setString(3,values.getFirstName());
                statement.setString(4,values.getMiddleInitial());
                statement.setString(5,values.getLastName());
                statement.setString(6,values.getGender());
                statement.setString(7,values.getEmail());
                statement.setDate(8, Date.valueOf(values.getDateOfBirth()));
                statement.setDate(9,Date.valueOf(values.getDateOfJoining()));
                statement.setDouble(10, values.getSalary());
                statement.executeUpdate();
            }
        }catch (SQLException e ){
            e.printStackTrace();
        }
    }


    public void insertArray(EmployeeManager[] data){
        try(Connection connection = DriverManager.getConnection(URL)){
            PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);

            for (EmployeeManager values : employeeManagersArray) {
                statement.setInt(1, values.getEmpId());
                statement.setString(2, values.getNamePrefix());
                statement.setString(3,values.getFirstName());
                statement.setString(4,values.getMiddleInitial());
                statement.setString(5,values.getLastName());
                statement.setString(6,values.getGender());
                statement.setString(7,values.getEmail());
                statement.setDate(8, Date.valueOf(values.getDateOfBirth()));
                statement.setDate(9,Date.valueOf(values.getDateOfJoining()));
                statement.setDouble(10, values.getSalary());
                statement.executeUpdate();
            }
        }catch (SQLException e ){
            e.printStackTrace();
        }
    }


    public void runSQLQueryThread(HashMap<String, EmployeeManager> newHashMap){
        employeeManagersArray = readEmployeeFile().values().toArray(new EmployeeManager[readEmployeeFile().size()]);
        Thread[] thread = new Thread[100];

        int countEmployee = employeeManagersArray.length;
        int threadCount = thread.length;

        for (int i = 0; i <thread.length ; i++) {
            final int j = i;
            Runnable runnable;
            if ((countEmployee*(i+1))/threadCount > countEmployee){
                runnable = () -> insertArray(Arrays.copyOfRange(employeeManagersArray,(countEmployee*j)/threadCount, employeeManagersArray.length));
            } else {
                runnable = () -> insertArray(Arrays.copyOfRange(employeeManagersArray,(countEmployee*j)/threadCount, (countEmployee * (j+1))/threadCount));
            }
            thread[i] = new Thread(runnable);
            thread[i].start();
        }

        try(Connection connection = DriverManager.getConnection(URL)){
            PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);

            for (EmployeeManager values : newHashMap.values()) {
                statement.setInt(1, values.getEmpId());
                statement.setString(2, values.getNamePrefix());
                statement.setString(3,values.getFirstName());
                statement.setString(4,values.getMiddleInitial());
                statement.setString(5,values.getLastName());
                statement.setString(6,values.getGender());
                statement.setString(7,values.getEmail());
                statement.setDate(8, Date.valueOf(values.getDateOfBirth()));
                statement.setDate(9,Date.valueOf(values.getDateOfJoining()));
                statement.setDouble(10, values.getSalary());
                statement.executeUpdate();
            }
        }catch (SQLException e ){
            e.printStackTrace();
        }
    }


//    public String convertToArray(HashMap<String, EmployeeManager> hashMap){
//        Object[] objects = hashMap.entrySet().toArray();
//        return Arrays.toString(objects);
//    }



}


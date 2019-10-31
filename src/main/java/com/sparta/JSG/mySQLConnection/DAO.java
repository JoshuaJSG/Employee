package com.sparta.JSG.mySQLConnection;
import com.sparta.JSG.empoyee.Employee;
import com.sparta.JSG.manager.EmployeeManager;

import java.sql.*;
import java.util.HashMap;

public class DAO {
    private final String INSERT_QUERY = "INSERT INTO employee_data VALUES (?,?,?,?,?,?,?,?,?,?)";

    private final String QUERY = "SELECT first_name, last_name FROM employee_data WHERE emp_ID = ?";
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
    
}


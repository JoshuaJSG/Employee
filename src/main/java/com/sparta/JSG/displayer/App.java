package com.sparta.JSG.displayer;

import com.sparta.JSG.empoyee.Employee;
import com.sparta.JSG.manager.EmployeeManager;
import com.sparta.JSG.mySQLConnection.DAO;

import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){

        Employee employee = new Employee();
        HashMap<String,EmployeeManager> hash = employee.readEmployeeFile();
        System.out.println(hash.size());


//        DAO dao = new DAO();
//        dao.runSQLQuery(employee.readEmployeeFile());


    }
}

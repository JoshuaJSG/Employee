package com.sparta.JSG.displayer;

import com.sparta.JSG.empoyee.Employee;
import com.sparta.JSG.manager.EmployeeManager;
import com.sparta.JSG.mySQLConnection.DAO;

import java.util.HashMap;

/*
* Without thread = 728833 execution time.
* */
public class App {
    public static void main( String[] args ){

//        Employee employee = new Employee();
//        HashMap<String,EmployeeManager> hash = employee.readEmployeeFile();
//        System.out.println(hash.size());


        /*
        * Reads file through a thread
        * */
//        Runnable runnable = new Employee();
//        Thread thread = new Thread(runnable);
//        thread.start();

        DAO dao = new DAO();
        Employee employee = new Employee();

        HashMap<String, EmployeeManager> hashMap = employee.readEmployeeFile();
        dao.runSQLQueryThread(hashMap);
        /*
        * Add file to the database*/

//        long value = TimeUnit.NANOSECONDS.toSeconds(System.nanoTime());
//        DAO dao = new DAO();
//        dao.runSQLQuery(employee.readEmployeeFile());
//        System.out.println(value);


    }
}

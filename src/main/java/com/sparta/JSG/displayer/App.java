package com.sparta.JSG.displayer;

import com.sparta.JSG.empoyee.Employee;
import com.sparta.JSG.manager.EmployeeManager;
import com.sparta.JSG.mySQLConnection.DAO;
import com.sparta.JSG.runnableTasks.ThreadedTasks;

import javax.xml.crypto.dom.DOMCryptoContext;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

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


        /*
        * Add file to the database*/
        Runnable runnable1 = new ThreadedTasks();
        Thread thread1 = new Thread(runnable1);

        thread1.start();

//
//        long value = TimeUnit.NANOSECONDS.toSeconds(System.nanoTime());
//        DAO dao = new DAO();
//        dao.runSQLQuery(employee.readEmployeeFile());
//        System.out.println(value);


    }
}

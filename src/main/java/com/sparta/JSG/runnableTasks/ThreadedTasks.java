package com.sparta.JSG.runnableTasks;

import com.sparta.JSG.empoyee.Employee;
import com.sparta.JSG.manager.EmployeeManager;
import com.sparta.JSG.mySQLConnection.DAO;

import java.util.Arrays;
import java.util.HashMap;

public class ThreadedTasks extends DAO implements Runnable {
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            HashMap<String, EmployeeManager> map = readEmployeeFile();
            Object[] employeesInMap = map.entrySet().toArray();
            runSQLQuery(employeesInMap);
        }
    };


}

package com.sparta.JSG.empoyee;

import com.sparta.JSG.manager.EmployeeManager;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Employee {

    private HashMap<String,EmployeeManager> hashMap;
    private static final String PATH = "resources/testResources.csv";

    public HashMap<String, EmployeeManager> readEmployeeFile() {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH));
            hashMap = new HashMap<>();

            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");

            String line;
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
               String[] employeeData = line.split(",");
                    hashMap.put(employeeData[0], new EmployeeManager(Integer.parseInt(employeeData[0]),
                            employeeData[1],employeeData[2],employeeData[3],employeeData[4],employeeData[5],employeeData[6],
                            LocalDate.parse(employeeData[7],dateTimeFormatter),LocalDate.parse(employeeData[8],dateTimeFormatter),Double.parseDouble(employeeData[9])));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hashMap;
    }

//    public HashMap<String, EmployeeManager> searchDuplicates(HashMap<String, EmployeeManager> csvHashMap){
//        HashMap<String, EmployeeManager> hashMap = new
//        HashMap<String,EmployeeManager> map = hashMap;
//        if ()
//        return map;
//    }






}

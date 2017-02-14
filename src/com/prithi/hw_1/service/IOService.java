package com.prithi.hw_1.service;

import com.prithi.hw_1.domain.EmployeePOJO;

import java.util.Scanner;

/**
 * Created by Prithi on 09-Feb-17.
 */
public class IOService {

    Scanner kb = new Scanner(System.in);

    public int getID(){
        System.out.println("Enter ID");
        int id = kb.nextInt();
        return id;
    }

    public String getFirstName(){
        System.out.println("Enter First Name");
        String first = kb.next();
        first = "'"+first+"'";
        return first;
    }

    public String getLastName(){
        System.out.println("Enter Lase Name");
        String last = kb.next();
        last = "'"+last+"'";
        return last;
    }

    public int getAge(){
        System.out.println("Enter Age");
        int age = kb.nextInt();
        return age;
    }

    public void printWelcomeMessage(){
        System.out.println("Choose 1 to view and 2 to insert a new Employee");
    }

    public int getUserAction(){
        int i = kb.nextInt();
        return i;
    }

    public EmployeePOJO getNewEmployeeInformation(){
        EmployeePOJO employee = new EmployeePOJO();
        IOService ioService = new IOService();
        employee.setID(ioService.getID());
        employee.setFirstName(ioService.getFirstName());
        employee.setLastName(ioService.getLastName());
        employee.setAge(ioService.getAge());
        return employee;
    }


}

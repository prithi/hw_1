package com.prithi.hw_1.service;

import java.util.Scanner;

/**
 * Created by Prithi on 09-Feb-17.
 */
public class IOService {

    Scanner kb = new Scanner(System.in);

    public void getID(){
        System.out.println("Enter ID");
        int id = kb.nextInt();
    }

    public void getFirstName(){
        System.out.println("Enter First Name");
        String first = kb.next();
        first = "'"+first+"'";
    }

    public void getLastName(){
        System.out.println("Enter Lase Name");
        String last = kb.next();
        last = "'"+last+"'";

    }

    public void getAge(){
        System.out.println("Enter Age");
        int age = kb.nextInt();




    }


}

package com.prithi.hw_1.domain;

/**
 * Created by Prithi on 09-Feb-17.
 */
public class EmployeePOJO {

    String firstName, lastName;
    int id, age;

    public void setFirstName(String firstName){
    this.firstName = firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setID(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}

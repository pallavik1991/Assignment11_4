package com.example.akaash.assignment11_4;

/**
 * Created by AKAASH on 22-11-2017.
 */

public class Person
{
    int id;
    String fname,lname;
    Person(){}
    Person(String fname,String lname)
    {
        this.fname=fname;
        this.lname=lname;
    }
    public void setId(int id)
    {
        this.id=id;
    }
    public void setFname(String fname)
    {
        this.fname=fname;
    }
    public void setLname(String lname)
    {
        this.lname=lname;
    }
    public int getId()
    {
        return this.id;
    }
    public String getFname()
    {
        return this.fname;
    }
    public String getLname()
    {
        return this.lname;
    }
}

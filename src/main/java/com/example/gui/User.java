package com.example.gui;

import java.util.Map;
public class User {
    String address;
    String password;
    String Fname;
    String Lname;
    String email;
    String phone;
    public User(String Fname, String Lname, String password, String email, String phone, String address){
        this.Fname = Fname;
        this.Lname = Lname;
        this.address = address;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getFname() {
        return Fname;
    }

    public String getEmail() {
        return email;
    }

    public String getLname() {
        return Lname;
    }

    public String getPhone() {
        return phone;
    }

    // Override toString()
    @Override
    public String toString() {
        return "FirstName: " + Fname + ", LastName: " + Lname + ", Email: " + email +
                ", Phone: " + phone + ", Address: " + address + ", Password: " + password;
    }
}

package com.XiaoFeng.model;
import java.util.Date;

import java.sql.*;
import java.util.Date;
public class User {
    private int id;
    private String username;
    private String password;
    private String gender;
    private String email;
    private Date birthdate;

    public User(){
    }

    public User(int id,String username,String password,String gender,String email,Date birthdate){
        this.id=id;
        this.username=username;
        this.password=password;
        this.gender=gender;
        this.email=email;
        this.birthdate=birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }

    public String getUsername() {
        return username;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}

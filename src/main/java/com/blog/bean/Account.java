package com.blog.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class Account implements Serializable {
    private Long id;
    private String username;
    private String password;
    private String telephone;
    private int age;
    private int gender;
    private String address;
    private Timestamp creationTime;


    public Account(String username, String password, String telephone, int age, int gender, String address, Timestamp creationTime) {
        this.username = username;
        this.password = password;
        this.telephone = telephone;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.creationTime = creationTime;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", telephone='" + telephone + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                ", creationTime=" + creationTime +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    public Account() {
    }

    public Account(Long id, String username, String password, String telephone, int age, int gender, String address, Timestamp creationTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.telephone = telephone;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.creationTime = creationTime;
    }

}

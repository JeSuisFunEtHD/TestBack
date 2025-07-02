package com.example.demo.model;

public class UserInfo {
    private int id;
    private int userId;
    private String fullName;
    private int age;
    private String city;
    private String lastName;

    public UserInfo() {}

    public UserInfo(int id, int userId, String fullName, int age, String city, String lastName) {
        this.id = id;
        this.userId = userId;
        this.fullName = fullName;
        this.age = age;
        this.city = city;
        this.lastName = lastName;
    }

    // --- Геттеры и сеттеры ---
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
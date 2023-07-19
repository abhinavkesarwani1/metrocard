package com.example.geektrust.model;

public class User {
    String userId;
    String name;
    String email;
    String phone;

    public User(String n, String e, String phone) {
        this.userId = createNewUserId(n, phone);
        this.name = n;
        this.email = e;
        this.phone = phone;
    }

    private String createNewUserId(String name, String phone) {
        return name.concat("_").concat(phone);
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}

package com.example.moneytransfer.model;

public class Contact {
    private int id;
    private String name;
    private String phoneNumber;
    private String email;
    private int balance;

    public Contact() {
    }

    public Contact(int id, String name, String phoneNumber,String email, int balance) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.balance =balance;
    }

    public Contact(String name, String phoneNumber,String email, int balance) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.balance =balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}

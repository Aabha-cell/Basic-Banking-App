package com.example.moneytransfer.model;

public class Transaction {
    private int id1;
    private String sender;
    private String receiver;
    private String datetime;
    private int amount;
    private int rec_bal;
    private int sender_bal;

    public Transaction() {
    }
    public Transaction(int id1, String sender, String receiver, String datetime, int amount, int rec_bal, int sender_bal ){
        this.id1 =id1;
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.datetime = datetime;
        this.rec_bal = rec_bal;
        this.sender_bal = sender_bal;
    }
    public Transaction(String sender, String receiver, String datetime, int amount, int rec_bal, int sender_bal ){
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.datetime = datetime;
        this.rec_bal = rec_bal;
        this.sender_bal = sender_bal;
    }

    public int getId() {
        return id1;
    }

    public void setId(int id) {
        this.id1 = id1;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String reciever) {
        this.receiver = reciever;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = Integer.parseInt(amount);
    }

    public int getRec_bal() {
        return rec_bal;
    }

    public void setRec_bal(int rec_bal) {
        this.rec_bal = rec_bal;
    }

    public int getSender_bal() {
        return sender_bal;
    }

    public void setSender_bal(int sender_bal) {
        this.sender_bal = sender_bal;
    }
}

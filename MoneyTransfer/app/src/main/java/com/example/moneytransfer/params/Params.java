package com.example.moneytransfer.params;

public class Params {
    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "contacts_db";
    public static final String TABLE_NAME = "contacts_table";
    public static final String TABLE_NAME1 = "transactions_table";

    //keys of table
    public static final String KEY_ID= "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_PHONE = "phone_number";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_BALANCE = "balance";

    //keys of table1
    public static final String KEY_ID1= "id";
    public static final String KEY_SENDER = "sender";
    public static final String KEY_RECEIVER = "receiver";
    public static final String KEY_AMOUNT = "amount";
    public static final String KEY_DATETIME = "datetime";
    public static final String KEY_REC_BAL = "rec_bal";
    public static final String KEY_SENDER_BAL = "sender_bal";

}

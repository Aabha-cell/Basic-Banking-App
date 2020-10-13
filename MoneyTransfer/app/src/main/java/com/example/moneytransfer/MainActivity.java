package com.example.moneytransfer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.ArrayAdapter;


import com.example.moneytransfer.adapter.MakePayment;
import com.example.moneytransfer.adapter.RecyclerViewadapter;
import com.example.moneytransfer.data.MyDbHandler;
import com.example.moneytransfer.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerViewadapter recyclerViewadapter;
    private ArrayList<Contact> contactArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recyclerview initialization
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyDbHandler db = new MyDbHandler(MainActivity.this);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if(!prefs.getBoolean("firstTime", false)) {
            // run your one time code
            //Adding contact to db
            Contact aayushi = new Contact();
            aayushi.setName("Aayushi Bhat");
            aayushi.setPhoneNumber("9840761290");
            aayushi.setEmail("aayushibhat@gmail.com");
            aayushi.setBalance(5000);
            db.addContact(aayushi);

            Contact ajay = new Contact();
            ajay.setName("Ajay Sharma");
            ajay.setPhoneNumber("9956001780");
            ajay.setEmail("sharma.ajay@gmail.com");
            ajay.setBalance(3000);
            db.addContact(ajay);

            Contact dhruv = new Contact();
            dhruv.setName("Dhruv Patel");
            dhruv.setPhoneNumber("981624503");
            dhruv.setEmail("dhruvpatel@gmail.com");
            dhruv.setBalance(1230);
            db.addContact(dhruv);

            Contact maya = new Contact();
            maya.setName("Maya Saxena");
            maya.setPhoneNumber("9930784980");
            maya.setEmail("saxena.maya@gmail.com");
            maya.setBalance(5900);
            db.addContact(maya);

            Contact paul = new Contact();
            paul.setName("Paul Mathews");
            paul.setPhoneNumber("9486339852");
            paul.setEmail("paul.mathews@gmail.com");
            paul.setBalance(4080);
            db.addContact(paul);

            Contact pranav = new Contact();
            pranav.setName("Pranav Mittal");
            pranav.setPhoneNumber("9912085683");
            pranav.setEmail("mittalpranav@gmail.com");
            pranav.setBalance(4100);
            db.addContact(pranav);

            Contact priya = new Contact();
            priya.setName("Priya Kapoor");
            priya.setPhoneNumber("9390193750");
            priya.setEmail("priyakapoor@gmail.com");
            priya.setBalance(7600);
            db.addContact(priya);

            Contact rohan = new Contact();
            rohan.setName("Rohan Yadav");
            rohan.setPhoneNumber("9840798712");
            rohan.setEmail("rohan.yadav@gmail.com");
            rohan.setBalance(8390);
            db.addContact(rohan);

            Contact simran = new Contact();
            simran.setName("Simran Singh");
            simran.setPhoneNumber("9814729085");
            simran.setEmail("singhsimran@gmail.com");
            simran.setBalance(1089);
            db.addContact(simran);

            Contact tanya = new Contact();
            tanya.setName("Tanya Advani");
            tanya.setPhoneNumber("9516312852");
            tanya.setEmail("tanya123@gmail.com");
            tanya.setBalance(6000);
            db.addContact(tanya);

            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstTime", true);
            editor.commit();
        }



        contactArrayList = new ArrayList<>();

        //Get all contacts
        List<Contact> contactList = db.getAllContacts();
        for (Contact contact: contactList){
            Log.d("userdb","Name: "+ contact.getName()+"\n");
            contactArrayList.add(contact);

        }

        //Use your recyclerView
        recyclerViewadapter = new RecyclerViewadapter(MainActivity.this, contactArrayList);
        recyclerView.setAdapter(recyclerViewadapter);


    }
}
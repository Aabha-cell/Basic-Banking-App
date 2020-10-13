package com.example.moneytransfer.adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.moneytransfer.MainActivity;
import com.example.moneytransfer.R;
import com.example.moneytransfer.data.MyDbHandler;

import java.util.ArrayList;
import java.util.List;
public class MakePayment extends AppCompatActivity  {
    Spinner spinner;
    int amount;
    EditText amountInput;
    Button sendButton;
    int currbal_from;
    int currbal_to;
    String name_from;
    String name_to;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_payment);

        if(getIntent().hasExtra("Rcurrbal")&&getIntent().hasExtra("Rname")) {
            currbal_from= Integer.parseInt(getIntent().getStringExtra("Rcurrbal"));
            name_from= getIntent().getStringExtra("Rname");
        }
        List<String> list = new ArrayList<>();
        list.add("Click to select");
        list.add("Aayushi Bhat");
        list.add("Ajay Sharma");
        list.add("Dhruv Patel");
        list.add("Maya Saxena");
        list.add("Paul Mathews");
        list.add("Pranav Mittal");
        list.add("Priya Kapoor");
        list.add("Rohan Yadav");
        list.add("Simran Singh");
        list.add("Tanya Advani");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner =(Spinner)findViewById(R.id.spinner);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                name_to =spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        sendButton = (Button)findViewById(R.id.sendbtn);
        sendButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                amountInput=findViewById(R.id.amount);
                amount = Integer.parseInt(amountInput.getText().toString());
                Log.d("MP","amount to be sent:"+amount+" to: "+name_to+" current bal:"+currbal_from);
                if (amount>currbal_from){
                    Toast.makeText(getApplicationContext(),"Insufficient Balance",Toast.LENGTH_SHORT).show();
                }
                else if(name_to.equals("Click to select")){
                    Toast.makeText(getApplicationContext(),"Select a valid option",Toast.LENGTH_SHORT).show();
                }
                else if(name_to.equals(name_from)){
                    Toast.makeText(getApplicationContext(),"Sender and receiver cannot be the same person",Toast.LENGTH_LONG).show();
                }
                else {
                    int new_currbal_from = currbal_from - amount;
                    Log.d("MP","new current bal:"+currbal_from);
                    MyDbHandler db = new MyDbHandler(MakePayment.this);
                    db.update(name_from,new_currbal_from,name_to,amount);
                    Toast.makeText(getApplicationContext(),"Transaction Successful",Toast.LENGTH_SHORT).show();
                    //Add something
                    Intent i = getBaseContext().getPackageManager()
                            .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }

            }
        });

    }


}
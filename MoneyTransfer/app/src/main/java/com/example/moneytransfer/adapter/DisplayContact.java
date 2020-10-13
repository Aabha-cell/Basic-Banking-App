package com.example.moneytransfer.adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.moneytransfer.R;

public class DisplayContact extends AppCompatActivity implements View.OnClickListener {

    private Button viewTransactionsBtn;
    private Button makePaymentBtn;
    private String currbal;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contact);

        viewTransactionsBtn = findViewById(R.id.viewTransactionsBtn);
        viewTransactionsBtn.setOnClickListener(this);
        makePaymentBtn = findViewById(R.id.makePaymentBtn);
        makePaymentBtn.setOnClickListener(this);


        if((getIntent().hasExtra("Rname")&&getIntent().hasExtra("Rphone"))
                &&(getIntent().hasExtra("Remail")&&getIntent().hasExtra("Rcurrbal"))){

            name = getIntent().getStringExtra("Rname");
            String phone = getIntent().getStringExtra("Rphone");
            String email = getIntent().getStringExtra("Remail");
            currbal = String.valueOf(getIntent().getIntExtra("Rcurrbal", 0));
            Log.d("DC"," "+currbal+name);

           display(name,phone,email,currbal);
        }
    }

    private void display(String name, String phone, String email, String currbal) {
        TextView nameTextView = findViewById(R.id.displayName);
        nameTextView.setText(name);
        TextView phoneTextView = findViewById(R.id.displayPhone);
        phoneTextView.setText(phone);
        TextView emailTextView = findViewById(R.id.displayEmail);
        emailTextView.setText(email);
        TextView currbalTextView = findViewById(R.id.displayBalance);
        currbalTextView.setText(currbal);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.makePaymentBtn:{
                Log.d("payment btn worked","payment btn clicked");
                Intent intent = new Intent(this, MakePayment.class);
                intent.putExtra("Rcurrbal",currbal);
                intent.putExtra("Rname",name);
                startActivity(intent);
                break;
            }
            case R.id.viewTransactionsBtn:{
                Log.d("Transaction btn worked","transaction btn clicked");
                Intent intent = new Intent(this, ViewTransaction.class);
                intent.putExtra("Rname",name);
                startActivity(intent);
                break;
            }
        }

    }
}
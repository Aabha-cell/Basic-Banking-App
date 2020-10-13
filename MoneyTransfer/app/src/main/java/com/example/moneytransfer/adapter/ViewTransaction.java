package com.example.moneytransfer.adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.moneytransfer.R;
import com.example.moneytransfer.data.MyDbHandler;
import com.example.moneytransfer.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ViewTransaction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_transaction);
        ListView listView;
        listView = findViewById(R.id.listView);

        ArrayList<String> transactions = new ArrayList<>();
        MyDbHandler db = new MyDbHandler(ViewTransaction.this);
        List<Transaction> transactionList= db.getAllTransactions();
        for (Transaction transaction: transactionList){
            if(getIntent().hasExtra("Rname")) {
                String name_sender = getIntent().getStringExtra("Rname");
                if(name_sender.equals(transaction.getSender())||name_sender.equals(transaction.getReceiver())){
                    transactions.add("From: "+transaction.getSender()+"\nTo: "+transaction.getReceiver()+"\nAmount: "+ transaction.getAmount()+"\nTime:"+transaction.getDatetime());
                    //Log.d("HELLO","Name: "+ transaction.getSender()+"\n");
                }
            }

        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,transactions);
        listView.setAdapter(arrayAdapter);

    }
}
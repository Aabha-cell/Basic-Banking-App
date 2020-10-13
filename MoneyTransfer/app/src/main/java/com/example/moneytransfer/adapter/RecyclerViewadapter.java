package com.example.moneytransfer.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moneytransfer.R;
import com.example.moneytransfer.model.Contact;

import java.util.List;

public class RecyclerViewadapter extends RecyclerView.Adapter <RecyclerViewadapter.ViewHolder>{

    private Context context;
    private List<Contact> contactList;

    public RecyclerViewadapter(Context context, List<Contact> contactList){
        this.context = context;
        this.contactList = contactList;
    }

    //Where to get single card as viewholder object
    @NonNull
    @Override
    public RecyclerViewadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new ViewHolder(view);
    }

    //What will happen when we create viewholder object
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewadapter.ViewHolder holder, int position) {
        Contact contact = contactList.get(position);
        holder.contactName.setText(contact.getName());

    }

    //How many items
    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView contactName;
        public ImageView iconButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            contactName = itemView.findViewById(R.id.name);
            iconButton = itemView.findViewById(R.id.icon);
            iconButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Log.d("ClickedfromViewHolder","Clicked");
            int position = this.getAdapterPosition();
            Contact contact = contactList.get(position);
            String name = contact.getName();
            String phone = contact.getPhoneNumber();
            String email = contact.getEmail();
            int currbal = contact.getBalance();

            Intent intent = new Intent(context, DisplayContact.class);
            intent.putExtra("Rname",name);
            intent.putExtra("Rphone",phone);
            intent.putExtra("Remail",email);
            intent.putExtra("Rcurrbal",currbal);
            context.startActivity(intent);

        }
    }
}

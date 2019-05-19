package com.google.ali.savelife.RecyclerAdapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.ali.savelife.Activities.request_detail;
import com.google.ali.savelife.R;
import com.google.ali.savelife.model_classes.User_request;

import java.util.ArrayList;

public class CustomADP extends RecyclerView.Adapter<CustomADP.myviewholder> {
    Context context;
    ArrayList<User_request> myarray;

    public CustomADP(ArrayList<User_request> myarray, Context context) {
        this.context = context;
        this.myarray = myarray;
        if (this.myarray == null) {
            Log.d("ALI", "CustomADP: data recieved");
        }
    }


    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new myviewholder(LayoutInflater.from(viewGroup.getContext()
        ).inflate(R.layout.custom_request, viewGroup, false));

    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder myviewholder, final int i) {
        User_request objUser_request = myarray.get(i);
        myviewholder.name.setText(objUser_request.getName());
        myviewholder.contact.setText(objUser_request.getContact());
        myviewholder.city.setText(objUser_request.getCity());
        myviewholder.type.setText(objUser_request.getType());
        //  myviewholder.unit.setText(objUser_request.getUnit());
        myviewholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context,request_detail.class);
                intent.putExtra("temp",myarray.get(i));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return myarray.size();
    }

    static class myviewholder extends RecyclerView.ViewHolder {
        TextView name, contact, city, type;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_req_name);
            contact = itemView.findViewById(R.id.tv_req_contact);
            city = itemView.findViewById(R.id.tv_req_city);
            type = itemView.findViewById(R.id.tv_req_type);

        }
    }
}

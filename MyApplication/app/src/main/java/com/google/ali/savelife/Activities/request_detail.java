package com.google.ali.savelife.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.ali.savelife.R;
import com.google.ali.savelife.model_classes.User_request;

public class request_detail extends AppCompatActivity {

    TextView name,contact,detail,unit,type,city;
    String st_name,st_contact,st_detail,st_unit,st_type,st_city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_detail);
        registerviews();
        getintentdata();
        Toast.makeText(this, ""+st_name+" "+st_type, Toast.LENGTH_SHORT).show();
        setviews();


    }
    void registerviews()
    {
        name=findViewById(R.id.tv_detail_name);
        contact=findViewById(R.id.tv_detail_contact);
        detail=findViewById(R.id.tv_detail_description);
        unit=findViewById(R.id.tv_detail_unit);
        type=findViewById(R.id.tv_detail_type);
        city=findViewById(R.id.tv_detail_city);
    }
    void getintentdata()
    {
        Intent i = getIntent();
        User_request ur = (User_request) i.getExtras().getSerializable("temp");
        st_name=ur.getName();
        st_contact=ur.getContact();
        st_detail=ur.getDetail();
        st_unit=String.valueOf(ur.getUnit());
        st_type=ur.getType();
        st_city=ur.getCity();
    }
    void setviews()
    {
        name.setText(st_name);
        contact.setText(st_contact);
        detail.setText(st_detail);
        unit.setText(st_unit);
        type.setText(st_type);
        city.setText(st_city);
    }

}

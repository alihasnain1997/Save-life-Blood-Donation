package com.google.ali.savelife.Activities;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.ali.savelife.R;
import com.google.ali.savelife.RecyclerAdapter.CustomADP;
import com.google.ali.savelife.dbhelper_classes.DBhelper;
import com.google.ali.savelife.model_classes.User;
import com.google.ali.savelife.model_classes.User_request;

import java.util.ArrayList;

public class myrequest extends AppCompatActivity {

    RecyclerView rv_request;
    ArrayList<User_request> myarray;
    CustomADP recycler;
    DBhelper objDBhelper;
    User objuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myrequest);
        objDBhelper = new DBhelper(this);
        objuser = User.getInstance();
        String id = String.valueOf(objuser.getId());
        rv_request = findViewById(R.id.rv_myrequest);
        viewmyrequest(id);


    }

    public void viewmyrequest(String id) {

        myarray = objDBhelper.getAllrequest(id, "=");
        if (myarray == null || myarray.size() == 0) {
            Toast.makeText(this, "Nothing in cursor", Toast.LENGTH_SHORT).show();
            return;

        } else {
            recycler = new CustomADP(myarray, myrequest.this);
            rv_request.setLayoutManager(new LinearLayoutManager(this));
            rv_request.setAdapter(recycler);

        }


    }
}


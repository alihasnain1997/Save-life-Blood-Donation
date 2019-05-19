package com.google.ali.savelife.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.ali.savelife.R;
import com.google.ali.savelife.dbhelper_classes.DBhelper;
import com.google.ali.savelife.model_classes.User;
import com.google.gson.Gson;

public class sign_in extends AppCompatActivity implements View.OnClickListener {

    EditText username_input,password_input;
    TextView sign_up;
    Button sign_in;
    DBhelper objDBhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        RegisterViews();
        objDBhelper=new DBhelper(this);
        sign_in.setOnClickListener(this);
        sign_up.setOnClickListener(this);
    }
    void RegisterViews()
    {
        username_input=findViewById(R.id.et_username_input);
        password_input=findViewById(R.id.et_password_input);
        sign_up=findViewById(R.id.link_signup);
        sign_in=findViewById(R.id.btn_login);

    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.btn_login)
        {
            sign_in();
            //Toast.makeText(this, "Login Button", Toast.LENGTH_SHORT).show();
        }
        if(v.getId()==R.id.link_signup)
        {
            sign_up();
          //  Toast.makeText(this, "Sign up button clicked", Toast.LENGTH_SHORT).show();
        }
    }

    public void sign_in()
    {
        User objuser=new User();
        Boolean flag = false;
        String username = username_input.getText().toString().trim();
        String password = password_input.getText().toString().trim();
        if (username.isEmpty())
        {
            Toast.makeText(this, "Please Enter User name", Toast.LENGTH_SHORT).show();
        }
        else if (password.isEmpty())
        {
            Toast.makeText(this, "Please Enter Password", Toast.LENGTH_SHORT).show();
        }
        else
        {
           // startActivity(new Intent(sign_in.this,Main2Activity.class));
            try {
                objuser= objDBhelper.getUser(username);
                if (objuser==null || !objuser.getPassword().equals(password))
                {
                    Toast.makeText(this, "Email or Password is incorrect.", Toast.LENGTH_SHORT).show();
                }
                else {

                        User.setInstance(getApplicationContext(),objuser);



                        Intent i = new Intent(sign_in.this, Main2Activity.class);
                        startActivity(i);
                        finish();
                    }
            }
            catch (Exception e)
            {
                Toast.makeText(this, "Excpetion in sigin"+e, Toast.LENGTH_SHORT).show();
            }

        }
    }

    public void sign_up()
    {
        startActivity(new Intent(sign_in.this,sign_up.class));
        finish();
    }
}

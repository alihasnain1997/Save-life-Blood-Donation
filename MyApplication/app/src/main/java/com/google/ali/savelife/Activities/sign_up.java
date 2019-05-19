package com.google.ali.savelife.Activities;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.ali.savelife.R;
import com.google.ali.savelife.dbhelper_classes.DBhelper;

public class sign_up extends AppCompatActivity implements View.OnClickListener {

    DBhelper objDBhelper;
    EditText username_signup,email__signup,password__signup,contact__signup,city_signup;
    TextView sign_in_link;
    RadioGroup radioGroup;
    Button btn_sign_up;
    String blood_type="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        RegisterViews();
        objDBhelper = new DBhelper(this);
        btn_sign_up.setOnClickListener(this);
        sign_in_link.setOnClickListener(this);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.A_neg:
                        blood_type="A-";
                        break;
                    case R.id.A_pos:
                        blood_type="A+";
                        break;
                    case R.id.AB_neg:
                        blood_type="AB-";
                        break;
                    case R.id.AB_pos:
                        blood_type="AB+";
                        break;
                    case R.id.B_neg:
                        blood_type="B-";
                        break;
                    case R.id.B_pos:
                        blood_type="B+";
                        break;
                    case R.id.O_neg:
                        blood_type="O-";
                        break;
                    case R.id.O_pos:
                        blood_type="O+";
                        break;
                }
            }
        });
    }
    void RegisterViews()
    {
        username_signup=findViewById(R.id.et_username_signup);
        email__signup=findViewById(R.id.et_email_signup);
        password__signup=findViewById(R.id.et_password_signup);
        contact__signup=findViewById(R.id.et_contact_signup);
        city_signup=findViewById(R.id.et_location_signup);
        btn_sign_up=findViewById(R.id.btn_signup);
        radioGroup=findViewById(R.id.radiogroup);
        sign_in_link=findViewById(R.id.link_login);
    }
    void sign_up_user()
    {
        String username,password,email,contact,city;
        username=username_signup.getText().toString().trim();
        email=email__signup.getText().toString().trim();
        password=password__signup.getText().toString().trim();
        contact=contact__signup.getText().toString().trim();
        city=city_signup.getText().toString().trim();
        if (username.isEmpty()||password.isEmpty()||email.isEmpty()||contact.isEmpty()
        ||blood_type.isEmpty()||city.isEmpty())
        {
            Toast.makeText(this, "Please Enter All Fields", Toast.LENGTH_SHORT).show();
        }
        else
        {
                objDBhelper.insert_user(username,email,password,contact,blood_type,city);

        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_signup)
        {
            sign_up_user();
            //Toast.makeText(this, "SignUp btn clicked", Toast.LENGTH_SHORT).show();
            //  Toast.makeText(this, "this is blood type"+blood_type, Toast.LENGTH_SHORT).show();
        }
        if (v.getId()==R.id.link_login)
        {
            startActivity(new Intent(sign_up.this,sign_in.class));
            finish();
        }


    }
}

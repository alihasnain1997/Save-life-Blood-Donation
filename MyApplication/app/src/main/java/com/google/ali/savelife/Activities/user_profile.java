package com.google.ali.savelife.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.ali.savelife.R;
import com.google.ali.savelife.model_classes.User;

public class user_profile extends AppCompatActivity {



    TextView username,email,contact,blood_type;
    Button btn_edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        Registerviews();
                btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(user_profile.this,update_user.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        setHomeViews();
    }

    void Registerviews()
    {
        username=findViewById(R.id.tv_username_profile);
        email=findViewById(R.id.tv_email_profile);
        contact=findViewById(R.id.tv_contact_profile);
        blood_type=findViewById(R.id.tv_bloodgroup_profile);
        btn_edit=findViewById(R.id.btn_edit_profile);

    }

    void setvalues(String user_name,String user_email,String user_contact,String user_btype)
    {
        username.setText(user_name);
        email.setText(user_email);
        contact.setText(user_contact);
        blood_type.setText(user_btype);

    }

    void setHomeViews() {

        User objuser=User.getInstance();
        setvalues(objuser.getName(),objuser.getEmail(),objuser.getContact(),objuser.getBlood());
    }
}


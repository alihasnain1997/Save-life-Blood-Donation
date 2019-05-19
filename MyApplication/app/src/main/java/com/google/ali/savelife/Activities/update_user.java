package com.google.ali.savelife.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.ali.savelife.R;
import com.google.ali.savelife.dbhelper_classes.DBhelper;
import com.google.ali.savelife.model_classes.User;

public class update_user extends AppCompatActivity {
    User objuser;
    String blood_type = "";
    EditText username, email, password, contact, city;
    RadioGroup rg;
    DBhelper objdbhelper;
    Button btn_update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);
        objuser = User.getInstance();
        RegisterViews();
        setviews();
        objdbhelper = new DBhelper(this);
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btn_update) {
                    Update_user();
                }
            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.A_neg:
                        blood_type = "A-";
                        break;
                    case R.id.A_pos:
                        blood_type = "A+";
                        break;
                    case R.id.AB_neg:
                        blood_type = "AB-";
                        break;
                    case R.id.AB_pos:
                        blood_type = "AB+";
                        break;
                    case R.id.B_neg:
                        blood_type = "B-";
                        break;
                    case R.id.B_pos:
                        blood_type = "B+";
                        break;
                    case R.id.O_neg:
                        blood_type = "O-";
                        break;
                    case R.id.O_pos:
                        blood_type = "O+";
                        break;
                }
            }
        });

    }

    void RegisterViews() {
        username = findViewById(R.id.et_username_update);
        email = findViewById(R.id.et_email_update);
        password = findViewById(R.id.et_password_update);
        contact = findViewById(R.id.et_contact_update);
        city = findViewById(R.id.et_location_update);
        btn_update = findViewById(R.id.btn_update);
        rg = findViewById(R.id.radiogroup_update);
    }

    void setviews() {
        username.setText(objuser.getName());
        email.setText(objuser.getEmail());
        password.setText(objuser.getPassword());
        contact.setText(objuser.getContact());
        city.setText(objuser.getCity());
    }


    void Update_user() {
        String name, pass, mail, num, place;
        name = username.getText().toString().trim();
        mail = email.getText().toString().trim();
        pass = password.getText().toString().trim();
        num = contact.getText().toString().trim();
        place = city.getText().toString().trim();
        if (name.isEmpty() || pass.isEmpty() || mail.isEmpty() || num.isEmpty()
                || blood_type.isEmpty() || place.isEmpty()) {
            Toast.makeText(this, "Please Enter All Fields", Toast.LENGTH_SHORT).show();
        } else {
            objdbhelper.updateuser(String.valueOf(objuser.getId()), name, mail, pass, num, blood_type, place);
            User user = new User(objuser.getId(), name, mail, pass, num, blood_type, place);
            User.setInstance(getApplicationContext(),user);
            finish();
        }
    }


}

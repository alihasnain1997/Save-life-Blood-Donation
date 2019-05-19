package com.google.ali.savelife.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.ali.savelife.R;
import com.google.ali.savelife.dbhelper_classes.DBhelper;
import com.google.ali.savelife.model_classes.User;

public class add_request extends AppCompatActivity implements View.OnClickListener{


    DBhelper objDBhelper;

    RadioGroup radioGroup;
    EditText unit_req,details;
    String blood_type="";
    Button add_req;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_request);
        objDBhelper=new DBhelper(this);

        RegisterViews();
        add_req.setOnClickListener(this);
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
        radioGroup=findViewById(R.id.radiogroup_req);
        unit_req=findViewById(R.id.et_req_units);
        details=findViewById(R.id.et_detail_request);
        add_req=findViewById(R.id.btn_add_req);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btn_add_req)
        {
            Integer result = Integer.valueOf(unit_req.getText().toString().trim());
            User objuser=User.getInstance();
            objDBhelper.insert_request(objuser.getId(),result,blood_type,details.getText().toString().trim());
        }

    }
}

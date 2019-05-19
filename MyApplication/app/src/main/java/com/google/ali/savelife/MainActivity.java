package com.google.ali.savelife;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.ali.savelife.Activities.Main2Activity;
import com.google.ali.savelife.Activities.sign_in;
import com.google.ali.savelife.dbhelper_classes.DBhelper;
import com.google.ali.savelife.model_classes.User;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        create_db();
        timer();
    }
    public void create_db() {
        try {
            (new DBhelper(this)).getWritableDatabase();
            Log.d("DB_REQ", "create_DBrequest: sadas");
        }
        catch(Exception e)
        {
            Toast.makeText(this, "error at myrequest" + e, Toast.LENGTH_SHORT).show();
        }
    }

    public void timer() {
        final CountDownTimer timer = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }


            @Override
            public void onFinish() {
                Intent i;
                SharedPreferences sp = getApplicationContext().getSharedPreferences("savelife", MODE_PRIVATE);
                String userData = sp.getString("user", "");
                if (userData.equals("")) {
                  i   = new Intent(MainActivity.this, sign_in.class);
                }
                else {
                    Gson gson=new Gson();
                    User user = gson.fromJson(userData, User.class);
                    User.setInstance(getApplicationContext(),user);
                    i   = new Intent(MainActivity.this, Main2Activity.class);
                }
                startActivity(i);
                finish();
            }
        }.start();
    }


}

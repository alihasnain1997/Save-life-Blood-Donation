package com.google.ali.savelife.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.google.ali.savelife.R;
import com.google.ali.savelife.RecyclerAdapter.CustomADP;
import com.google.ali.savelife.dbhelper_classes.DBhelper;
import com.google.ali.savelife.model_classes.User;
import com.google.ali.savelife.model_classes.User_request;

import java.util.ArrayList;

public class all_request extends AppCompatActivity {

    RecyclerView rv_request;
    ArrayList<User_request> myarray;
    CustomADP recycler;
    DBhelper objDBhelper;
    User objuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_request);
        rv_request = findViewById(R.id.rv_request);
        objuser = User.getInstance();
        objDBhelper = new DBhelper(this);
        String id = String.valueOf(objuser.getId());
        viewallrequest(id);

        Log.d("king", "onCreate: all Request ");

    }

    public void viewallrequest(String id) {


//        String message = "";
        myarray = objDBhelper.getAllrequest(id,"!=");
//        StringBuffer objStringBuffer = new StringBuffer();
        if (myarray == null || myarray.size() == 0) {
            Toast.makeText(this, "Nothing in cursor", Toast.LENGTH_SHORT).show();
            return;

        } else {
            recycler = new CustomADP(myarray, all_request.this);
            rv_request.setLayoutManager(new LinearLayoutManager(this));
            rv_request.setAdapter(recycler);
       //     Toast.makeText(this, myarray.size(), Toast.LENGTH_LONG).show();

        }


    }
        /*try{
            Cursor crs = objDBhelper.getAllrequest(id);
            StringBuffer objStringBuffer = new StringBuffer();
            if (crs.getCount() <0) {
                Toast.makeText(this, "Nothing in cursor", Toast.LENGTH_SHORT).show();
                return;
            } else {
                while (crs.moveToNext()) {

                    myarray.add(new User_request(crs.getString(1), crs.getString(2),
                            crs.getString(6), crs.getString(5),
                            crs.getString(3), Integer.valueOf(crs.getString(0))
                            , Integer.valueOf(crs.getString(4)),
                            Integer.valueOf(crs.getString(7))));

                }

            }
        }
        catch (Exception e)
        {
            Toast.makeText(this, "Exception at ALL REQuest \n" + e, Toast.LENGTH_LONG).show();
        }

}
*/
}
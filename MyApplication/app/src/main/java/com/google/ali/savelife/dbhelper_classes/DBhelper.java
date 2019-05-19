package com.google.ali.savelife.dbhelper_classes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.google.ali.savelife.model_classes.Request;
import com.google.ali.savelife.model_classes.User;
import com.google.ali.savelife.model_classes.User_request;

import java.util.ArrayList;

public class DBhelper extends SQLiteOpenHelper {


    public static final String DB_NAME = "user.db";
    public static final int DB_VERSION = 1;
    Context context;

    public DBhelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
        Log.d("ALI", "onCreate: this is db inside");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            Log.d("ALI", "onCreate: this is db inside");
            db.execSQL("CREATE TABLE IF NOT EXISTS 'user_detail' ( 'id' INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,'name'	TEXT NOT NULL,'email' TEXT NOT NULL UNIQUE, 'password'	TEXT NOT NULL, 'contact' TEXT NOT NULL UNIQUE, 'blood'	TEXT NOT NULL, 'city'	TEXT NOT NULL)");
            db.execSQL("CREATE TABLE IF NOT EXISTS 'request_detail' ( 'id' INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,'user_id' INTEGER NOT NULL,'unit' INTEGER NOT NULL, 'blood' TEXT NOT NULL,'detail' TEXT NOT NULL)");
            Toast.makeText(context, "DB succesfully created", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(context, "THis is database" + e, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public Cursor getAllUsers() {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            if (db != null) {
                String query = "SELECT * FROM user_detail";
                Cursor cr = db.rawQuery(query, null);
                return cr;
            } else {
                Toast.makeText(context, "DB is empty", Toast.LENGTH_SHORT).show();
            }

        } catch (Exception e) {
            Toast.makeText(context, "error in retrieving data", Toast.LENGTH_SHORT).show();
            Cursor cr = null;
            return cr;
        }

        return null;
    }

    public User getUser(String email) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            if (db != null) {
                String query = String.format("SELECT * FROM user_detail where email = \"%s\"", email);

                Cursor cr = db.rawQuery(query, null);
                if (cr.getCount() == 0) return null;
                cr.moveToNext();
                return new User(cr.getInt(0), cr.getString(1), cr.getString(2),
                        cr.getString(3), cr.getString(4),
                        cr.getString(5), cr.getString(6));
            } else {
                Toast.makeText(context, "DB is empty", Toast.LENGTH_SHORT).show();
            }

        } catch (Exception e) {
            Toast.makeText(context, "error in retrieving data", Toast.LENGTH_SHORT).show();
            return null;
        }

        return null;
    }

    public void updateuser(String id, String name, String email, String password, String contact, String blood, String city) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        try {
            contentValues.put("id", id);
            contentValues.put("name", name);
            contentValues.put("email", email);
            contentValues.put("password", password);
            contentValues.put("contact", contact);
            contentValues.put("blood", blood);
            contentValues.put("city", city);
            long result = db.update("user_detail", contentValues, "id=" + id, null);
            if (result == -1) {
                Toast.makeText(context, "Failed to Update Data", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Data Updated succesffuly", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(context, "Update user error" + e, Toast.LENGTH_SHORT).show();
        }

    }


    public void insert_user(String name, String email, String password, String contact, String blood, String city) {
        try {

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", name);
            contentValues.put("email", email);
            contentValues.put("password", password);
            contentValues.put("contact", contact);
            contentValues.put("blood", blood);
            contentValues.put("city", city);
            long result = db.insert("user_detail", null, contentValues);
            if (result == -1) {
                Toast.makeText(context, "Failed to Insert Data", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Data Inserted succesffuly", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(context, "insert new user error" + e, Toast.LENGTH_SHORT).show();
        }

    }


    public void insert_request(int id, int unit, String blood, String detail) {
        try {

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("user_id", id);
            contentValues.put("unit", unit);
            contentValues.put("blood", blood);
            contentValues.put("detail", detail);
            long result = db.insert("request_detail", null, contentValues);
            if (result == -1) {
                Toast.makeText(context, "Failed to Insert Data", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Data Inserted succesffuly", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(context, "insert new user error" + e, Toast.LENGTH_SHORT).show();
        }

    }

    public void updaterequest(int id, int user_id, int unit, String blood, String detail) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        try {
            contentValues.put("id", id);
            contentValues.put("user_id", user_id);
            contentValues.put("unit", unit);
            contentValues.put("blood", blood);
            contentValues.put("detail", detail);
            long result = db.update("request_detail", contentValues, "id=" + id, null);
            if (result == -1) {
                Toast.makeText(context, "Failed to Update Data", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Data Updated succesffuly", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(context, "Update user error" + e, Toast.LENGTH_SHORT).show();
        }

    }

    /*
        String name,contact,detail,type,city;
        int id,req_id,unit;*/
    public ArrayList<User_request> getAllrequest(String id ,String p) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            if (db != null) {
                String query = String.format("SELECT u.id as u_id, u.name as name , u.contact as contact, " +
                        "u.city as city, r.id as r_id, r.blood as type, r.detail as detail ," +
                        "r.unit as unit FROM user_detail u INNER JOIN request_detail r " +
                        "ON u.id=r.user_id where r.user_id %s %s ;",p,id);
                //       String query = "SELECT * from  request_detail;";
                Cursor cr = db.rawQuery(query, null);
                ArrayList<User_request> requestArrayList = new ArrayList<>();
                while (cr.moveToNext()) {
                    User_request r = new User_request(
                            cr.getString(1), //name
                            cr.getString(2), //contact
                            cr.getString(6), //detail
                            cr.getString(5), //blood
                            cr.getString(3), //city
                            cr.getInt(0), //uid
                            cr.getInt(4), //rid
                            cr.getInt(7) //unit
                    );
                    requestArrayList.add(r);
                }
                return requestArrayList;
            } else {
                Toast.makeText(context, "DB is empty", Toast.LENGTH_SHORT).show();
            }

        } catch (Exception e) {
            Toast.makeText(context, "error in retrieving data", Toast.LENGTH_SHORT).show();
            return null;

        }

        return null;
    }


    public ArrayList<Request> getrequest(String user_id) {
        try {
            ArrayList<Request> myarray = new ArrayList<>();
            SQLiteDatabase db = this.getWritableDatabase();
            if (db != null) {
                String query = String.format("SELECT * FROM request_detail where user_id = \"%s\"", user_id);

                Cursor cr = db.rawQuery(query, null);
                if (cr.getCount() == 0) return null;
                cr.moveToNext();
                myarray.add(new Request(cr.getInt(0), cr.getInt(1), cr.getInt(2)
                        , cr.getString(3), cr.getString(4)));
                return myarray;
            } else {
                Toast.makeText(context, "DB is empty", Toast.LENGTH_SHORT).show();
            }

        } catch (Exception e) {
            Toast.makeText(context, "error in retrieving data", Toast.LENGTH_SHORT).show();
            return null;
        }

        return null;
    }


}


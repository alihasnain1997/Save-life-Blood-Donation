package com.google.ali.savelife.model_classes;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import static android.content.Context.MODE_PRIVATE;

public class User {

    public static User userobj;
    int id;
    String name, email, password, contact, blood, city;

    public User() {
    }

    public User(int id, String name, String email, String password, String contact, String blood, String city) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.contact = contact;
        this.blood = blood;
        this.city = city;
    }

    public User(String name, String email, String password, String contact, String blood, String city) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.contact = contact;
        this.blood = blood;
        this.city = city;
    }

    public static User getInstance() {
        if (userobj == null)
            userobj = new User();
        return userobj;
    }
    public static void setInstance(Context c, User u) {
        userobj = u;
        Gson gson = new Gson();
        String json = gson.toJson(u);

        SharedPreferences sp = c.getSharedPreferences("savelife", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        editor.putString("user", json);
        editor.apply();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
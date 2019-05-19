package com.google.ali.savelife.model_classes;

public class Request {

    int id,user_id,unit;
    String blood,details;

    public Request(int id, int user_id, int unit, String blood, String details) {
        this.id = id;
        this.user_id = user_id;
        this.unit = unit;
        this.blood = blood;
        this.details = details;
    }

    public Request(int user_id, int unit, String blood, String details) {
        this.user_id = user_id;
        this.unit = unit;
        this.blood = blood;
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}


package com.google.ali.savelife.model_classes;

import java.io.Serializable;

public class User_request implements Serializable {
    String name,contact,detail,type,city;
    int id,req_id,unit;


    public User_request(String name, String contact, String detail, String type, String city, int id, int req_id, int unit) {
        this.name = name;
        this.contact = contact;
        this.detail = detail;
        this.type = type;
        this.city = city;
        this.id = id;
        this.req_id = req_id;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReq_id() {
        return req_id;
    }

    public void setReq_id(int req_id) {
        this.req_id = req_id;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }



}
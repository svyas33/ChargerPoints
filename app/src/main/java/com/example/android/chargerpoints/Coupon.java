package com.example.android.chargerpoints;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by 17svyas on 12/8/2016.
 */

public class Coupon extends RealmObject {

    @PrimaryKey
    private int id;
    private String companyName;
    private String description;
    private String couponValue;
    private int pts;
    private int picImageResourceId;
    private int qrImageResourceId;
    private String category;


    public int getId() {
        return id;
    }

    public void setId(int couponId) {
        this.id = couponId;
    }

    public String getCompanyName(){ return companyName; }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDescription(){ return description; }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCouponValue(){ return couponValue; }

    public void setCouponValue(String couponValue) {
        this.couponValue = couponValue;
    }

    public int getPts(){ return pts; }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public int getPicImageResourceId(){ return picImageResourceId; }

    public void setPicImageResourceId(int picImageResourceId) {
        this.picImageResourceId = picImageResourceId;
    }

    public int getQrImageResourceId(){ return qrImageResourceId; }

    public void setQrImageResourceId(int qrImageResourceId) {
        this.qrImageResourceId = qrImageResourceId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}

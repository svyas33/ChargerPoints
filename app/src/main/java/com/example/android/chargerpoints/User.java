package com.example.android.chargerpoints;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by ShivaniVyas on 4/17/17.
 */

public class User extends RealmObject {

    @PrimaryKey
    private String email;
    private String password;
    private RealmList<Coupon> allCoupons;
    private RealmList<Coupon> foodCoupons;
    private RealmList<Coupon> entertainmentCoupons;
    private RealmList<Coupon> otherCoupons;
    private RealmList<Coupon> redeemedCoupons;
    private int points;
    private boolean isLoggedIn = false;

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
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

    public RealmList<Coupon> getAllCoupons() {
        return allCoupons;
    }

    public void setAllCoupons(RealmList<Coupon> allCoupons) {
        this.allCoupons = allCoupons;
    }

    public RealmList<Coupon> getFoodCoupons() {
        return foodCoupons;
    }

    public void setFoodCoupons(RealmList<Coupon> foodCoupons) {
        this.foodCoupons = foodCoupons;
    }

    public RealmList<Coupon> getEntertainmentCoupons() {
        return entertainmentCoupons;
    }

    public void setEntertainmentCoupons(RealmList<Coupon> entertainmentCoupons) {
        this.entertainmentCoupons = entertainmentCoupons;
    }

    public RealmList<Coupon> getOtherCoupons() {
        return otherCoupons;
    }

    public void setOtherCoupons(RealmList<Coupon> otherCoupons) {
        this.otherCoupons = otherCoupons;
    }

    public RealmList<Coupon> getRedeemedCoupons() {
        return redeemedCoupons;
    }

    public void setRedeemedCoupons(RealmList<Coupon> redeemedCoupons) {
        this.redeemedCoupons = redeemedCoupons;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void removeFromRedeemedCoupons(Coupon coupon) {
        this.redeemedCoupons.remove(coupon);
    }

    public void removeFromFoodCoupons(Coupon coupon) {
        this.foodCoupons.remove(coupon);
    }

    public void removeFromEntertainmentCoupons(Coupon coupon) {
        this.foodCoupons.remove(coupon);
    }

    public void removeFromOtherCoupons(Coupon coupon) {
        this.foodCoupons.remove(coupon);
    }

    public void addToRedeemedCoupons(Coupon coupon) {
        this.redeemedCoupons.add(coupon);
    }
}

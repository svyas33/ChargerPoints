package com.example.android.chargerpoints;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmList;

public class LogonActivity extends AppCompatActivity {

    Realm realm;

    private User user;

    private String email;
    private String password;
    private String userId;

    private EditText emailEditText;
    private EditText passwordEditText;

    private Button signInButton;
    private String signInTxt;
    private Button registerButton;
    private String registerTxt;
    private Button forgotPasswordButton;

    private RealmList<Coupon> allCoupons = new RealmList<>();
    private RealmList<Coupon> foodCoupons = new RealmList<>();
    private RealmList<Coupon> entCoupons = new RealmList<>();
    private RealmList<Coupon> otherCoupons = new RealmList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logon);

        realm = Realm.getDefaultInstance();

        emailEditText = (EditText) findViewById(R.id.email);
        passwordEditText = (EditText) findViewById(R.id.password);

        signInButton = (Button) findViewById(R.id.signin_button);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signInTxt = signIn();
                Toast.makeText(LogonActivity.this, signInTxt,
                        Toast.LENGTH_LONG).show();
                if (signInTxt.equals("Successfully signed in!")) {
                    realm.beginTransaction();
                    user.setLoggedIn(true);
                    realm.copyToRealmOrUpdate(user);
                    realm.commitTransaction();
                    Intent i = new Intent();
                    i.setClass(LogonActivity.this, MainActivity.class);
                    startActivity(i);
                }
            }
        });

        registerButton = (Button) findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerTxt = register();
                Toast.makeText(LogonActivity.this, registerTxt,
                        Toast.LENGTH_LONG).show();
                if (registerTxt.equals("Successfully registered!")) {
                    realm.beginTransaction();
                    user.setLoggedIn(true);
                    realm.copyToRealmOrUpdate(user);
                    realm.commitTransaction();
                    Intent intent = new Intent();
                    intent.setClass(LogonActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        forgotPasswordButton = (Button) findViewById(R.id.forgot_password_button);
        //Adding click listener
        forgotPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    sendEmail();
            }

        });
    }

    private void sendEmail() {

        if (isEmpty(emailEditText)) {
            emailEditText.requestFocus();
            emailEditText.selectAll();
            Toast.makeText(LogonActivity.this, "Please enter an SHS email",
                    Toast.LENGTH_LONG).show();
            return;
        } else {
            if (emailEditText.getText().toString().contains("@spsd.us")) {
                email = String.valueOf(emailEditText.getText());
            } else {
                emailEditText.requestFocus();
                emailEditText.selectAll();
                Toast.makeText(LogonActivity.this, "Please enter a valid SHS email",
                        Toast.LENGTH_LONG).show();
                return;
            }
        }

        //Get user email from field in email spot
        String email = emailEditText.getText().toString().trim();

        //Email subject
        String subject = "ChargerPoints Password Retrieval";

        user = realm.where(User.class).equalTo("email", email).findFirst();

        String message;
        if(user != null) {
            //Write message
            message = "Your password for the ChargerPoints app is: " + user.getPassword();
        }
        else {
            Toast.makeText(LogonActivity.this, "User does not exist. Please register",
                    Toast.LENGTH_LONG).show();
            return;
        }
        //Creating SendMail object
        SendMail sm = new SendMail(this, email, subject, message);

        //Executing sendmail to send email
        sm.execute();
    }

    public String signIn() {
        if (isEmpty(emailEditText)) {
            emailEditText.requestFocus();
            emailEditText.selectAll();
            return "Please enter an email";

        } else {
            if (emailEditText.getText().toString().contains("@spsd.us")) {
                email = String.valueOf(emailEditText.getText());
            } else {
                emailEditText.requestFocus();
                emailEditText.selectAll();
                return "Please enter a valid email";
            }
        }

        if (isEmpty(passwordEditText)) {
            passwordEditText.requestFocus();
            passwordEditText.selectAll();
            return "Please enter a password";
        } else {
            password = String.valueOf(passwordEditText.getText());
        }

        user = realm.where(User.class).equalTo("email", email).findFirst();
        if (user != null) {
            if (user.getPassword().equals(password)) {
                return "Successfully signed in!";
            } else {
                passwordEditText.requestFocus();
                passwordEditText.selectAll();
                return "Password is incorrect";
            }
        } else {
            emailEditText.requestFocus();
            emailEditText.selectAll();
            return "Username is incorrect or user does not exist. Please try again or register.";
        }
    }

    public String register() {
        if (isEmpty(emailEditText)) {
            emailEditText.requestFocus();
            emailEditText.selectAll();
            return "Please enter an email";
        } else {
            if (emailEditText.getText().toString().contains("@spsd.us")) {
                email = String.valueOf(emailEditText.getText());
            } else {
                emailEditText.requestFocus();
                emailEditText.selectAll();
                return "Please enter a valid email";
            }
        }

        if (isEmpty(passwordEditText)) {
            passwordEditText.requestFocus();
            passwordEditText.selectAll();
            return "Please enter a password";
        } else {
            password = String.valueOf(passwordEditText.getText());
        }

        user = realm.where(User.class).equalTo("email", email).findFirst();
        if (user != null) {
            return "User already exists. Please sign in.";
        } else {
            realm.beginTransaction();
            user = new User();
            user.setEmail(email);
            user.setPassword(password);
            user.setPoints(0);
            realm.copyToRealmOrUpdate(user);
            realm.commitTransaction();
            addNewCoupons();
            return "Successfully registered!";
        }
    }

    private boolean isEmpty(EditText myeditText) {
        return myeditText.getText().toString().trim().length() == 0;
    }

    public void addNewCoupons() {

        //colors for QR: darkest: 0868be, lightest: 2196f3, middle: 1e88e5

        final Coupon foodCoupon1 = new Coupon();
        foodCoupon1.setId(1);
        foodCoupon1.setCompanyName("Dunkin' Donuts");
        foodCoupon1.setCouponValue("Free Donut");
        foodCoupon1.setDescription("In Store Only. Any Variety. Up to $1.00 value. Expires 12/31/17");
        foodCoupon1.setPicImageResourceId(R.drawable.dunkindonuts);
        foodCoupon1.setQrImageResourceId(R.drawable.dunkinqr);
        foodCoupon1.setPts(100);
        foodCoupon1.setCategory("food");
        allCoupons.add(foodCoupon1);
        foodCoupons.add(foodCoupon1);

        final Coupon foodCoupon2 = new Coupon();
        foodCoupon2.setId(2);
        foodCoupon2.setCompanyName("McDonald's");
        foodCoupon2.setCouponValue("Free Large Fries");
        foodCoupon2.setDescription("In Store Only. Not valid at drive thru. Expires 12/31/17");
        foodCoupon2.setPicImageResourceId(R.drawable.mcdonalds);
        foodCoupon2.setQrImageResourceId(R.drawable.mcdonaldsqr);
        foodCoupon2.setPts(200);
        foodCoupon2.setCategory("food");
        allCoupons.add(foodCoupon2);
        foodCoupons.add(foodCoupon2);

        final Coupon foodCoupon3 = new Coupon();
        foodCoupon3.setId(3);
        foodCoupon3.setCompanyName("Subway");
        foodCoupon3.setCouponValue("$3 off combo");
        foodCoupon3.setDescription("In Store Only. Valid only with meal combos. Expires 12/31/17");
        foodCoupon3.setPicImageResourceId(R.drawable.subway);
        foodCoupon3.setQrImageResourceId(R.drawable.subwayqr);
        foodCoupon3.setPts(500);
        foodCoupon3.setCategory("food");
        allCoupons.add(foodCoupon3);
        foodCoupons.add(foodCoupon3);


        Coupon entCoupon1 = new Coupon();
        entCoupon1.setId(10);
        entCoupon1.setCompanyName("AMC");
        entCoupon1.setDescription("Valid only at Starplex Cinemas in East Brunswick. Expires 12/31/17");
        entCoupon1.setCouponValue("Free small popcorn");
        entCoupon1.setPts(1000);
        entCoupon1.setCategory("entertainment");
        entCoupon1.setPicImageResourceId(R.drawable.amc);
        entCoupon1.setQrImageResourceId(R.drawable.amcqr);
        allCoupons.add(entCoupon1);
        entCoupons.add(entCoupon1);

        Coupon entCoupon2 = new Coupon();
        entCoupon2.setId(20);
        entCoupon2.setCompanyName("Bowlero");
        entCoupon2.setDescription("Valid for only one game. Not valid on holidays or weekends. Not valid with any other offers. Expires 12/31/17");
        entCoupon2.setCouponValue("Free game");
        entCoupon2.setPts(8000);
        entCoupon2.setCategory("entertainment");
        entCoupon2.setPicImageResourceId(R.drawable.bowlero);
        entCoupon2.setQrImageResourceId(R.drawable.bowleroqr);
        allCoupons.add(entCoupon2);
        entCoupons.add(entCoupon2);

        Coupon entCoupon3 = new Coupon();
        entCoupon3.setId(30);
        entCoupon3.setCompanyName("Six Flags");
        entCoupon3.setDescription("Receive $20 off any one day adult admission to Six Flags Great Adventure. Not valid at any other Six Flags location. Expires 12/31/17");
        entCoupon3.setCouponValue("$20 off!");
        entCoupon3.setPts(10000);
        entCoupon3.setCategory("entertainment");
        entCoupon3.setPicImageResourceId(R.drawable.sixflags);
        entCoupon3.setQrImageResourceId(R.drawable.sixflagsqr);
        allCoupons.add(entCoupon3);
        entCoupons.add(entCoupon3);


        Coupon otherCoupon1 = new Coupon();
        otherCoupon1.setId(100);
        otherCoupon1.setCompanyName("Walmart");
        otherCoupon1.setDescription("Save 10% on any one regularly priced item. Expires 12/31/17");
        otherCoupon1.setCouponValue("10% off");
        otherCoupon1.setPts(5000);
        otherCoupon1.setCategory("other");
        otherCoupon1.setPicImageResourceId(R.drawable.walmart);
        otherCoupon1.setQrImageResourceId(R.drawable.walmartqr);
        allCoupons.add(otherCoupon1);
        otherCoupons.add(otherCoupon1);

        Coupon otherCoupon2 = new Coupon();
        otherCoupon2.setId(200);
        otherCoupon2.setCompanyName("Rite Aid");
        otherCoupon2.setDescription("$5 off any $25 purchase or more. Not valid on clearance merchandise. Expires 12/31/17");
        otherCoupon2.setCouponValue("$5 off");
        otherCoupon2.setPts(6000);
        otherCoupon2.setCategory("other");
        otherCoupon2.setPicImageResourceId(R.drawable.riteaid);
        otherCoupon2.setQrImageResourceId(R.drawable.riteaidqr);
        allCoupons.add(otherCoupon2);
        otherCoupons.add(otherCoupon2);

        Coupon otherCoupon3 = new Coupon();
        otherCoupon3.setId(300);
        otherCoupon3.setCompanyName("Michaels");
        otherCoupon3.setDescription("50% off any one regularly priced item. Not valid on sale items. Expires 12/31/17");
        otherCoupon3.setCouponValue("50% off");
        otherCoupon3.setPts(3000);
        otherCoupon3.setCategory("other");
        otherCoupon3.setPicImageResourceId(R.drawable.michaels);
        otherCoupon3.setQrImageResourceId(R.drawable.michaelsqr);
        allCoupons.add(otherCoupon3);
        otherCoupons.add(otherCoupon3);

        realm.beginTransaction();
        user.setAllCoupons(allCoupons);
        user.setFoodCoupons(foodCoupons);
        user.setEntertainmentCoupons(entCoupons);
        user.setOtherCoupons(otherCoupons);
        realm.copyToRealmOrUpdate(user);
        realm.commitTransaction();

    }
}

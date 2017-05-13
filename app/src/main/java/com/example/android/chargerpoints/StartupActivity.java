package com.example.android.chargerpoints;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.realm.Realm;

public class StartupActivity extends AppCompatActivity {

    Realm realm;
    User currentUser;
    boolean loginRequired;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);

        realm = Realm.getDefaultInstance();
        Realm.init(this);
        currentUser = realm.where(User.class).equalTo("isLoggedIn", true).findFirst();

        if (currentUser != null) {
            loginRequired = false;
        } else {
            loginRequired = true;
        }

        if (loginRequired) {
            Intent i = new Intent();
            i.setClass(StartupActivity.this, LogonActivity.class);
            startActivity(i);
        } else {
            Intent i = new Intent();
            i.setClass(StartupActivity.this, MainActivity.class);
            startActivity(i);
        }


    }
}

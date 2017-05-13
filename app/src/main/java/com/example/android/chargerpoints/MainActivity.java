package com.example.android.chargerpoints;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    public static int points;

    User user;
    String userEmail;

    Realm realm;

    Context context = this;

    Calendar c = Calendar.getInstance();
    int hours = c.get(Calendar.HOUR_OF_DAY);

    private Timer timer;
    private TimerTask timerTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        realm = Realm.getDefaultInstance();

        Realm.init(this);

        user = realm.where(User.class).equalTo("isLoggedIn", true).findFirst();
        points = user.getPoints();

        /*timerTask = new TimerTask() {
            @Override
            public void run() {
                if (hours > 7 || hours < 15) {
                    KeyguardManager myKM = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);
                    if (myKM.inKeyguardRestrictedInputMode()) {
                        points++;
                    }
                    displayPoints(points);
                }
            }
        };*/

        TextView ptsTextView = (TextView) findViewById(R.id.pts);
        ptsTextView.setText(user.getPoints() + "points");

        start();

        TextView couponsTextView = (TextView) findViewById(R.id.coupons);
        couponsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("email", userEmail);
                intent.setClass(MainActivity.this, CouponsActivity.class);
                startActivity(intent);

            }
        });

        //Find view
        TextView helpTextView = (TextView) findViewById(R.id.help);
        //Set click listener on view
        helpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Execute when view is clicked on
                Intent helpIntent = new Intent(MainActivity.this, HelpActivity.class);
                startActivity(helpIntent);
            }
        });

        TextView myDealsTextView = (TextView) findViewById(R.id.myDeals);
        myDealsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.putExtra("email", userEmail);
                i.setClass(MainActivity.this, MyDealsActivity.class);
                startActivity(i);

            }
        });

        TextView shareTextView = (TextView) findViewById(R.id.share);
        shareTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                String shareBody = "I have " + points + " points in ChargerPoints! Start getting coupons today!";
                String shareSub = "ChargerPoints is Awesome!";
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(shareIntent, "Share using"));
            }
        });

        TextView logOffTextView = (TextView) findViewById(R.id.logOff);
        logOffTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                realm.beginTransaction();
                user.setLoggedIn(false);
                user.setPoints(points);
                realm.copyToRealmOrUpdate(user);
                realm.commitTransaction();
                stop();
                i.setClass(MainActivity.this, LogonActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    public void start() {
        if (timerTask != null) {
            timerTask.cancel();
        }
        timerTask = new TimerTask() {
            @Override
            public void run() {
                if (hours > 7 || hours < 15) {
                    KeyguardManager myKM = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);
                    if (myKM.inKeyguardRestrictedInputMode()) {
                        points++;
                    }
                    displayPoints(points);
                }
            }
        };
        timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 0, 2000);
    }

    public void stop() {
        timer.cancel();
        timerTask.cancel();
    }

    public void displayPoints(final int pts) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (pts == 1) {
                    TextView ptsTextView = (TextView) findViewById(R.id.pts);
                    ptsTextView.setText(pts + " point");
                } else {
                    TextView ptsTextView = (TextView) findViewById(R.id.pts);
                    ptsTextView.setText(pts + " points");
                }
                realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                if (user.isLoggedIn()) {
                    user.setPoints(points);
                }
                realm.copyToRealmOrUpdate(user);
                realm.commitTransaction();
            }
        });

    }

}
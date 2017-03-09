package com.example.android.chargerpoints;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

    public static int points;
    Context context = this;
    private Timer timer;
    private TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            KeyguardManager myKM = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);
            if (myKM.inKeyguardRestrictedInputMode()) {
                points++;
            }
            displayPoints();

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        TextView couponsTextView = (TextView) findViewById(R.id.coupons);
        couponsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent couponsIntent = new Intent(MainActivity.this, CouponsActivity.class);
                startActivity(couponsIntent);
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
                Intent myDealsIntent = new Intent(MainActivity.this, MyDealsActivity.class);
                startActivity(myDealsIntent);
            }
        });

        TextView shareTextView = (TextView) findViewById(R.id.share);
        shareTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //implement share stuff https://www.youtube.com/watch?v=V9laA2sHetA
            }
        });

        start();
    }

    public void start() {
        if (timer != null) {
            return;
        }
        timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 0, 60000);
    }

    public void displayPoints() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (points == 1) {
                    TextView ptsTextView = (TextView) findViewById(R.id.pts);
                    ptsTextView.setText(points + " point");
                } else {
                    TextView ptsTextView = (TextView) findViewById(R.id.pts);
                    ptsTextView.setText(points + " points");
                }
            }
        });

    }
}
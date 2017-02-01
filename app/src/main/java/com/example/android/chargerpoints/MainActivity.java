package com.example.android.chargerpoints;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

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

    }

}
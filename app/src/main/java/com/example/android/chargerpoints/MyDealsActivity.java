package com.example.android.chargerpoints;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MyDealsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_deals);

        ArrayList<Coupon> myDeals = new ArrayList<Coupon>();

        myDeals.add(new Coupon("$10 off $25!", "JCPenney's",
                "In Store and Online. Select apparel, shoes, accessories, fine jewelry & home. Expires 12/31/2016",
                15, R.drawable.jcplogo, R.drawable.jcpqr));

        myDeals.add(new Coupon("$10 off $25!", "JCPenney's",
                "In Store and Online. Select apparel, shoes, accessories, fine jewelry & home. Expires 12/31/2016",
                15, R.drawable.jcplogo, R.drawable.jcpqr));

        myDeals.add(new Coupon("$10 off $25!", "JCPenney's",
                "In Store and Online. Select apparel, shoes, accessories, fine jewelry & home. Expires 12/31/2016",
                15, R.drawable.jcplogo, R.drawable.jcpqr));

        myDeals.add(new Coupon("$10 off $25!", "JCPenney's",
                "In Store and Online. Select apparel, shoes, accessories, fine jewelry & home. Expires 12/31/2016",
                15, R.drawable.jcplogo, R.drawable.jcpqr));

        myDeals.add(new Coupon("$10 off $25!", "JCPenney's",
                "In Store and Online. Select apparel, shoes, accessories, fine jewelry & home. Expires 12/31/2016",
                15, R.drawable.jcplogo, R.drawable.jcpqr));

        CouponAdapter adapter = new CouponAdapter(this, myDeals);
        ListView listview = (ListView)findViewById(R.id.list);
        listview.setAdapter(adapter);
    }


}

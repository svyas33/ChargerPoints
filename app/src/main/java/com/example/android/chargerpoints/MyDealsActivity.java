package com.example.android.chargerpoints;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MyDealsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coupon_list);

        if(getActionBar() != null) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }

        final ArrayList<Coupon> myDeals = new ArrayList<Coupon>();

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

        final Coupon coupon = (Coupon) getIntent().getSerializableExtra("coupon");

        myDeals.add(coupon);

        CouponAdapter adapter = new CouponAdapter(this, myDeals);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Coupon coupon = myDeals.get(position);

                Intent myDealsIntent = new Intent(MyDealsActivity.this, IndividualCouponActivity.class);

                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("coupon", coupon); // or putSerializable()
                intent.putExtras(bundle);
                intent.setClass(MyDealsActivity.this, IndividualCouponActivity.class);
                MyDealsActivity.this.startActivity(intent);

            }
        });

    }


}

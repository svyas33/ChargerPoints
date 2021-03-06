package com.example.android.chargerpoints;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import io.realm.Realm;
import io.realm.RealmList;

public class MyDealsActivity extends AppCompatActivity {

    Realm realm;
    private RealmList<Coupon> myDeals;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coupon_list);

        if(getActionBar() != null) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }

        realm = Realm.getDefaultInstance();
        Realm.init(this);

        user = realm.where(User.class).equalTo("isLoggedIn", true).findFirst();

        myDeals = user.getRedeemedCoupons();

        CouponAdapter adapter = new CouponAdapter(this, myDeals, "mydeals");
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Coupon coupon = myDeals.get(position);

                Intent intent = new Intent();
                intent.putExtra("coupon_id", coupon.getId());
                intent.putExtra("activity", "mydeals");
                intent.setClass(MyDealsActivity.this, IndividualCouponActivity.class);
                startActivity(intent);
            }
        });

    }

}

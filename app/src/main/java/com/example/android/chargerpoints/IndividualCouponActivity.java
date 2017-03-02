package com.example.android.chargerpoints;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import io.realm.Realm;

public class IndividualCouponActivity extends AppCompatActivity {

    Coupon coupon;
    int couponId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_coupon);

        if(getActionBar() != null) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }

        couponId = getIntent().getIntExtra("coupon_id", 0);
        String activity = getIntent().getStringExtra("activity");
        Realm realm = Realm.getDefaultInstance();
        try {
            coupon = realm.where(Coupon.class).equalTo("id", couponId).findFirst();

            TextView valueTxt = (TextView) findViewById(R.id.coupon_value_textview);
            valueTxt.setText(coupon.getCouponValue());

            TextView companyTxt = (TextView) findViewById(R.id.company_textview);
            companyTxt.setText(coupon.getCompanyName());

            TextView infoTxt = (TextView) findViewById(R.id.info_textview);
            infoTxt.setText(coupon.getDescription());

            if (activity.equals("coupons")) {
                TextView ptsTxt = (TextView) findViewById(R.id.point_textview);
                ptsTxt.setText(String.valueOf(coupon.getPts()) + " points");

                ImageView picImg = (ImageView) findViewById(R.id.qr_imageview);
                picImg.setImageResource(coupon.getPicImageResourceId());
            } else {
                TextView ptsTxt = (TextView) findViewById(R.id.point_textview);
                ptsTxt.setText("");

                ImageView qrImg = (ImageView) findViewById(R.id.qr_imageview);
                qrImg.setImageResource(coupon.getQrImageResourceId());

                Button redeemBtn = (Button) findViewById(R.id.redeem_button);
                redeemBtn.setVisibility(View.INVISIBLE);
                redeemBtn.setEnabled(false);
            }
        } finally {
            realm.close();
        }

        Button redeemButton = (Button) findViewById(R.id.redeem_button);
        redeemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (coupon.getCategory().equals("food")) {
                    CouponsActivity.FoodCouponsFragment.removeCoupon(coupon);
                } else if (coupon.getCategory().equals("entertainment")) {
                    CouponsActivity.EntertainmentCouponsFragment.removeCoupon(coupon);
                } else {
                    CouponsActivity.OtherCouponsFragment.removeCoupon(coupon);
                }

                Intent intent = new Intent();
                intent.putExtra("id", coupon.getId());
                intent.setClass(IndividualCouponActivity.this, MyDealsActivity.class);
                startActivity(intent);

            }
        });

    }

}

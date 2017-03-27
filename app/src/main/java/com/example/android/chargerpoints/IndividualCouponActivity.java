package com.example.android.chargerpoints;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

import io.realm.Realm;

import static com.example.android.chargerpoints.MainActivity.points;

public class IndividualCouponActivity extends AppCompatActivity {

    private static final String FORMAT = "%02d:%02d";
    Coupon coupon;
    int couponId;
    //Timer stuff
    TextView timerText;

    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_coupon);

        if (getSupportActionBar() != null) {
            ActionBar ab = getSupportActionBar();
            ab.setDisplayHomeAsUpEnabled(true);
        }

        couponId = getIntent().getIntExtra("coupon_id", 0);
        String activity = getIntent().getStringExtra("activity");
        realm = Realm.getDefaultInstance();
        Realm.init(this);
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

                //sets text to use now when the activity is mydeals
                Button redeemBtn = (Button) findViewById(R.id.redeem_button);
                redeemBtn.setText("USE NOW");
            }
        } finally {
            realm.close();
        }

        final Button redeemButton = (Button) findViewById(R.id.redeem_button);
        redeemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Checks to see what the button is showing
                if (redeemButton.getText().equals("REDEEM")) {
                    if (coupon.getPts() <= points) {
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
                    } else {
                        Toast.makeText(IndividualCouponActivity.this, "You don't have enough points to redeem this coupon!",
                                Toast.LENGTH_LONG).show();
                    }


                }
                //done if button is showing use now
                else {
                    if (getSupportActionBar() != null) {
                        ActionBar ab = getSupportActionBar();
                        ab.setDisplayHomeAsUpEnabled(false);
                    }

                    // Hide Use Now Button
                    Button useNowBtn = (Button) findViewById(R.id.redeem_button);
                    useNowBtn.setVisibility(useNowBtn.INVISIBLE);

                    //Display QR Code
                    ImageView qrImg = (ImageView) findViewById(R.id.qr_imageview);
                    qrImg.setImageResource(coupon.getQrImageResourceId());

                    realm.beginTransaction();
                    coupon.setCategory("used");
                    realm.copyToRealmOrUpdate(coupon);
                    realm.commitTransaction();
                    // Start timer

                    Toast.makeText(IndividualCouponActivity.this, "You have 5 minutes to use this coupon!",
                            Toast.LENGTH_LONG).show();

                    timerText=(TextView)findViewById(R.id.countdown);

                    new CountDownTimer(300000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            timerText.setText("" + String.format(FORMAT,
                                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                            TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)),
                                    TimeUnit.MILLISECONDS.toMillis(millisUntilFinished) - TimeUnit.SECONDS.toMillis(
                                            TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished))));
                        }

                        public void onFinish() {
                            if (getSupportActionBar() != null) {
                                ActionBar ab = getSupportActionBar();
                                ab.setDisplayHomeAsUpEnabled(true);
                            }

                            Intent intent = new Intent();
                            intent.setClass(IndividualCouponActivity.this, MyDealsActivity.class);
                            startActivity(intent);
                        }
                    }.start();
                }
            }
        });

    }
}

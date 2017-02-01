package com.example.android.chargerpoints;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class IndividualCouponActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_coupon);

        if(getActionBar() != null) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }

        final Coupon coupon = (Coupon) getIntent().getSerializableExtra("coupon");

        TextView valueTxt = (TextView) findViewById(R.id.coupon_value_textview);
        valueTxt.setText(coupon.getCouponValue());

        TextView companyTxt = (TextView) findViewById(R.id.company_textview);
        companyTxt.setText(coupon.getCompanyName());

        TextView infoTxt = (TextView) findViewById(R.id.info_textview);
        infoTxt.setText(coupon.getDescription());

        TextView ptsTxt = (TextView) findViewById(R.id.point_textview);
        ptsTxt.setText(String.valueOf(coupon.getPts()));

        ImageView qrImg = (ImageView) findViewById(R.id.qr_imageview);
        qrImg.setImageResource(coupon.getQrImageResourceId());

        /*Button redeemButton = (Button) findViewById(R.id.redeem_button);
        redeemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent redeemIntent = new Intent(IndividualCouponActivity.this, MyDealsActivity.class);
                CouponsActivity.FoodCouponsFragment.removeCoupon(coupon);
                redeemIntent.putExtra("coupon", coupon);
                startActivity(redeemIntent);

            }
        });*/

    }

}

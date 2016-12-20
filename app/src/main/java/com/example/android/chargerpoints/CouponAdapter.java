package com.example.android.chargerpoints;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 17svyas on 12/8/2016.
 */

public class  CouponAdapter extends ArrayAdapter<Coupon> {

    public CouponAdapter(Activity context, ArrayList<Coupon> coupons){
        super(context, 0, coupons);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Coupon currentCoupon = getItem(position);

        ImageView picImageView = (ImageView) listItemView.findViewById(R.id.pic_image_view);
        picImageView.setImageResource(currentCoupon.getPicImageResourceId());

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name_text_view);
        nameTextView.setText(currentCoupon.getCouponValue());

        TextView ptsTextView = (TextView) listItemView.findViewById(R.id.pts_text_view);
        ptsTextView.setText(currentCoupon.getPts() + " points");

        return listItemView;
    }
}

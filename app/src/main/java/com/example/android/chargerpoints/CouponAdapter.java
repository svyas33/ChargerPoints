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
            //Inflate the list_item view to be able to edit it
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        //Retrieve position of current coupon in ArrayList
        Coupon currentCoupon = getItem(position);

        //Display logo of current coupon in ImageView of list_item
        ImageView picImageView = (ImageView) listItemView.findViewById(R.id.pic_image_view);
        picImageView.setImageResource(currentCoupon.getPicImageResourceId());

        //Display name of current coupon in TextView of list_item
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name_text_view);
        nameTextView.setText(currentCoupon.getCouponValue());

        //Display points of current coupon in TextView of list_item
        TextView ptsTextView = (TextView) listItemView.findViewById(R.id.pts_text_view);
        ptsTextView.setText(currentCoupon.getPts() + " points");

        //After filling the list_item with information from current coupon,
        //pass it back to the ListView to be displayed
        return listItemView;
    }
}

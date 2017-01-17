package com.example.android.chargerpoints;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.design.widget.TabLayout;
import java.util.ArrayList;
import android.widget.ListView;

public class CouponsActivity extends AppCompatActivity {


    SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupons);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);



        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager)(findViewById(R.id.pager));
        mViewPager.setAdapter(mSectionsPagerAdapter);
        tabLayout.setupWithViewPager(mViewPager);
    }




    public static class FoodCouponsFragment extends Fragment {

        public FoodCouponsFragment(){
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.food_fragment_layout, container, false);


            ArrayList<Coupon> foodCoupons = new ArrayList<Coupon>();

            foodCoupons.add(new Coupon("$10 off $25!", "JCPenney's",
                    "In Store and Online. Select apparel, shoes, accessories, fine jewelry & home. Expires 12/31/2016",
                    15, R.drawable.jcplogo, R.drawable.jcpqr));

            foodCoupons.add(new Coupon("$10 off $25!", "JCPenney's",
                    "In Store and Online. Select apparel, shoes, accessories, fine jewelry & home. Expires 12/31/2016",
                    15, R.drawable.jcplogo, R.drawable.jcpqr));

            foodCoupons.add(new Coupon("$10 off $25!", "JCPenney's",
                    "In Store and Online. Select apparel, shoes, accessories, fine jewelry & home. Expires 12/31/2016",
                    15, R.drawable.jcplogo, R.drawable.jcpqr));

            foodCoupons.add(new Coupon("$10 off $25!", "JCPenney's",
                    "In Store and Online. Select apparel, shoes, accessories, fine jewelry & home. Expires 12/31/2016",
                    15, R.drawable.jcplogo, R.drawable.jcpqr));

            foodCoupons.add(new Coupon("$10 off $25!", "JCPenney's",
                    "In Store and Online. Select apparel, shoes, accessories, fine jewelry & home. Expires 12/31/2016",
                    15, R.drawable.jcplogo, R.drawable.jcpqr));

            CouponAdapter adapter = new CouponAdapter(getActivity(), foodCoupons);
            ListView listview = (ListView)rootView.findViewById(R.id.list);
            listview.setAdapter(adapter);


            return rootView;
        }

    }

    public static class EntertainmentCouponsFragment extends Fragment {

        public EntertainmentCouponsFragment(){
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.entertainment_fragment_layout, container, false);
            TextView entertainmentTextView = (TextView) rootView.findViewById(R.id.section_label);
            entertainmentTextView.setText("cool");
            return rootView;
        }

    }

    public static class OtherCouponsFragment extends Fragment {

        public OtherCouponsFragment(){

        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.other_fragment_layout, container, false);
            TextView otherTextView = (TextView) rootView.findViewById(R.id.section_label);
            otherTextView.setText("wow");
            return rootView;
        }

    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }


        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new FoodCouponsFragment();
                case 1:
                    return new EntertainmentCouponsFragment();
                case 2:
                    return new OtherCouponsFragment();
                default:
                    return null;
            }
        }

        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Food";
                case 1:
                    return "Entertainment";
                case 2:
                    return "Other";
                default:
                    return null;
            }
        }


    }

}

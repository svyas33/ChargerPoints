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
import android.widget.ListView;

import java.util.ArrayList;

public class CouponsActivity extends AppCompatActivity {


    SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupons);

        if(getActionBar() != null) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }

        ActionBar bar = getActionBar();

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager)(findViewById(R.id.pager));
        mViewPager.setAdapter(mSectionsPagerAdapter);
    }


    //IGNORE - used for action bar, might remove eventually
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        mViewPager.setCurrentItem(tab.getPosition());
    }
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {}
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {}

    public static class FoodCouponsFragment extends Fragment {

        public FoodCouponsFragment(){
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.word_list, container, false);


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
            View rootView = inflater.inflate(R.layout.word_list, container, false);

            ArrayList<Coupon> entertainmentCoupons = new ArrayList<Coupon>();

            entertainmentCoupons.add(new Coupon("$10 off $25!", "JCPenney's",
                    "In Store and Online. Select apparel, shoes, accessories, fine jewelry & home. Expires 12/31/2016",
                    15, R.drawable.jcplogo, R.drawable.jcpqr));

            entertainmentCoupons.add(new Coupon("$10 off $25!", "JCPenney's",
                    "In Store and Online. Select apparel, shoes, accessories, fine jewelry & home. Expires 12/31/2016",
                    15, R.drawable.jcplogo, R.drawable.jcpqr));

            entertainmentCoupons.add(new Coupon("$10 off $25!", "JCPenney's",
                    "In Store and Online. Select apparel, shoes, accessories, fine jewelry & home. Expires 12/31/2016",
                    15, R.drawable.jcplogo, R.drawable.jcpqr));

            entertainmentCoupons.add(new Coupon("$10 off $25!", "JCPenney's",
                    "In Store and Online. Select apparel, shoes, accessories, fine jewelry & home. Expires 12/31/2016",
                    15, R.drawable.jcplogo, R.drawable.jcpqr));

            entertainmentCoupons.add(new Coupon("$10 off $25!", "JCPenney's",
                    "In Store and Online. Select apparel, shoes, accessories, fine jewelry & home. Expires 12/31/2016",
                    15, R.drawable.jcplogo, R.drawable.jcpqr));

            CouponAdapter adapter = new CouponAdapter(getActivity(), entertainmentCoupons);
            ListView listview = (ListView)rootView.findViewById(R.id.list);
            listview.setAdapter(adapter);

            return rootView;
        }

    }

    public static class OtherCouponsFragment extends Fragment {

        public OtherCouponsFragment(){

        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.word_list, container, false);

            ArrayList<Coupon> otherCoupons = new ArrayList<Coupon>();

            otherCoupons.add(new Coupon("$10 off $25!", "JCPenney's",
                    "In Store and Online. Select apparel, shoes, accessories, fine jewelry & home. Expires 12/31/2016",
                    15, R.drawable.jcplogo, R.drawable.jcpqr));

            otherCoupons.add(new Coupon("$10 off $25!", "JCPenney's",
                    "In Store and Online. Select apparel, shoes, accessories, fine jewelry & home. Expires 12/31/2016",
                    15, R.drawable.jcplogo, R.drawable.jcpqr));

            otherCoupons.add(new Coupon("$10 off $25!", "JCPenney's",
                    "In Store and Online. Select apparel, shoes, accessories, fine jewelry & home. Expires 12/31/2016",
                    15, R.drawable.jcplogo, R.drawable.jcpqr));

            otherCoupons.add(new Coupon("$10 off $25!", "JCPenney's",
                    "In Store and Online. Select apparel, shoes, accessories, fine jewelry & home. Expires 12/31/2016",
                    15, R.drawable.jcplogo, R.drawable.jcpqr));

            otherCoupons.add(new Coupon("$10 off $25!", "JCPenney's",
                    "In Store and Online. Select apparel, shoes, accessories, fine jewelry & home. Expires 12/31/2016",
                    15, R.drawable.jcplogo, R.drawable.jcpqr));

            CouponAdapter adapter = new CouponAdapter(getActivity(), otherCoupons);
            ListView listview = (ListView)rootView.findViewById(R.id.list);
            listview.setAdapter(adapter);

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


    }

}

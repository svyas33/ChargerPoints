package com.example.android.chargerpoints;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.android.chargerpoints.R.layout.coupon_list;

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

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager)(findViewById(R.id.pager));
        mViewPager.setAdapter(mSectionsPagerAdapter);
        tabLayout.setupWithViewPager(mViewPager);
    }




    public static class FoodCouponsFragment extends Fragment {

        final static ArrayList<Coupon> foodCoupons = new ArrayList<Coupon>();

        static int pos = -1;

        public FoodCouponsFragment(){
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(coupon_list, container, false);

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
            ListView listView = (ListView) rootView.findViewById(R.id.list);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                    Coupon newCoupon = foodCoupons.get(position);

                    pos = position;

                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("coupon", newCoupon); // or putSerializable()
                    intent.putExtras(bundle);
                    intent.setClass(getActivity(), IndividualCouponActivity.class);
                    getActivity().startActivity(intent);

                }
            });

            return rootView;
        }

        /*public static void removeCoupon(Coupon coupon){

            foodCoupons.remove(pos);
        }*/

    }

    public static class EntertainmentCouponsFragment extends Fragment {

        public EntertainmentCouponsFragment(){
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(coupon_list, container, false);

            final ArrayList<Coupon> entertainmentCoupons = new ArrayList<Coupon>();

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
            ListView listView = (ListView)rootView.findViewById(R.id.list);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                    Coupon newCoupon = entertainmentCoupons.get(position);

                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("coupon", newCoupon);
                    intent.putExtras(bundle);
                    intent.setClass(getActivity(), IndividualCouponActivity.class);
                    getActivity().startActivity(intent);

                }
            });

            return rootView;
        }
    }

    public static class OtherCouponsFragment extends Fragment {

        public OtherCouponsFragment(){

        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(coupon_list, container, false);

            final ArrayList<Coupon> otherCoupons = new ArrayList<Coupon>();

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
            ListView listView = (ListView) rootView.findViewById(R.id.list);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                    Coupon newCoupon = otherCoupons.get(position);

                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("coupon", newCoupon); // or putSerializable()
                    intent.putExtras(bundle);
                    intent.setClass(getActivity(), IndividualCouponActivity.class);
                    getActivity().startActivity(intent);

                }
            });

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

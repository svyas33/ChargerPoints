package com.example.android.chargerpoints;

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

import io.realm.Realm;
import io.realm.RealmResults;

import static com.example.android.chargerpoints.MainActivity.points;
import static com.example.android.chargerpoints.MyApplication.realm;
import static com.example.android.chargerpoints.R.layout.coupon_list;

public class CouponsActivity extends AppCompatActivity {

    static RealmResults<Coupon> foodCoupons;
    static RealmResults<Coupon> entertainmentCoupons;
    static RealmResults<Coupon> otherCoupons;
    SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupons);

        if(getActionBar() != null) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager)(findViewById(R.id.pager));
        mViewPager.setAdapter(mSectionsPagerAdapter);
        tabLayout.setupWithViewPager(mViewPager);
    }

    public static class FoodCouponsFragment extends Fragment {

        public FoodCouponsFragment(){
        }

        public static void removeCoupon(Coupon coupon) {

            points = points - coupon.getPts();

            realm.beginTransaction();
            coupon.setCategory("redeemed");
            realm.copyToRealmOrUpdate(coupon);
            realm.commitTransaction();
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            Realm.init(getActivity());

            View rootView = inflater.inflate(coupon_list, container, false);

            realm = Realm.getDefaultInstance();

            foodCoupons = realm.where(Coupon.class).equalTo("category", "food").findAll();

            CouponAdapter adapter = new CouponAdapter(getActivity(), foodCoupons, "coupons");
            ListView listView = (ListView) rootView.findViewById(R.id.list);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                    Coupon coupon = foodCoupons.get(position);

                    Intent intent = new Intent();
                    intent.putExtra("coupon_id", coupon.getId());
                    intent.putExtra("activity", "coupons");
                    intent.setClass(getActivity(), IndividualCouponActivity.class);
                    getActivity().startActivity(intent);

                }
            });

            return rootView;
        }

    }

    public static class EntertainmentCouponsFragment extends Fragment {


        static int pos = -1;

        public EntertainmentCouponsFragment(){
        }

        public static void removeCoupon(Coupon coupon) {

            points = points - coupon.getPts();

            realm.beginTransaction();
            coupon.setCategory("redeemed");
            realm.copyToRealmOrUpdate(coupon);
            realm.commitTransaction();
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            Realm.init(getActivity());

            View rootView = inflater.inflate(coupon_list, container, false);

            realm = Realm.getDefaultInstance();

            entertainmentCoupons = realm.where(Coupon.class).equalTo("category", "entertainment").findAll();

            CouponAdapter adapter = new CouponAdapter(getActivity(), entertainmentCoupons, "coupons");
            ListView listView = (ListView)rootView.findViewById(R.id.list);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                    Coupon coupon = entertainmentCoupons.get(position);

                    pos = position;

                    Intent intent = new Intent();
                    intent.putExtra("coupon_id", coupon.getId());
                    intent.putExtra("activity", "coupons");
                    intent.setClass(getActivity(), IndividualCouponActivity.class);
                    getActivity().startActivity(intent);
                }
            });

            return rootView;
        }
    }

    public static class OtherCouponsFragment extends Fragment {

        static int pos = -1;

        public OtherCouponsFragment(){
        }

        public static void removeCoupon(Coupon coupon) {

            points = points - coupon.getPts();

            realm.beginTransaction();
            coupon.setCategory("redeemed");
            realm.copyToRealmOrUpdate(coupon);
            realm.commitTransaction();
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            Realm.init(getActivity());

            View rootView = inflater.inflate(coupon_list, container, false);

            realm = Realm.getDefaultInstance();

            otherCoupons = realm.where(Coupon.class).equalTo("category", "other").findAll();

            CouponAdapter adapter = new CouponAdapter(getActivity(), otherCoupons, "coupons");
            ListView listView = (ListView) rootView.findViewById(R.id.list);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                    Coupon coupon = otherCoupons.get(position);

                    pos = position;

                    Intent intent = new Intent();
                    intent.putExtra("coupon_id", coupon.getId());
                    intent.putExtra("activity", "coupons");
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

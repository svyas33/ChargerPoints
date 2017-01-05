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

public class CouponsActivity extends AppCompatActivity {


    SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
    ViewPager mViewPager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupons);

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
            View rootView = inflater.inflate(R.layout.food_fragment_layout, container, false);
            TextView foodTextView = (TextView) rootView.findViewById(R.id.section_label);
            foodTextView.setText("yummy");
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


    }

}

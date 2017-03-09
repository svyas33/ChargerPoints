package com.example.android.chargerpoints;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by ShivaniVyas on 2/2/17.
 */

public class MyApplication extends Application {

    static Realm realm;

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);

        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("chargerpoints.realm")
                .schemaVersion(1)
                .build();

        realm = Realm.getInstance(config);
        realm = Realm.getDefaultInstance();

        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                        .build()
        );


        RealmResults<Coupon> allCoupons = realm.where(Coupon.class).findAll();

        if (allCoupons.size() == 0) {
            try {

                final Coupon foodCoupon1 = new Coupon();
                foodCoupon1.setId(1);
                foodCoupon1.setCompanyName("JCPenney's");
                foodCoupon1.setCouponValue("$10 off $25!");
                foodCoupon1.setDescription("In Store and Online. Select apparel, shoes, accessories, fine jewelry & home. Expires 12/31/2016");
                foodCoupon1.setPicImageResourceId(R.drawable.jcplogo);
                foodCoupon1.setQrImageResourceId(R.drawable.jcpqr);
                foodCoupon1.setPts(15);
                foodCoupon1.setCategory("food");
                realm.beginTransaction();
                realm.copyToRealmOrUpdate(foodCoupon1);
                realm.commitTransaction();

                final Coupon foodCoupon2 = new Coupon();
                foodCoupon2.setId(2);
                foodCoupon2.setCompanyName("JCPenney's");
                foodCoupon2.setCouponValue("$10 off $25!");
                foodCoupon2.setDescription("In Store and Online. Select apparel, shoes, accessories, fine jewelry & home. Expires 12/31/2016");
                foodCoupon2.setPicImageResourceId(R.drawable.jcplogo);
                foodCoupon2.setQrImageResourceId(R.drawable.jcpqr);
                foodCoupon2.setPts(15);
                foodCoupon2.setCategory("food");
                realm.beginTransaction();
                realm.copyToRealmOrUpdate(foodCoupon2);
                realm.commitTransaction();

                final Coupon foodCoupon3 = new Coupon();
                foodCoupon3.setId(3);
                foodCoupon3.setCompanyName("JCPenney's");
                foodCoupon3.setCouponValue("$10 off $25!");
                foodCoupon3.setDescription("In Store and Online. Select apparel, shoes, accessories, fine jewelry & home. Expires 12/31/2016");
                foodCoupon3.setPicImageResourceId(R.drawable.jcplogo);
                foodCoupon3.setQrImageResourceId(R.drawable.jcpqr);
                foodCoupon3.setPts(15);
                foodCoupon3.setCategory("food");
                realm.beginTransaction();
                realm.copyToRealmOrUpdate(foodCoupon3);
                realm.commitTransaction();


                Coupon entCoupon1 = new Coupon();
                entCoupon1.setId(10);
                entCoupon1.setCompanyName("Movies");
                entCoupon1.setDescription("Only in Store");
                entCoupon1.setCouponValue("$5 off!");
                entCoupon1.setPts(30);
                entCoupon1.setCategory("entertainment");
                entCoupon1.setPicImageResourceId(R.drawable.jcplogo);
                entCoupon1.setQrImageResourceId(R.drawable.jcpqr);
                realm.beginTransaction();
                realm.copyToRealmOrUpdate(entCoupon1);
                realm.commitTransaction();

                Coupon entCoupon2 = new Coupon();
                entCoupon2.setId(20);
                entCoupon2.setCompanyName("Movies");
                entCoupon2.setDescription("Only in Store");
                entCoupon2.setCouponValue("$5 off!");
                entCoupon2.setPts(30);
                entCoupon2.setCategory("entertainment");
                entCoupon2.setPicImageResourceId(R.drawable.jcplogo);
                entCoupon2.setQrImageResourceId(R.drawable.jcpqr);
                realm.beginTransaction();
                realm.copyToRealmOrUpdate(entCoupon2);
                realm.commitTransaction();

                Coupon entCoupon3 = new Coupon();
                entCoupon3.setId(30);
                entCoupon3.setCompanyName("Movies");
                entCoupon3.setDescription("Only in Store");
                entCoupon3.setCouponValue("$5 off!");
                entCoupon3.setPts(30);
                entCoupon3.setCategory("entertainment");
                entCoupon3.setPicImageResourceId(R.drawable.jcplogo);
                entCoupon3.setQrImageResourceId(R.drawable.jcpqr);
                realm.beginTransaction();
                realm.copyToRealmOrUpdate(entCoupon3);
                realm.commitTransaction();


                Coupon otherCoupon1 = new Coupon();
                otherCoupon1.setId(100);
                otherCoupon1.setCompanyName("Walmart");
                otherCoupon1.setDescription("Save money");
                otherCoupon1.setCouponValue("10% off");
                otherCoupon1.setPts(40);
                otherCoupon1.setCategory("other");
                otherCoupon1.setPicImageResourceId(R.drawable.jcplogo);
                otherCoupon1.setQrImageResourceId(R.drawable.jcpqr);
                realm.beginTransaction();
                realm.copyToRealmOrUpdate(otherCoupon1);
                realm.commitTransaction();

                Coupon otherCoupon2 = new Coupon();
                otherCoupon2.setId(200);
                otherCoupon2.setCompanyName("Walmart");
                otherCoupon2.setDescription("Save money");
                otherCoupon2.setCouponValue("10% off");
                otherCoupon2.setPts(40);
                otherCoupon2.setCategory("other");
                otherCoupon2.setPicImageResourceId(R.drawable.jcplogo);
                otherCoupon2.setQrImageResourceId(R.drawable.jcpqr);
                realm.beginTransaction();
                realm.copyToRealmOrUpdate(otherCoupon2);
                realm.commitTransaction();

                Coupon otherCoupon3 = new Coupon();
                otherCoupon3.setId(300);
                otherCoupon3.setCompanyName("Walmart");
                otherCoupon3.setDescription("Save money");
                otherCoupon3.setCouponValue("10% off");
                otherCoupon3.setPts(40);
                otherCoupon3.setCategory("other");
                otherCoupon3.setPicImageResourceId(R.drawable.jcplogo);
                otherCoupon3.setQrImageResourceId(R.drawable.jcpqr);
                realm.beginTransaction();
                realm.copyToRealmOrUpdate(otherCoupon3);
                realm.commitTransaction();


            } finally {

                // This needs to change or something else needs to change because you cannot open my deals right away
                // Error: java.lang.RuntimeException: Unable to start activity ComponentInfo{com.example.android.chargerpoints/com.example.android.chargerpoints.MyDealsActivity}:
                // java.lang.IllegalStateException: This Realm instance has already been closed, making it unusable.
                realm.close();
            }
        }
    }
}

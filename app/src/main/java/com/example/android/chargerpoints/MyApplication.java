package com.example.android.chargerpoints;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import io.realm.Realm;
import io.realm.RealmConfiguration;

import static com.example.android.chargerpoints.MainActivity.points;

/**
 * Created by ShivaniVyas on 2/2/17.
 */

public class MyApplication extends Application {

    Realm realm;
    User user;

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .schemaVersion(1)
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);

        realm = Realm.getDefaultInstance();

        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                        .build()
        );

    }

    public void onTerminate() {
        realm.beginTransaction();
        user = realm.where(User.class).equalTo("isLoggedIn", true).findFirst();
        user.setPoints(points);
        user.setLoggedIn(false);
        realm.copyToRealmOrUpdate(user);
        realm.commitTransaction();

        super.onTerminate();
    }
}

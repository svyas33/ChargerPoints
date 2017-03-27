package com.example.android.chargerpoints;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by ShivaniVyas on 3/16/17.
 */

public class Points extends RealmObject {

    @PrimaryKey
    private int id;
    private int pts = 0;

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public int getId() {
        return id;
    }

    public void setId(int ptsId) {
        this.id = ptsId;
    }

}

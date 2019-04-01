package com.frogobox.footballmvvm.model;

import android.widget.ImageView;

import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * FootBallMVVM
 * Copyright (C) 01/04/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Line     : bullbee117
 * Phone    : 081357108568
 * Majors   : D3 Teknik Informatika 2016
 * Campus   : Telkom University
 * -----------------------------------------
 * id.amirisback.frogobox
 */

@Entity(tableName = "team")
public class TeamDetail extends BaseObservable {

    @PrimaryKey(autoGenerate = true)
    public int mId;

    @ColumnInfo(name = "strTeam")
    @SerializedName("strTeam")
    public String strTeam;

    @ColumnInfo(name = "strTeamBadge")
    @SerializedName("strTeamBadge")
    public String strTeamBadge;

    public TeamDetail(int mId, String strTeam, String strTeamBadge) {
        this.mId = mId;
        this.strTeam = strTeam;
        this.strTeamBadge = strTeamBadge;
    }

    public int getmId() {
        return mId;
    }

    @Bindable
    public String getStrTeam() {
        return strTeam;
    }

    public String getStrTeamBadge() {
        return strTeamBadge;
    }

    @BindingAdapter({"strTeamBadge"})
    public static void loadImage(ImageView imageView, String imageUrl){
        Picasso.get().load(imageUrl).into(imageView);
    }

}

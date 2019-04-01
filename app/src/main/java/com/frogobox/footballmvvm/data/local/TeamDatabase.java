package com.frogobox.footballmvvm.data.local;

import android.content.Context;

import com.frogobox.footballmvvm.model.TeamDetail;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

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
@Database(entities = {TeamDetail.class}, version = 1)
public abstract class TeamDatabase extends RoomDatabase {

    private static TeamDatabase INSTANCE;
    public abstract TeamDao teamDao();
    private static final Object sLock = new Object();

    public static TeamDatabase getInstance(Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        TeamDatabase.class, "Team.db").build();
            }
            return INSTANCE;
        }
    }

}

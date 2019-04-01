package com.frogobox.footballmvvm.viewmodel;

import android.content.Context;

import com.frogobox.footballmvvm.data.TeamRepository;
import com.frogobox.footballmvvm.data.local.TeamLocalDataSource;
import com.frogobox.footballmvvm.data.remote.TeamRemoteDataSource;

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
public class Injection {

    public static TeamRepository provideTeamRepository(Context context){
        return new TeamRepository(new TeamRemoteDataSource(), new TeamLocalDataSource(context));
    }

}

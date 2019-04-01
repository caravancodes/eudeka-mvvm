package com.frogobox.footballmvvm.data.remote;

import com.frogobox.footballmvvm.model.Team;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.frogobox.footballmvvm.data.remote.ApiUrl.FinproUrl.PATH_API;

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
public interface ApiInterface {

    @GET( PATH_API + "search_all_teams.php?")
    Call<Team> getAllTeam(@Query("l") String search);

}

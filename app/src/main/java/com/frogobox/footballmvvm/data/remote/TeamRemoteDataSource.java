package com.frogobox.footballmvvm.data.remote;



import com.frogobox.footballmvvm.data.TeamDataSource;
import com.frogobox.footballmvvm.data.remote.ApiClient;
import com.frogobox.footballmvvm.data.remote.ApiInterface;
import com.frogobox.footballmvvm.model.Team;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
public class TeamRemoteDataSource implements TeamDataSource {

    private ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

    @Override
    public void getListTeams(final GetTeamsCallback callback) {

        Call<Team> call = apiInterface.getAllTeam("English Premier League");
        call.enqueue(new Callback<Team>() {
            @Override
            public void onResponse(Call<Team> call, Response<Team> response) {
                callback.onTeamLoaded(response.body());
            }

            @Override
            public void onFailure(Call<Team> call, Throwable t) {
                callback.onDataNotAvailable(t.toString());
            }
        });

    }
}

package com.frogobox.footballmvvm.data.local;

import android.content.Context;

import com.frogobox.footballmvvm.data.TeamDataSource;
import com.frogobox.footballmvvm.data.local.TeamDao;
import com.frogobox.footballmvvm.data.local.TeamDatabase;
import com.frogobox.footballmvvm.model.Team;
import com.frogobox.footballmvvm.model.TeamDetail;

import java.util.List;

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
public class TeamLocalDataSource implements TeamDataSource {

    private Context context;
    private TeamDao teamDao;

    public TeamLocalDataSource(Context context) {
        this.context = context;
        this.teamDao = TeamDatabase.getInstance(context).teamDao();
    }

    @Override
    public void getListTeams(final GetTeamsCallback callback) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final List<TeamDetail> team = teamDao.getTeams();
                if (team.isEmpty()){
                    callback.onDataNotAvailable("Data di database SQLite Kosong");
                } else {
                    Team teams = new Team(team);
                    callback.onTeamLoaded(teams);
                }
            }
        };
        new Thread(runnable).start();
    }

    public void saveDataTeam(final List<TeamDetail> teamDetail) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                teamDao.insertTeam(teamDetail);
            }
        };

        new Thread(runnable).start();
    }

}

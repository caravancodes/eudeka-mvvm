package com.frogobox.footballmvvm.viewmodel;

import android.content.Context;

import com.frogobox.footballmvvm.data.TeamDataSource;
import com.frogobox.footballmvvm.data.TeamRepository;
import com.frogobox.footballmvvm.model.Team;

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
public class TeamViewModel {

    private TeamRepository teamRepository;
    private TeamNavigator teamNavigator;

    public TeamViewModel(TeamRepository teamRepository, Context context) {
        this.teamRepository = teamRepository;
    }

    public void setTeamNavigator(TeamNavigator teamNavigator) {
        this.teamNavigator = teamNavigator;
    }

    public void getListTeam() {
        teamRepository.getListTeams(new TeamDataSource.GetTeamsCallback() {
            @Override
            public void onTeamLoaded(Team data) {
                teamNavigator.loadListTeam(data.getTeams());
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {
                teamNavigator.errorLoadListTeam(errorMessage);
            }
        });
    }
}

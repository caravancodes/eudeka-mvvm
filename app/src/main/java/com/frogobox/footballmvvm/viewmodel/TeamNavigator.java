package com.frogobox.footballmvvm.viewmodel;

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
public interface TeamNavigator {

    void loadListTeam(List<TeamDetail> listTeam);
    void errorLoadListTeam(String message);

}

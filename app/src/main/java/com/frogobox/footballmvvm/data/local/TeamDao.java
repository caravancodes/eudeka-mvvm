package com.frogobox.footballmvvm.data.local;

import com.frogobox.footballmvvm.model.TeamDetail;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

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

@Dao
public interface TeamDao {
    @Query("SELECT * FROM team")
    List<TeamDetail> getTeams();

    @Insert
    void insertTeam(List<TeamDetail> team);

}

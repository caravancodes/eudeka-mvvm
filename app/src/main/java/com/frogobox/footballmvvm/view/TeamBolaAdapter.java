package com.frogobox.footballmvvm.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.frogobox.footballmvvm.R;
import com.frogobox.footballmvvm.model.TeamDetail;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
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
public class TeamBolaAdapter extends RecyclerView.Adapter<TeamBolaAdapter.TeamBolaHolder> {

    private List<TeamDetail> listKlubBola;

    public TeamBolaAdapter(List<TeamDetail> listKlubBola) {
        this.listKlubBola = listKlubBola;
    }

    @NonNull
    @Override
    public TeamBolaHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.content_list_team, viewGroup, false);
        return new TeamBolaHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamBolaHolder klubBolaHolder, int i) {

        TeamDetail data = listKlubBola.get(i);
        klubBolaHolder.clubName.setText(data.getStrTeam());
        Picasso.get().load(data.getStrTeamBadge()).into(klubBolaHolder.clubImage);
    }

    @Override
    public int getItemCount() {
        return listKlubBola.size();
    }

    public class TeamBolaHolder extends RecyclerView.ViewHolder {

        TextView clubName;
        ImageView clubImage;

        public TeamBolaHolder(@NonNull View itemView) {
            super(itemView);
            clubName = itemView.findViewById(R.id.item_club_text);
            clubImage = itemView.findViewById(R.id.item_club_img);
        }
    }

}
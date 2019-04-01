package com.frogobox.footballmvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.frogobox.footballmvvm.R;
import com.frogobox.footballmvvm.model.TeamDetail;
import com.frogobox.footballmvvm.viewmodel.Injection;
import com.frogobox.footballmvvm.viewmodel.TeamNavigator;
import com.frogobox.footballmvvm.viewmodel.TeamViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TeamNavigator {

    private TeamViewModel teamViewModel;
    private RecyclerView recyclerView;

    private TeamBolaAdapter adapter;
    private List<TeamDetail> detailList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerTeamBola);
        teamViewModel = new TeamViewModel(Injection.provideTeamRepository(this), this);
        detailList = new ArrayList<>();
        teamViewModel.setTeamNavigator(this);
        teamViewModel.getListTeam();
        initAdapter();
    }

    private void initAdapter() {

        adapter = new TeamBolaAdapter(detailList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void loadListTeam(List<TeamDetail> listTeam) {
        detailList.addAll(listTeam);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void errorLoadListTeam(String message) {
        Log.e("Error", message);
    }
}

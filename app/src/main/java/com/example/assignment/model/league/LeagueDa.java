package com.example.assignment.model.league;

import android.os.Build;

import com.example.assignment.model.DataBase.DataBase;
import com.example.assignment.model.team.Team;

import java.util.ArrayList;
import java.util.List;

class LeagueDa implements ILeagueDa {

    @Override
    public List<League> getLeagues() {
        return DataBase.getInstance().getLeagues();
    }

    public List<String> getLeaguesNames() {
        List<String> leagues = new ArrayList<String>();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            DataBase.getInstance().getLeagues().stream().forEach(
                    league -> leagues.add(league.getName())
            );
        }

        return leagues;
    }

}

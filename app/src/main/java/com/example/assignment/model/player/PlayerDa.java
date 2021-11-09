package com.example.assignment.model.player;

import com.example.assignment.model.DataBase.DataBase;
import com.example.assignment.model.league.League;
import com.example.assignment.model.team.Team;

import java.util.List;

class PlayerDa implements IPlayerDa {
    @Override
    public List<Player>getPlayers(String leagueName) {
        List<League> leagues = DataBase.getInstance().getLeagues();

        for (League league:leagues)
            if(league.getName().equals(leagueName))
                return league.getScorers();

        return null ;
    }
}

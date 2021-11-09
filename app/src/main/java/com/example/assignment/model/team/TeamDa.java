package com.example.assignment.model.team;

import com.example.assignment.model.DataBase.DataBase;
import com.example.assignment.model.league.League;

import java.util.List;

class TeamDa implements ITeamDa{
    @Override
    public List<Team> getTeams(String leagueName) {
        List<League> leagues = DataBase.getInstance().getLeagues();

        for (League league:leagues)
            if(league.getName().equals(leagueName))
                return league.getTeams();

        return null ;
    }
}

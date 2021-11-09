package com.example.assignment.model.player;

import com.example.assignment.model.team.Team;

import java.util.List;

public interface IPlayerDa {
    List<Player> getPlayers(String leagueName);
}

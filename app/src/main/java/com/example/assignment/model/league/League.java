package com.example.assignment.model.league;

import com.example.assignment.model.player.Player;
import com.example.assignment.model.team.Team;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class League {
    private String name;
    private List<Team> teams;
    private List<Player> scorers ;

    public League setValues(String name)
    {
        setName(name);
        return this;
    }
}

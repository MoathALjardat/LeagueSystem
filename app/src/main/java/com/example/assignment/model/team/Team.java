package com.example.assignment.model.team;

import com.example.assignment.model.player.Player;

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
public class Team implements Comparable<Team> {
    private String name;
    private int score;
    private int numberOfWins;
    private int numberOfLosses;
    private int numberOfDraws;
    private int numberOfMatches ;
    private List<Player> players ;
    private String league;

    public Team setValues(String name , int numberOfWins , int numberOfLosses , int numberOfDraws,String league)
    {
        this.name = name ;
        this.numberOfWins = numberOfWins;
        this.numberOfLosses = numberOfLosses;
        this.numberOfDraws = numberOfDraws ;
        this.score = (3*numberOfWins)+numberOfDraws;
        this.league = league ;
        this.numberOfMatches = numberOfDraws+numberOfLosses+numberOfWins;
        return this;
    }

    @Override
    public int compareTo(Team team) {
        return this.score >= team.score ? 1 : -1;
    }
}

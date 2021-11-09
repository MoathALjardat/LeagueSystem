package com.example.assignment.model.player;

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
public class Player implements Comparable<Player> {

    private String name ;
    private int numberOfGoals;
    private String team ;

    public Player setValues(String name , int numberOfGoals , String team)
    {
        setName(name);
        setNumberOfGoals(numberOfGoals);
        setTeam(team);
        return this;
    }

    @Override
    public int compareTo(Player player) {
        return this.numberOfGoals >= player.numberOfGoals ? 1 : -1;
    }
}

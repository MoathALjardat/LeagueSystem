package com.example.assignment.model.DataBase;

import android.os.Build;

import com.example.assignment.model.league.League;
import com.example.assignment.model.player.Player;
import com.example.assignment.model.team.Team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;


@Getter
public class DataBase {
    private static DataBase single_instance = null;

    private List<League> leagues ;
    private List <Player> players;
    private List <Team> teams ;

    public static DataBase getInstance()
    {
        if (single_instance == null)
            single_instance = new DataBase();

        return single_instance;
    }

    private DataBase()
    {
        this.leagues = new ArrayList<League>() ;
        this.players = new ArrayList<Player>();
        this.teams = new ArrayList<Team> ();
        initialize();
    }

    private void initialize()
    {
        initializePlayers();
        initializeTeams();
        initializeLeagues();
        orderingData();
    }

    private void initializePlayers()
    {




        this.players.add(new Player().setValues("Moath",99,"Barcelona"));
        this.players.add(new Player().setValues("Habib",26,"Barcelona"));
        this.players.add(new Player().setValues("Abd",27,"Barcelona"));
        this.players.add(new Player().setValues("Yassen",39,"Barcelona"));
        this.players.add(new Player().setValues("Rami",94,"Barcelona"));

        this.players.add(new Player().setValues("Layth",29,"Real madrid"));
        this.players.add(new Player().setValues("Mahmoud",19,"Real madrid"));
        this.players.add(new Player().setValues("Samer",93,"Real madrid"));
        this.players.add(new Player().setValues("Iyad",9,"Real madrid"));
        this.players.add(new Player().setValues("Mohammad",2,"Real madrid"));

        this.players.add(new Player().setValues("Sami",91,"Athletic Club"));
        this.players.add(new Player().setValues("Sameer",19,"Athletic Club"));
        this.players.add(new Player().setValues("Samar",9,"Athletic Club"));
        this.players.add(new Player().setValues("Ahmad",3,"Athletic Club"));
        this.players.add(new Player().setValues("Ali",49,"Athletic Club"));

        this.players.add(new Player().setValues("Alaa",59,"Granada"));
        this.players.add(new Player().setValues("Amani",69,"Granada"));
        this.players.add(new Player().setValues("Bashar",79,"Granada"));
        this.players.add(new Player().setValues("Baseel",2,"Granada"));
        this.players.add(new Player().setValues("Bandar",36,"Granada"));

        this.players.add(new Player().setValues("cena",2,"Sevilla"));
        this.players.add(new Player().setValues("Dalia",22,"Sevilla"));
        this.players.add(new Player().setValues("Dana",29,"Sevilla"));
        this.players.add(new Player().setValues("Dena",34,"Sevilla"));
        this.players.add(new Player().setValues("Eman",25,"Sevilla"));


        this.players.add(new Player().setValues("Eyad",11,"Napoli"));
        this.players.add(new Player().setValues("Fadi",6,"Napoli"));
        this.players.add(new Player().setValues("Fadia",4,"Napoli"));
        this.players.add(new Player().setValues("Falah",3,"Napoli"));
        this.players.add(new Player().setValues("Faleh",1,"Napoli"));


        this.players.add(new Player().setValues("Fares",7,"AC Milan"));
        this.players.add(new Player().setValues("Feras",23,"AC Milan"));
        this.players.add(new Player().setValues("Fdwa",12,"AC Milan"));
        this.players.add(new Player().setValues("george",11,"AC Milan"));
        this.players.add(new Player().setValues("georgena",29,"AC Milan"));


        this.players.add(new Player().setValues("Hatem",22,"Inter Milan"));
        this.players.add(new Player().setValues("Hala",33,"Inter Milan"));
        this.players.add(new Player().setValues("Hamza",44,"Inter Milan"));
        this.players.add(new Player().setValues("Hamdan",55,"Inter Milan"));
        this.players.add(new Player().setValues("Hamad",66,"Inter Milan"));

        this.players.add(new Player().setValues("Hamedah",34,"Roma"));
        this.players.add(new Player().setValues("Ibraheem",23,"Roma"));
        this.players.add(new Player().setValues("Intesar",12,"Roma"));
        this.players.add(new Player().setValues("John",55,"Roma"));
        this.players.add(new Player().setValues("Kamal",56,"Roma"));


        this.players.add(new Player().setValues("Kamel",56,"Lazio"));
        this.players.add(new Player().setValues("Kamelah",45,"Lazio"));
        this.players.add(new Player().setValues("Karam",34,"Lazio"));
        this.players.add(new Player().setValues("Karim",43,"Lazio"));
        this.players.add(new Player().setValues("Karemah",23,"Lazio"));


        this.players.add(new Player().setValues("Kasandra",32,"Chelsea"));
        this.players.add(new Player().setValues("Karmel",45,"Chelsea"));
        this.players.add(new Player().setValues("Lama",54,"Chelsea"));
        this.players.add(new Player().setValues("Lamiah",9,"Chelsea"));
        this.players.add(new Player().setValues("Momen",56,"Chelsea"));

        this.players.add(new Player().setValues("Malah",23,"Liverpool"));
        this.players.add(new Player().setValues("Nader",45,"Liverpool"));
        this.players.add(new Player().setValues("Naderah",34,"Liverpool"));
        this.players.add(new Player().setValues("Naser",32,"Liverpool"));
        this.players.add(new Player().setValues("Naserah",12,"Liverpool"));

        this.players.add(new Player().setValues("Nawras",11,"Arsenal"));
        this.players.add(new Player().setValues("Nasri",22,"Arsenal"));
        this.players.add(new Player().setValues("Omar",33,"Arsenal"));
        this.players.add(new Player().setValues("Oraib",44,"Arsenal"));
        this.players.add(new Player().setValues("Orubah",55,"Arsenal"));

        this.players.add(new Player().setValues("Rafat",66,"Manchester City"));
        this.players.add(new Player().setValues("Sondos",77,"Manchester City"));
        this.players.add(new Player().setValues("Samia",24,"Manchester City"));
        this.players.add(new Player().setValues("salwa",24,"Manchester City"));
        this.players.add(new Player().setValues("samara",23,"Manchester City"));

        this.players.add(new Player().setValues("safwat",12,"Manchester United"));
        this.players.add(new Player().setValues("salman",23,"Manchester United"));
        this.players.add(new Player().setValues("sulaiman",44,"Manchester United"));
        this.players.add(new Player().setValues("soumud",88,"Manchester United"));
        this.players.add(new Player().setValues("safi",55,"Manchester United"));

        this.players.add(new Player().setValues("safa",33,"Paris Saint‑Germain"));
        this.players.add(new Player().setValues("siwar",21,"Paris Saint‑Germain"));
        this.players.add(new Player().setValues("sahar",12,"Paris Saint‑Germain"));
        this.players.add(new Player().setValues("samar",32,"Paris Saint‑Germain"));
        this.players.add(new Player().setValues("sali",1,"Paris Saint‑Germain"));

        this.players.add(new Player().setValues("safwan",2,"RC Lens"));
        this.players.add(new Player().setValues("sanaa",3,"RC Lens"));
        this.players.add(new Player().setValues("israa",4,"RC Lens"));
        this.players.add(new Player().setValues("salamah",5,"RC Lens"));
        this.players.add(new Player().setValues("salem",6,"RC Lens"));

        this.players.add(new Player().setValues("saad",76,"Nice"));
        this.players.add(new Player().setValues("saheer",66,"Nice"));
        this.players.add(new Player().setValues("taleb",55,"Nice"));
        this.players.add(new Player().setValues("waleed",65,"Nice"));
        this.players.add(new Player().setValues("wael",56,"Nice"));

        this.players.add(new Player().setValues("wahdan",45,"Lille"));
        this.players.add(new Player().setValues("zahran",1,"Lille"));
        this.players.add(new Player().setValues("yassen",21,"Lille"));
        this.players.add(new Player().setValues("yasmeen",3,"Lille"));
        this.players.add(new Player().setValues("sohaib",43,"Lille"));

        this.players.add(new Player().setValues("bairwt",2,"Marseille"));
        this.players.add(new Player().setValues("sawsan",17,"Marseille"));
        this.players.add(new Player().setValues("sama",62,"Marseille"));
        this.players.add(new Player().setValues("haneen",53,"Marseille"));
        this.players.add(new Player().setValues("ameer",41,"Marseille"));

    }

    private void initializeTeams()
    {this.teams.add(new Team().setValues("Marseille",16,10,12,"French league"));
        this.teams.add(new Team().setValues("Nice",15,16,7,"French league"));
        this.teams.add(new Team().setValues("Lille",24,3,11,"French league"));
        this.teams.add(new Team().setValues("RC Lens",15,11,12,"French league"));
        this.teams.add(new Team().setValues("Paris Saint‑Germain",26,8,4,"French league"));

        this.teams.add(new Team().setValues("Manchester United",21,6,11,"Premier league"));
        this.teams.add(new Team().setValues("Manchester City",27,6,5,"Premier league"));
        this.teams.add(new Team().setValues("Arsenal",18,13,7,"Premier league"));
        this.teams.add(new Team().setValues("Liverpool",20,9,9,"Premier league"));
        this.teams.add(new Team().setValues("Chelsea",19,9,10,"Premier league"));

        this.teams.add(new Team().setValues("Lazio",21,12,5,"Serie"));
        this.teams.add(new Team().setValues("Roma",18,12,8,"Serie"));
        this.teams.add(new Team().setValues("Inter Milan",28,3,7,"Serie"));
        this.teams.add(new Team().setValues("AC Milan",24,7,7,"Serie"));
        this.teams.add(new Team().setValues("Napoli",24,9,5,"Serie"));

        this.teams.add(new Team().setValues("Barcelona",24,7,7,"LaLiga"));
        this.teams.add(new Team().setValues("Real madrid",25,4,9,"LaLiga"));
        this.teams.add(new Team().setValues("Athletic Club",11,13,14,"LaLiga"));
        this.teams.add(new Team().setValues("Granada",13,18,7,"LaLiga"));
        this.teams.add(new Team().setValues("Sevilla",24,9,5,"LaLiga"));
    }

    private void initializeLeagues()
    {
        this.leagues.add(new League().setValues("LaLiga"));
        this.leagues.add(new League().setValues("Serie"));
        this.leagues.add(new League().setValues("Premier league"));
        this.leagues.add(new League().setValues("French league"));
    }

    private void orderingData()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            this.leagues.stream().forEach(
                    league -> league.setTeams(this.teams.stream().filter(team -> team.getLeague().equals(league.getName())).collect(Collectors.toList()))
            );

            this.teams.stream().forEach(
                    team -> team.setPlayers(this.players.stream().filter(player -> player.getTeam().equals(team.getName())).collect(Collectors.toList()))
            );

            this.leagues.stream().forEach(
                    league -> league.setScorers(
                            this.players.stream().filter(
                                    player -> league.getTeams().contains(findTeamByName(player.getTeam()))
                            ).collect(Collectors.toList())
                    )
            );

            this.leagues.stream().forEach(
                    league -> Collections.sort(league.getScorers(), Collections.reverseOrder())
            );

            this.leagues.stream().forEach(
                    league -> Collections.sort(league.getTeams(), Collections.reverseOrder())
            );
        }

    }

    private Team  findTeamByName(String name)
    {
        for (Team team : this.teams)
        {
            if (team.getName().equals(name))
                return team ;
        }
        return null ;
    }
}
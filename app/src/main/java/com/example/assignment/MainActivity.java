package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import com.example.assignment.model.player.IPlayerDa;
import com.example.assignment.model.player.Player;
import com.example.assignment.model.player.PlayerFactory;
import com.example.assignment.model.team.Team;
import com.google.gson.*;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.assignment.model.league.ILeagueDa;
import com.example.assignment.model.league.LeagueFactory;
import com.example.assignment.model.team.ITeamDa;
import com.example.assignment.model.team.TeamFactory;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner spinner ;
    RadioGroup radioGroup  ;
    private RadioButton radioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        radioButton = findViewById(R.id.radioButton8) ;
        radioGroup = findViewById(R.id.radioGroup2) ;
        radioButton.setChecked(true);

        Thread thread = new Thread(() -> {
            fillSpinner();
        });

        thread.start();

    }

    private void fillSpinner()
    {
        LeagueFactory leagueFactory = new LeagueFactory();
        ILeagueDa objectLeague = leagueFactory.getModel();

        List<String> leaguesNames =  objectLeague.getLeaguesNames();

        ArrayAdapter arrayAdapter = new ArrayAdapter(this , R.layout.support_simple_spinner_dropdown_item,leaguesNames);
        spinner.setAdapter(arrayAdapter);

    }

    public void showView(View view) {

        int selectedId = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedId);
        String league = spinner.getSelectedItem().toString();

        if (radioButton.getText().equals("Teams"))
        {   TeamFactory teamFactory = new TeamFactory();
            ITeamDa objectTeam = teamFactory.getModel();
            List<Team> teams = objectTeam.getTeams(league) ;
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
            Gson gson = new Gson();
            String js = gson.toJson(teams);
            prefsEditor.putString("object", js);
            prefsEditor.apply();
            Intent intent = new Intent(this,TeamsActivity.class) ;
            startActivity(intent);
        }
        else
        {
            PlayerFactory playerFactory = new PlayerFactory();
            IPlayerDa objectPlayer = playerFactory.getModel();
            List <Player> players = objectPlayer.getPlayers(league) ;
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
            Gson gson = new Gson();
            String js = gson.toJson(players);
            prefsEditor.putString("object", js);
            prefsEditor.apply();
            Intent intent = new Intent(this,ScoreActivity.class);
            startActivity(intent);
        }
    }
}
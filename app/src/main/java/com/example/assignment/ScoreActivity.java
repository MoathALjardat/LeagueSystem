package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ListView;
import android.widget.TextView;

import com.example.assignment.model.league.ILeagueDa;
import com.example.assignment.model.league.League;
import com.example.assignment.model.league.LeagueFactory;
import com.example.assignment.model.player.Player;
import com.example.assignment.model.player.PlayerAdabter;
import com.example.assignment.model.team.Team;
import com.example.assignment.model.team.TeamAdabter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ScoreActivity extends AppCompatActivity {

    ListView listView ;
    TextView textView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        listView = findViewById(R.id.ListViewForPlayers) ;

        Gson gson = new Gson();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String js = sharedPreferences.getString("object", "");
        Type t = new TypeToken<ArrayList<Player>>() {}.getType();
        ArrayList<Player> players = gson.fromJson(js, t);

        textView = findViewById(R.id.textViewForScore) ;
        textView.setText("Welcome to Score View");

        PlayerAdabter adabter = new PlayerAdabter(this,R.layout.player_adabter,players) ;
        listView.setAdapter(adabter) ;
    }
}
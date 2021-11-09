package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.assignment.model.player.PlayerAdabter;
import com.example.assignment.model.team.Team;
import com.example.assignment.model.team.TeamAdabter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class TeamsActivity extends AppCompatActivity {
ListView listView ;
TextView textView;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);
        listView = findViewById(R.id.listview) ;

        Gson gson = new Gson();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String js = sharedPreferences.getString("object", "");
        Type t = new TypeToken<ArrayList<Team>>() {}.getType();
        ArrayList<Team> teams = gson.fromJson(js, t);

        textView = findViewById(R.id.leagueName) ;
        textView.setText("Welcome to "+teams.get(0).getLeague());
        TeamAdabter adabter = new TeamAdabter(this,R.layout.team_adabter,teams) ;
        listView.setAdapter(adabter) ;

    }
}
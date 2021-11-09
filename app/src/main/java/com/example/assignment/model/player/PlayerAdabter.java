package com.example.assignment.model.player;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.assignment.R;

import java.util.List;

public class PlayerAdabter extends ArrayAdapter<Player> {

    public  static  final  String TAG = "PlayerAdabter";
    private Context context1 ;
    private  int resources;

    public PlayerAdabter(@NonNull Context context, int resource, @NonNull List<Player> objects) {
        super(context, resource, objects);
        context1=context;
        resources=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String name = getItem(position).getName();
        String goal = getItem(position).getNumberOfGoals()+"";
        String team = getItem(position).getTeam();

        Player player = new Player() ;

        LayoutInflater inflater = LayoutInflater.from(context1) ;
        convertView = inflater.inflate(resources,parent,false) ;

        TextView text_name = convertView.findViewById(R.id.playerName);
        TextView text_goal = convertView.findViewById(R.id.numberOfGoals);
        TextView text_team = convertView.findViewById(R.id.teamName);


        text_name.setText(name);
        text_goal.setText(goal);
        text_team.setText(team);

        return  convertView ;
    }

}



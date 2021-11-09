package com.example.assignment.model.team;

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

public class TeamAdabter extends ArrayAdapter<Team> {
    public  static  final  String TAG = "TeamAdabter";
    private Context context1 ;
    private  int resources;

    public TeamAdabter(@NonNull Context context, int resource, @NonNull List<Team> objects) {
        super(context, resource, objects);
                 context1=context;
                 resources=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String name = getItem(position).getName();
        String win = getItem(position).getNumberOfWins()+"";
        String lose = getItem(position).getNumberOfLosses()+"";
        String draw = getItem(position).getNumberOfDraws()+"";
        String score = getItem(position).getScore()+"";

        Team team = new Team() ;

        LayoutInflater inflater = LayoutInflater.from(context1) ;
        convertView = inflater.inflate(resources,parent,false) ;

        TextView text_name = convertView.findViewById(R.id.name);
        TextView text_win = convertView.findViewById(R.id.win);
        TextView text_lose = convertView.findViewById(R.id.lose);
        TextView text_draw = convertView.findViewById(R.id.draw);
        TextView text_score = convertView.findViewById(R.id.score);


        text_name.setText(name);
        text_win.setText(win);
        text_lose.setText(lose);
        text_draw.setText(draw);
        text_score.setText(score);

        return  convertView ;
    }
}

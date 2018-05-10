package com.example.akauf.numbersgame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import static com.example.akauf.numbersgame.startactivity.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class LeaderBoards extends AppCompatActivity {
    public static ArrayList<String> playername;
    public static ListView listView;
    private static String player;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_boards);
        listView = findViewById(R.id.leaderslist);
        Intent i = getIntent();
        if(i != null){
        player = i.getExtras().getString("Player");}
        playername = new ArrayList<String>();
        playername.add(player);
        load(this);
        final ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, R.layout.list_item_view, playername);
        listView.setAdapter(adapter);


    }
    @Override
    public void onActivityResult(int requestcode, int resultcode, Intent sendback){
        playername.add(sendback.getStringExtra("Player"));
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.list_item_view,playername);
        listView.setAdapter(adapter);
    }

    public void home(View view){
        Intent h = new Intent(this,MainActivity.class);
        startActivity(h);
    }

    @Override
    public void onStop(){
        super.onStop();
        SharedPreferences p = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = p.edit();
        Set<String> set = new HashSet<String>();
        set.addAll(playername);
        editor.putInt("Size",playername.size());
        for (int i = 0; i<playername.size();i++){
            editor.remove("Player"+i);
            editor.putString("Player"+i+"", playername.get(i));
        }
        editor.commit();
    }

    public void load(Context context){
        SharedPreferences p = PreferenceManager.getDefaultSharedPreferences(context);
        int size = p.getInt("Size", 0);
        for(int i = 0; i<size; i++){
            playername.add(p.getString("Player" + i, null));
        }
    }

    public void clear(View view){
        clear2(this);
    }

    public void clear2(Context context){
        SharedPreferences p = PreferenceManager.getDefaultSharedPreferences(context);
        playername.clear();
    }

}

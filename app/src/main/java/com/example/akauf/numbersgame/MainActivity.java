package com.example.akauf.numbersgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void start(View view){
        Intent intent = new Intent(this, startactivity.class);
        startActivity(intent);
    }
    public void rules(View view){
        Intent intentR = new Intent(this, Rules.class);
        startActivity(intentR);
    }
}

package com.example.akauf.numbersgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import static com.example.akauf.numbersgame.startactivity.*;

public class addname extends AppCompatActivity {
private EditText name;
private TextView attempts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addname);
    }

    public void addname(View view){
        name = findViewById(R.id.name);
        String addname = name.getText().toString();
        Intent sendback = new Intent(this, LeaderBoards.class);
        sendback.putExtra("Player", addname);
        attempts = findViewById(R.id.attempts);
        setResult(RESULT_OK, sendback);
        Toast.makeText(this, "Added to the Winner's circle", Toast.LENGTH_SHORT).show();
        startActivity(sendback);
    }
}

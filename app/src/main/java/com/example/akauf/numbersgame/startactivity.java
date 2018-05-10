package com.example.akauf.numbersgame;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class startactivity extends AppCompatActivity {
Random random = new Random();
private TextView Attempts;
private TextView Difficulty;
private EditText Guess;
private SeekBar seekBar;
private int d1 = random.nextInt(10)+1, guess2, attempt2=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startactivity);
        Attempts = findViewById(R.id.attempts);
        Difficulty = findViewById(R.id.difficultylabel);
        Guess = findViewById(R.id.guess);
        seekBar = findViewById(R.id.seekbar);
        seekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int numberbound, boolean fromUser) {
                        Difficulty.setText(numberbound+"");
                        String difficulty1 = Difficulty.getText().toString();
                        int difficulty2 = Integer.parseInt(difficulty1);
                        d1 = random.nextInt(difficulty2)+1;
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );


    }
    public void submit(final View view){
        String guess1 = Guess.getText().toString();
        guess2 = Integer.parseInt(guess1);
        attempt2 = attempt2+1;
        if ( guess2 == d1){
            final AlertDialog.Builder builder = new AlertDialog.Builder(startactivity.this);
            builder.setMessage("You Guessed The Number!" +
                    " Add your name to the Winners Circle?");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int j) {
                    addname(view);
                    reset();
                }
            });
            builder.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                    System.exit(0);
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
        else if(guess2 > d1){
            Toast.makeText(startactivity.this, "Too High", Toast.LENGTH_LONG).show();
        }
        else if(guess2 < d1){
            Toast.makeText(startactivity.this, "Too Low", Toast.LENGTH_LONG).show();
        }
        Attempts.setText(attempt2+"");
    }
    public void up(View view){
        guess2 = guess2+1;
        Attempts.setText(attempt2+"");
        Guess.setText(guess2+"");
    }
    public void down(View view){
        guess2 = guess2-1;
        Attempts.setText(attempt2+"");
        Guess.setText(guess2+"");
    }
    public void reset(){
        Attempts.setText(0+"");
        attempt2 = 0;
        Guess.setText(0+"");
        guess2 = 0;
        String difficulty1 = Difficulty.getText().toString();
        int difficulty2 = Integer.parseInt(difficulty1);
        d1 = random.nextInt(difficulty2)+1;
    }
    public void addname(View view) {
        Intent intent = new Intent(this, addname.class);
        startActivityForResult(intent, 1);
    }




}

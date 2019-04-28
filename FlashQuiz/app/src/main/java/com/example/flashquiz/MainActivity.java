package com.example.flashquiz;

import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
private Button Start;
    private Button Stats;
    private Button editflashcards;
    Stack<Flashcard> stack;
    Cursor cursor;
    Spinner s;
    Button bt;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.button18);
        setContentView(R.layout.activity_main);

        Start = (Button) findViewById(R.id.startBTN);
        final MediaPlayer mp1 = MediaPlayer.create(this, R.raw.button18);
        Start.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                mp1.start();

                openfront();
            }
        });

        Stats = (Button) findViewById(R.id.statisticsBTN);
        final MediaPlayer mp2 = MediaPlayer.create(this, R.raw.button18);
        Stats.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                mp2.start();
                open_stats();
            }
        });
        editflashcards = (Button) findViewById(R.id.editFlashcardsBTN);
        final MediaPlayer mp3 = MediaPlayer.create(this, R.raw.button18);
        editflashcards.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                mp3.start();
                open_editflash();
            }
        });

    }
    public void openfront() {
        Intent front = new Intent(this, Flashcard_Front.class);
        startActivityForResult(front, 1);
        startActivity(front);
    }
    public void open_stats() {
        Intent stats = new Intent(this, Statistics.class);
        startActivityForResult(stats, 1);
        startActivity(stats);

    }
    public void open_editflash() {
        Intent editflash = new Intent(this, Edit_Flashcard.class);
        startActivityForResult(editflash, 1);
        startActivity(editflash);
    }

}

package com.example.flashquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private Button Start;
    private Button Stats;
    private Button editflashcards;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Start = (Button) findViewById(R.id.startBTN);
        Start.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                openfront();
            }
        });

        Stats = (Button) findViewById(R.id.statisticsBTN);
        Stats.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                open_stats();
            }
        });
        editflashcards = (Button) findViewById(R.id.editFlashcardsBTN);
        editflashcards.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
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

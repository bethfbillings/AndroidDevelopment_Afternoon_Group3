package com.example.flashquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Flashcard_Back extends AppCompatActivity {

    private Button correct;
    private Button incorrect;
    private Button statistics;
    private Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard__back);

        correct = (Button) findViewById(R.id.correctBTN);
        correct.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                open_front();
            }
        });
        incorrect = (Button) findViewById(R.id.incorrectBTN);
        incorrect.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                open_front1();
            }
        });
        statistics = (Button) findViewById(R.id.statisticsBTN);
        statistics.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                open_stats();
            }
        });
        home= (Button) findViewById(R.id.homeBTN);
        home.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                open_home();
            }
        });


    }
    public void open_front() {
        Intent front = new Intent(this, Flashcard_Front.class);
        startActivityForResult(front, 1);
        startActivity(front);
    }
    public void open_front1() {
        Intent front = new Intent(this, Flashcard_Front.class);
        startActivityForResult(front, 1);
        startActivity(front);
    }
    public void open_stats() {
        Intent front = new Intent(this, Statistics.class);
        startActivityForResult(front, 1);
        startActivity(front);
    }
    public void open_home() {
        Intent front = new Intent(this, MainActivity.class);
        startActivityForResult(front, 1);
        startActivity(front);
    }
}
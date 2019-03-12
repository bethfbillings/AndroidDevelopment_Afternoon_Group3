package com.example.flashquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Flashcard_Back extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard__back);


    }
    public void statsbut(View v) {
        Intent goStats = new Intent(Flashcard_Back.this, Statistics.class);
        Flashcard_Back.this.startActivity(goStats);
    }
}
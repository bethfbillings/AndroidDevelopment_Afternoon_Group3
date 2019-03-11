package com.example.flashquiz;

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

    /*public void startButton(View v) {
        Intent start = new Intent(MainActivity.this, Flashcard_Front.class);
        MainActivity.this.startActivity(start);
    }

    public void statisticsButton(View v) {
        Intent goStats = new Intent(MainActivity.this, Statistics.class);
        MainActivity.this.startActivity(goStats);
    }

    public void editFlashcardButton(View v) {
        Intent goEdit = new Intent(MainActivity.this, Edit_Flashcard.class);
        MainActivity.this.startActivity(goEdit);
    }*/


}

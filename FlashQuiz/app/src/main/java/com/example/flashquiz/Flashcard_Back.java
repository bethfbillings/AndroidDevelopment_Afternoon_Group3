package com.example.flashquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Flashcard_Back extends AppCompatActivity {

    private Button correct;
    private Button incorrect;
    private Button statistics;
    private Button home;
    Button bt;


    int sum;
    int insum;
    SharedPreferences preferences;
    TextView backTV;
    FQS fqs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard__back);
        preferences = getSharedPreferences("STACK", MODE_PRIVATE);
        String value = preferences.getString("key", "");
        fqs = new FQS(value);
        backTV = (TextView) findViewById(R.id.flashcardBackTV);
        backTV.setText(fqs.viewBack());
        correct = (Button) findViewById(R.id.correctBTN);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.applause7);
        correct.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                fqs.timesCorrectPlus();
                fqs.timesSeenPlus();
                fqs.sendToBack();
                String temp = fqs.toString();
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("key", fqs.toString());
                editor.commit();
                open_front();
                mp.start();
                sum++;
            }
        });
        incorrect = (Button) findViewById(R.id.incorrectBTN);
        final MediaPlayer mp1 = MediaPlayer.create(this, R.raw.videoplayback);
        incorrect.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                fqs.timesSeenPlus();
                fqs.sendToBack();
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("key", fqs.toString());
                editor.commit();
                open_front1();
                mp1.start();
                insum++;
            }
        });
        statistics = (Button) findViewById(R.id.statisticsBTN);
        final MediaPlayer mp2 = MediaPlayer.create(this, R.raw.button18);
        statistics.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                open_stats();
                mp2.start();
            }
        });
        home= (Button) findViewById(R.id.homeBTN);
        final MediaPlayer mp3 = MediaPlayer.create(this, R.raw.button18);
        home.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                open_home();
                mp3.start();
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

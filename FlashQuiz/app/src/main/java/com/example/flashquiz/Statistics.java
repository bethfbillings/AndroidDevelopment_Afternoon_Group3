package com.example.flashquiz;

import android.content.Intent;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Statistics extends AppCompatActivity {
 SharedPreferences prefs;
 FQS fqs;
  TextView corrtv;
  TextView incorrtv;
float correctPercent;
float inccorrpercent;
float incorrectcards;
Integer cardsSeen;
Integer correctcards;
    Button bt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.button18);
        setContentView(R.layout.activity_statistics);
        corrtv = findViewById(R.id.correctPercentTV);
        incorrtv = findViewById(R.id.incorrectPercentTV);
        prefs = getSharedPreferences("STACK",MODE_PRIVATE);
        String corr = prefs.getString("key", "");
        fqs = new FQS(corr);
      correctPercent = fqs.correctPercent();
      cardsSeen = fqs.cardsSeen();
      correctcards =fqs.cardsCorrect();
      incorrectcards = cardsSeen-correctcards;
      inccorrpercent =cardsSeen/incorrectcards;
      String crpt = Float.toString(correctPercent);
      String icpt  =Float.toString(inccorrpercent);
      corrtv.setText(crpt);
      incorrtv.setText(icpt);



    }

    public void home(View v){
        Intent Rethome = new Intent(Statistics.this,MainActivity.class);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.button18);
        Statistics.this.startActivity(Rethome);
        mp.start();
    }


}

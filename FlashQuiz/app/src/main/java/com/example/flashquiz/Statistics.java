package com.example.flashquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.TextView;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Statistics extends AppCompatActivity {
    Button bt;
    Integer cardsSeen;
    Integer correctcards;
    SharedPreferences prefs;
    FQS fqs;
    TextView corrtv;
    TextView incorrtv;
    float correctPercent;
    float inccorrpercent;
    float incorrectcards;
    float correctper;
    TextView totalcount;
    String totes;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.button18);
        setContentView(R.layout.activity_statistics);
        corrtv = findViewById(R.id.correctPercentTV);
        incorrtv = findViewById(R.id.incorrectPercentTV);
        totalcount =findViewById(R.id.totalCountTV);

        prefs = getSharedPreferences("STACK",MODE_PRIVATE);
        String corr = prefs.getString("key", "");
        fqs = new FQS(corr);
      correctPercent = fqs.correctPercent();
      cardsSeen = fqs.cardsSeen();
      correctcards =fqs.cardsCorrect();
      correctper = (cardsSeen-incorrectcards);
      incorrectcards = cardsSeen-correctcards;
      Float tote = correctcards+incorrectcards;
      String crpt = Float.toString(correctper);
      String icpt  =Float.toString(incorrectcards);
       totes = Float.toString(cardsSeen);

      corrtv.setText(Integer.toString(fqs.cardsCorrect()));
      incorrtv.setText(Integer.toString(fqs.cardsSeen() - fqs.cardsCorrect()));
      totalcount.setText(Integer.toString(fqs.cardsSeen()));




    }

    public void home(View v){
        Intent Rethome = new Intent(Statistics.this,MainActivity.class);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.button18);
        Statistics.this.startActivity(Rethome);
        mp.start();
    }


}

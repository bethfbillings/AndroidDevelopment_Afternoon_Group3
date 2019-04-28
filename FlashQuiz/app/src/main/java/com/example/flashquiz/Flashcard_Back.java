package com.example.flashquiz;

import android.content.Intent;
import android.content.SharedPreferences;
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
    SharedPreferences preferences;
    TextView backTV;
    FQS fqs;
    int sum;
    int insum;
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
            }
        });
        incorrect = (Button) findViewById(R.id.incorrectBTN);
        incorrect.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                fqs.timesSeenPlus();
                fqs.sendToBack();
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("key", fqs.toString());
                editor.commit();
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

        Intent intent = new Intent(Flashcard_Back.this,Statistics.class);
        intent.putExtra("sumcorr",sum);
        intent.putExtra("incorrsum",insum);
        startActivity(intent);

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

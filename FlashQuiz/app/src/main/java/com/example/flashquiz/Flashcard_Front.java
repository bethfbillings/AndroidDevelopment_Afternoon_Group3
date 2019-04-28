package com.example.flashquiz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Flashcard_Front extends AppCompatActivity {
    Button bt;
private Button check;
    private Button home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard__front);

        check = (Button) findViewById(R.id.checkAnswerBTN);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.button18);
        check.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                mp.start();
                openback(v);
            }
        });
        home = (Button) findViewById(R.id.homeBTN);
        final MediaPlayer mp1 = MediaPlayer.create(this, R.raw.button18);
        home.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                mp1.start();
                openhome(v);
            }
        });
    }

    public void openback(View view) {
        Intent back = new Intent(this, Flashcard_Back.class);
        startActivityForResult(back, 1);
        startActivity(back);
    }

    public void openhome(View view) {
        Intent home = new Intent(this, MainActivity.class);
        startActivityForResult(home, 1);
        startActivity(home);
    }

}

package com.example.flashquiz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Statistics extends AppCompatActivity {
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.button18);
        setContentView(R.layout.activity_statistics);
    }

    public void home(View v){
        Intent Rethome = new Intent(Statistics.this,MainActivity.class);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.button18);
        Statistics.this.startActivity(Rethome);
        mp.start();
    }


}

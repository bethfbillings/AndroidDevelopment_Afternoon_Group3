package com.example.flashquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Statistics extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
    }

    public void home(View v){
        Intent Rethome = new Intent(Statistics.this,MainActivity.class);
        Statistics.this.startActivity(Rethome);
    }
    public void correct(View v){
        Intent correctans = new Intent(Statistics.this,Flashcard_Back.class);

    }
}

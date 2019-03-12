package com.example.flashquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Flashcard_Front extends AppCompatActivity {
private Button check;
    private Button home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard__front);

        check = (Button) findViewById(R.id.checkAnswerBTN);
        check.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                openback();
            }
        });
        home = (Button) findViewById(R.id.homeBTN);
        home.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                openhome();
            }
        });
    }

    public void openback() {
        Intent back = new Intent(this, Flashcard_Back.class);
        startActivityForResult(back, 1);
        startActivity(back);
    }

    public void openhome() {
        Intent home = new Intent(this, MainActivity.class);
        startActivityForResult(home, 1);
        startActivity(home);
    }

}

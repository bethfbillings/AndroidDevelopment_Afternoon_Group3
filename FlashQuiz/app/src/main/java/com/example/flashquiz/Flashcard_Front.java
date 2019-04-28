package com.example.flashquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Flashcard_Front extends AppCompatActivity {
private Button check;
private Button home;
FQS fqs;
Spinner s;
public SharedPreferences preferences;
String value;
TextView front;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard__front);
        preferences = getSharedPreferences("STACK", MODE_PRIVATE);
        String value = preferences.getString("key", "");
        fqs = new FQS(value);
        front = (TextView) findViewById(R.id.frontTV);
        front.setText(fqs.viewFront());
        check = (Button) findViewById(R.id.checkAnswerBTN);
        check.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                openback(v);
            }
        });
        home = (Button) findViewById(R.id.homeBTN);
        home.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
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

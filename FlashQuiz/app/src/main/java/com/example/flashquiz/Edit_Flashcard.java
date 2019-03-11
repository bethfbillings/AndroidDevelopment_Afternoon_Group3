package com.example.flashquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Edit_Flashcard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__flashcard);
    }

    public void homeButton(View v) {
        Intent goHome = new Intent(Edit_Flashcard.this, MainActivity.class);
        Edit_Flashcard.this.startActivity(goHome);
    }
}

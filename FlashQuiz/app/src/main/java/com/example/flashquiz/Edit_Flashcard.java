package com.example.flashquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Stack;

public class Edit_Flashcard extends AppCompatActivity {

    EditText frontET;
    EditText backET;
    FQS fqs;
    Spinner s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__flashcard);

        frontET = (EditText) findViewById(R.id.editFrontET);
        backET = (EditText) findViewById(R.id.editBackET);
        /*try {
            flashcards = fqs.getStack();
        } catch (NullPointerException e) {
            fqs = new FQS();
        }*/
        fqs = new FQS();
        updateSpinner();
    }

    public void updateSpinner() {
        String[] fronts = fqs.frontsToString();
        s = (Spinner) findViewById(R.id.editFlashCardSPINNER);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, fronts);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
    }


    public void goHome(View v) {
        Intent goHome = new Intent(Edit_Flashcard.this, MainActivity.class);
        startActivity(goHome);
    }

    public void newCard(View v) {
        Flashcard card = new Flashcard(frontET.getText().toString(), backET.getText().toString(), 0, 0);
        fqs.push(card);
        updateSpinner();
        Toast.makeText(getApplicationContext(),"Flashcard Created",Toast.LENGTH_SHORT).show();
        frontET.setText(fqs.frontsToString()[0]);
    }

}

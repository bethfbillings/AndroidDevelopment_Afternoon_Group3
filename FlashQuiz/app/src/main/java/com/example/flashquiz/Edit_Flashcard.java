package com.example.flashquiz;

import android.content.Intent;
import android.content.SharedPreferences;
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
    SharedPreferences preferences;
    String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__flashcard);
        preferences = getSharedPreferences("STACK", MODE_PRIVATE);
        String value = preferences.getString("key", "");
        if(value.equals("")) {
            value = "Alpha,A,0,0;";
        }
        fqs = new FQS(value);
        frontET = (EditText) findViewById(R.id.editFrontET);
        backET = (EditText) findViewById(R.id.editBackET);
        updateSpinner();
        value = s.getSelectedItem().toString();
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
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("key", fqs.toString());
        editor.commit();
    }

    public void updateText(View v) {
        value = s.getSelectedItem().toString();
        Integer cardNum = fqs.getIndex(value);
        Flashcard card = fqs.getCard(cardNum);
        frontET.setText(card.getFront());
        backET.setText(card.getBack());
    }

    public void deleteCard(View v) {
        Integer delete = fqs.getIndex(value);
        fqs.deleteCard(delete);
        Toast.makeText(getApplicationContext(), "Card deleted", Toast.LENGTH_SHORT).show();
    }

}

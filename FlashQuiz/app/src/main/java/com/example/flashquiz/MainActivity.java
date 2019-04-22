package com.example.flashquiz;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
private Button Start;
    private Button Stats;
    private Button editflashcards;
    FlashcardsStack fqs;
<<<<<<< HEAD
    FlashQuizWrapper fqDB;
=======
>>>>>>> f47eff746d8dcfd04a357ab0ea90f24365b3cbdd
    Stack<Flashcard> stack;
    Cursor cursor;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fqDB = new FlashQuizWrapper(this);
        fqDB.open();
        fqDB.insert(new Flashcard("A", "Alpha", 0, 0));
        cursor = fqDB.getAll();
        stack = new Stack<>();

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                String front = cursor.getString(cursor.getColumnIndex("front"));
                String back = cursor.getString(cursor.getColumnIndex("back"));
                Integer timesSeen = cursor.getInt(cursor.getColumnIndex("timesSeen"));
                Integer timesCorrect = cursor.getInt(cursor.getColumnIndex("timesCorrect"));

                stack.add(new Flashcard(front, back, timesSeen, timesCorrect));
                cursor.moveToNext();
            }
        }

        fqs.setFlashcards(stack);

        Start = (Button) findViewById(R.id.startBTN);
        Start.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                openfront();
            }
        });

        Stats = (Button) findViewById(R.id.statisticsBTN);
        Stats.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                open_stats();
            }
        });
        editflashcards = (Button) findViewById(R.id.editFlashcardsBTN);
        editflashcards.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                open_editflash();
            }
        });

    }
    public void openfront() {
        Intent front = new Intent(this, Flashcard_Front.class);
        startActivityForResult(front, 1);
        startActivity(front);
    }
    public void open_stats() {
        Intent stats = new Intent(this, Statistics.class);
        startActivityForResult(stats, 1);
        startActivity(stats);
    }
    public void open_editflash() {
        Intent editflash = new Intent(this, Edit_Flashcard.class);
        startActivityForResult(editflash, 1);
        startActivity(editflash);
    }

}

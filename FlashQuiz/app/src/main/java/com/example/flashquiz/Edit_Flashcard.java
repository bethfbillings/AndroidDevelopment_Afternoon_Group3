package com.example.flashquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Stack;

public class Edit_Flashcard extends AppCompatActivity {

<<<<<<< HEAD
    EditText frontET;
    EditText backET;
    FlashcardsStack fqs;
    Stack<Flashcard> flashcards;
    FlashQuizWrapper fqDB;
=======
    Stack<Flashcard> flashcards = new Stack<>();
    EditText frontET;
    EditText backET;
>>>>>>> c8e16e43cfaddd36070cbf07a5648bdce2187c20

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__flashcard);

        frontET = (EditText) findViewById(R.id.editFrontET);
        backET = (EditText) findViewById(R.id.editBackET);
<<<<<<< HEAD
        fqs = (FlashcardsStack)getApplication();
        flashcards = fqs.getFlashcards();
        fqDB = new FlashQuizWrapper(this);
=======
>>>>>>> c8e16e43cfaddd36070cbf07a5648bdce2187c20
    }


        public void goHome(View v) {
        Intent goHome = new Intent(Edit_Flashcard.this, MainActivity.class);
        startActivity(goHome);
    }

    public void newCard(View v) {
<<<<<<< HEAD
        Flashcard card = new Flashcard(frontET.getText().toString(), backET.getText().toString(), 0, 0);
        flashcards.add(card);
        fqDB.insert(card);
        Toast.makeText(getApplicationContext(),"Flashcard Created",Toast.LENGTH_SHORT).show();
    }

    public void saveFlashcards(View v) {
        
    }

=======
        Flashcard card = new Flashcard(frontET.getText().toString(), backET.getText().toString());
        flashcards.add(card);
        Toast.makeText(getApplicationContext(),"Flashcard Created",Toast.LENGTH_SHORT).show();
    }

>>>>>>> c8e16e43cfaddd36070cbf07a5648bdce2187c20
}

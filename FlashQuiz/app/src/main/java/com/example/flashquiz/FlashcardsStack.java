package com.example.flashquiz;
import android.app.Application;

import java.util.Stack;

public class FlashcardsStack extends Application {
    private Stack<Flashcard> flashcards = new Stack<>();

    public Stack<Flashcard> getFlashcards() {
        return flashcards;
    }

    public void setFlashcards(Stack<Flashcard> cards) {
        this.flashcards = cards;
    }
<<<<<<< HEAD
=======

    //Move to next flashcard
    public void pop() {
        flashcards.pop();
    }

    //Return flashcard at top of stack
    public Flashcard getTop() {
        return flashcards.peek();
    }
>>>>>>> f47eff746d8dcfd04a357ab0ea90f24365b3cbdd
}

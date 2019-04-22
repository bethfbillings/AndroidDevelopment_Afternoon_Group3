package com.example.flashquiz;
import android.app.Application;

import java.util.Iterator;
import java.util.Stack;

public class FlashcardsStack extends Application {
    private Stack<Flashcard> flashcards = new Stack<>();

    public Stack<Flashcard> getFlashcards() {
        return flashcards;
    }

    public void setFlashcards(Stack<Flashcard> cards) {
        this.flashcards = cards;
    }

    //Move to next flashcard
    public void pop() {
        flashcards.pop();
    }

    //Return flashcard at top of stack
    public Flashcard getTop() {
        return flashcards.peek();
    }

    //For edit spinner
    public String[] frontStringArr() {
        Integer cardsNum = flashcards.size();
        String[] fronts;
        if(cardsNum > 0) {
            fronts = new String[cardsNum];
            Stack<Flashcard> flashcardCP = this.flashcards;
            for (int i = 0; i < cardsNum; i++) {
                fronts[i] = flashcardCP.pop().getFront();
            }
        } else {
            fronts = new String[1];
            fronts[0] = "";
        }
        return fronts;
    }
}

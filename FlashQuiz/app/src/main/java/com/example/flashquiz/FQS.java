package com.example.flashquiz;

import java.util.Stack;

public class FQS {
    private Stack<Flashcard> stack;

    //Constructor
    //Creates empty Stack of Flashcards
    public FQS() {
        this.stack = new Stack<>();
    }

    //Returns stack of flashcards
    public Stack<Flashcard> getStack() {
            return stack;
    }

    //Sets input to stack of flashcards
    public void setStack(Stack<Flashcard> stack) {
        this.stack = stack;
    }

    //Push to stack
    public void push(Flashcard card) {
        this.stack.add(card);
    }

    //Pops top flashcard and sends it to back
    public void sendToBack() {
        Flashcard temp = this.stack.pop();
        this.stack.add(0, temp);
    }

    //View front of top flashcard without popping it
    public String viewFront() {
        return this.stack.peek().getFront();
    }

    //View back of top flashcard without popping it
    public String viewBack() {
        return this.stack.peek().getBack();
    }

    //Adds 1 to top flashcard times seen
    public void timesSeenPlus() {
        this.stack.peek().increaseTimesSeen();
    }

    //Adds 1 to top flashcard times correct
    public void timesCorrectPlus() {
        this.stack.peek().getPercentCorrect();
    }

    //Creates array of strings from front of flashcards
    //For edit_flashcard spinner
    public String[] frontsToString() {
        Integer cardsNum = this.stack.size();
        String[] fronts;
        if(cardsNum > 0) {
            fronts = new String[cardsNum];
            Flashcard[] flashcardCP = new Flashcard[cardsNum];
            stack.copyInto(flashcardCP);
            for (int i = 0; i < cardsNum; i++) {
                fronts[i] = flashcardCP[i].getFront();
            }
        } else {
            fronts = new String[1];
            fronts[0] = "";
        }
        return fronts;
    }
}

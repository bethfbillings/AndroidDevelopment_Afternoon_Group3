package com.example.flashquiz;

import android.util.Log;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class FQS {
    private Stack<Flashcard> stack;

    //Constructor no input
    //Creates empty Stack of Flashcards
    public FQS() {
        this.stack = new Stack<>();
    }

    //Constructor for array of cards input
    public FQS(Flashcard[] cards) {
        List<Flashcard> list = Arrays.asList(cards);
        this.stack.addAll(list);
    }

    //Constructor for string input
    public FQS(String s) {
        this.stack = new Stack<>();
        if(!s.isEmpty()) {
            String[] semicolons = s.split(";");
            Flashcard[] cards = new Flashcard[semicolons.length];
            for (int i = 0; i < semicolons.length; i++) {
                cards[i] = new Flashcard("", "", 0,0);
                String[] temp = semicolons[i].split(",");
                cards[i].setFront(temp[0]);
                cards[i].setBack(temp[1]);
                try {
                    cards[i].setTimesSeen(Integer.valueOf(temp[2]));
                    cards[i].setTimesCorrect(Integer.valueOf(temp[3]));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    cards[i].setTimesSeen(0);
                    cards[i].setTimesCorrect(0);
                }
            }
            List<Flashcard> list = Arrays.asList(cards);
            this.stack.addAll(list);
        }
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

    //converts stack to string
    // front,back,getTimesSeen,getTimesCorrect;
    public String toString() {
        int cardsNum = this.stack.size();
        StringBuilder bldr = new StringBuilder();
        if(cardsNum > 0) {
            Flashcard[] flashcardCP = new Flashcard[cardsNum];
            stack.copyInto(flashcardCP);
            for (int i = 0; i < cardsNum; i++) {
                bldr.append(flashcardCP[i].getFront());
                bldr.append(",");
                bldr.append(flashcardCP[i].getBack());
                bldr.append(",");
                bldr.append(flashcardCP[i].getTimesSeen());
                bldr.append(",");
                bldr.append(flashcardCP[i].getTimesCorrect());
                bldr.append(";");
            }
        }
        return bldr.toString();
    }

    //Returns index of selected front text, for edit_flashcards
    public Integer getIndex(String text) {
        Integer cardsNum = this.stack.size();
        for (int i = 0; i < cardsNum; i++) {
            if (this.stack.get(i).getFront().equals(text)) {
                return i;
            }
        }
        return null;
    }

    public Flashcard getCard(Integer idx) {
        return this.stack.get(idx);
    }

    public void deleteCard(Integer idx) {
        this.stack.remove(idx);
    }

    public int cardsSeen() {
        Integer cardsNum = this.stack.size();
        Integer cardsSeen = 0;
        for (int i = 0; i < cardsNum; i++) {
                cardsSeen = cardsSeen + this.stack.get(i).getTimesSeen();
            }
        return cardsSeen;
    }

    public int cardsCorrect() {
        Integer cardsNum = this.stack.size();
        Integer cardsCorrect = 0;
        for (int i = 0; i < cardsNum; i++) {
            cardsCorrect = cardsCorrect + this.stack.get(i).getTimesCorrect();
        }
        return cardsCorrect;
    }

    public float correctPercent() {
        Integer seen = this.cardsSeen();
        Integer correct = this.cardsCorrect();
        float percent = 0;
        if (correct != 0) {
            percent = seen / correct;
        }
        return  percent;
    }
}

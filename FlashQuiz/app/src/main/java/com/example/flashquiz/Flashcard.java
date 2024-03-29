package com.example.flashquiz;

import java.io.Serializable;

public class Flashcard implements Serializable {
    private String front;     //Front of Flashcard
    private String back;      //Back of Flashcard
    private int timesSeen;    //Number of times front of flashcard has been shown
    private int timesCorrect; //Number of times user has correctly answered flashcard
    private static final long serialVersionUID = 1L;

    public Flashcard(String front, String back, int timesSeen, int timesCorrect) {
        this.front = front;
        this.back = back;
        this.timesSeen = timesSeen;
        this.timesCorrect = timesCorrect;
    }

    public String getFront() {
        return front;
    }

    public void setFront(String front) {
        this.front = front;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }

    public int getTimesSeen() {
        return timesSeen;
    }

    public int getTimesCorrect() {
        return timesCorrect;
    }

    public void increaseTimesSeen() {
        this.timesSeen++;
    }

    public void increaseTimesCorrect() {
        this.timesCorrect++;
    }

    public void setTimesCorrect(int timesCorrect) {
        this.timesCorrect = timesCorrect;
    }

    public void setTimesSeen(int timesSeen) {
        this.timesSeen = timesSeen;
    }

    public String getPercentCorrect() {
        float correct = 0;
        correct = (float) timesCorrect / timesSeen;
        correct = correct * 100;
        return String.format("%.2f", correct); //2 decimal places
    }
}

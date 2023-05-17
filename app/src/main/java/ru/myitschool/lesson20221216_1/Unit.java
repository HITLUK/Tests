package ru.myitschool.lesson20221216_1;

import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public abstract class Unit implements Item {
private String name;
private int balls;
public static int id;
Answers[] answers;
public Unit(){}
    public Unit(String name, int balls, Answers[] answers) {
        this.name = name;
        this.balls = balls;
        this.answers = answers;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getBalls() {
        return balls;
    }
    public void setBalls(int balls) {
        this.balls = balls;
    }
    public static int getId() {
        return id;
    }
    public static void setId(int id) {
        Unit.id = id;
    }
    public Answers[] getAnswers() {
        return answers;
    }
    public void setAnswers(Answers[] answers) {
        this.answers = answers;
    }
    public abstract String Speak();
    @Override
    public void onClick(View view) {
        Snackbar.make(view,Speak()+"|"+name+"-"+balls,Snackbar.LENGTH_SHORT).show();
    }
}

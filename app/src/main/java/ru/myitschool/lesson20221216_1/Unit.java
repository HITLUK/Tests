package ru.myitschool.lesson20221216_1;

import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public abstract class Unit implements Item {
private String name;
private int balls;
public static int id;
 public static Answers[] answers;
public Unit(){}

    public Unit(int balls,String name, Answers[] answers,int id) {
        this.name = name;
        this.balls = balls;
        Unit.answers = answers;
        this.id = id;
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
    public int getId() {
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

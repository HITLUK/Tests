package ru.myitschool.lesson20221216_1;

import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Quest {
    private int score = 0;
    private int currentStep = 0;


    List<Unit> list = new ArrayList<>(Arrays.asList());
public int getlenght(){
    return list.size();
}
    public Question[] CreateTest() {
        for (Item item : Reposit.reposit.getItems()) {
            Unit unit = (Unit) item;
            list.add(unit);
        }

        return list.toArray(new Question[0]);
    }
    private  Question[] questions = CreateTest();

    public void addScore(int score) {
        this.score += score;
    }

    public Question getQuestion(int index) {
        if (index >= 0 && index < questions.length)
            return questions[index];
        return null;
    }

    public int getScore() {
        return score;
    }

    public int getCurrentStep() {
        return currentStep;
    }



}

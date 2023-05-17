package ru.myitschool.lesson20221216_1;

import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class Quest {
    private int score = 0;
    private int currentStep = 0;

    private  Question[] questions = new Question[]{
            new Question("Первый вопрос",
                    new Answers[]{
                            new Answers("+100 баллов", 100, 1),
                            new Answers("+1000 баллов", 1000, -1)
                    }),
            new Question("Второй вопрос",
                    new Answers[]{
                            new Answers("-100 баллов", -1, 0),
                            new Answers("-100 баллов", 50, 1),
                            new Answers("-10 баллов", -10, -2)
                    })
            ,
            new Question("Третий вопрос",
                    new Answers[]{
                            new Answers("-100 баллов", +100, 0),
                            new Answers("-10 баллов", -10, -1)
                    })

    };


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

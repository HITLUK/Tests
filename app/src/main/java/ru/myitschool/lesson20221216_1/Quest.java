package ru.myitschool.lesson20221216_1;

import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Quest {
    private int score = 0;
    private int currentStep = 0;
    private int maxscore = 0;
    private boolean iscreaded = MenuActivity.isIscreated();
    public int getMaxscore(){
        return maxscore;
    }
    List<Unit> list = new ArrayList<>(Arrays.asList());
public int getlenght() {
    if (iscreaded) {
        return list.size();
    } else {
        return 3;
    }
}
    public Question[] CreateTest() {
        if (iscreaded) {
            for (Item item : Reposit.reposit.getItems()) {
                Unit unit = (Unit) item;
                list.add(unit);
                maxscore += unit.getBalls();
            }

            return list.toArray(new Question[0]);
        } else {
            return new Question[]{
                    new Question(1,"Первый вопрос",
                            new Answers[]{
                                    new Answers("Правильный", 1, 1),
                                    new Answers("Неправильный", 0, 1),
                                    new Answers("Неправильный", 0, 1),
                                    new Answers("Неправильный", 0, 1)
                            },1)
                    ,
                    new Question(1,"Второй вопрос",
                            new Answers[]{
                                    new Answers("Неправильный", 0, 2),
                                    new Answers("Неправильный", 0, 2),
                                    new Answers("Неправильный", 0, 2),
                                    new Answers("Правильный", 1, 2)
                            },1)
                    ,
                    new Question(1,"Третий вопрос",
                            new Answers[]{
                                    new Answers("Неправильный", 0, 3),
                                    new Answers("Неправильный", 0, 3),
                                    new Answers("Правильный", 1, 3),
                                    new Answers("Неправильный", 0, 3)
                            },1)
            };
        }
    }
    private Question[] questions = CreateTest();

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

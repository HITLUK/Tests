package ru.myitschool.lesson20221216_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Quest {
    private int score = 0;
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
                    new Question(1,"Сколько всего материков на земле?",
                            new Answers[]{
                                    new Answers("4", 0, 1),
                                    new Answers("5", 0, 1),
                                    new Answers("6", 1, 1),
                                    new Answers("7", 0, 1)
                            },1)
                    ,
                    new Question(1,"В древнегреческой мифологии Немезида была крылатой богиней",
                            new Answers[]{
                                    new Answers("Воды", 0, 2),
                                    new Answers("Красоты", 0, 2),
                                    new Answers("Победы", 0, 2),
                                    new Answers("Возмездия", 1, 2)
                            },1)
                    ,
                    new Question(1,"Какое из этих слов пишется с НЕ слитно?",
                            new Answers[]{
                                    new Answers("(не)увидев", 0, 3),
                                    new Answers("(не)нужно", 0, 3),
                                    new Answers("(не)втерпеж", 1, 3),
                                    new Answers("(не)спится", 0, 3)
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

}

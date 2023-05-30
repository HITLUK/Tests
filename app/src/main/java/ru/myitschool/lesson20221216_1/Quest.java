package ru.myitschool.lesson20221216_1;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Quest {
    private int score = 0;
    private int maxscore = 0;
    List<String> names = new ArrayList<>(Arrays.asList());
    List<String> balls1 = new ArrayList<>(Arrays.asList());
    List<String> Ans1s = new ArrayList<>(Arrays.asList());
    List<String> Ans2s = new ArrayList<>(Arrays.asList());
    List<String> Ans3s = new ArrayList<>(Arrays.asList());
    List<String> Ans4s = new ArrayList<>(Arrays.asList());
    List<String> Ans1bs = new ArrayList<>(Arrays.asList());
    List<String> Ans2bs = new ArrayList<>(Arrays.asList());
    List<String> Ans3bs = new ArrayList<>(Arrays.asList());
    List<String> Ans4bs = new ArrayList<>(Arrays.asList());
    List<String> Ans3is = new ArrayList<>(Arrays.asList());
    List<String> Ans4is = new ArrayList<>(Arrays.asList());
    Context context;
    Prefs prefs;
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

    public Quest(Context context) {
        this.context = context;

    }

    public Question[] CreateTest() {
this.prefs = MenuActivity.prefs;
int a = 0;
        if (iscreaded) {
            for (Item item : Reposit.reposit.getItems()) {
                a++;
                Unit unit = (Unit) item;
                String s = "false";
                String t = "false";
                if(unit.getAnswers()[2].isIsreal()) {s = "true";}
                if(unit.getAnswers()[3].isIsreal()) {t = "true";}
                names.add(unit.getName());
                balls1.add(""+unit.getBalls());
                Ans1s.add(unit.getAnswers()[0].getName());
                Ans2s.add(unit.getAnswers()[1].getName());
                Ans3s.add(unit.getAnswers()[2].getName());
                Ans4s.add(unit.getAnswers()[3].getName());
                Ans1bs.add(unit.getAnswers()[0].getScore()+"");
                Ans2bs.add(unit.getAnswers()[1].getScore()+"");
                Ans3bs.add(unit.getAnswers()[2].getScore()+"");
                Ans4bs.add(unit.getAnswers()[3].getScore()+"");
                Ans3is.add(s);
                Ans4is.add(t);
                list.add(unit);
                maxscore += unit.getBalls();
            }
            Gson gson = new Gson();
            String nammes = gson.toJson(names);
            String balls = gson.toJson(balls1);
            String Anss1s = gson.toJson(Ans1s);
            String Anss2s = gson.toJson(Ans2s);
            String Anss3s = gson.toJson(Ans3s);
            String Anss4s = gson.toJson(Ans4s);
            String Anss1bs = gson.toJson(Ans1bs);
            String Anss2bs = gson.toJson(Ans2bs);
            String Anss3bs = gson.toJson(Ans3bs);
            String Anss4bs = gson.toJson(Ans4bs);
            String Is3 = gson.toJson(Ans3is);
            String Is4 = gson.toJson(Ans4is);
            prefs.setnameq(nammes);
            prefs.setBalls(balls);
            prefs.setAns1(Anss1s);
            prefs.setAns2(Anss2s);
            prefs.setAns3(Anss3s);
            prefs.setAns4(Anss4s);
            prefs.setAns1b(Anss1bs);
            prefs.setAns2b(Anss2bs);
            prefs.setAns3b(Anss3bs);
            prefs.setAns4b(Anss4bs);
            prefs.setAns3i(Is3);
            prefs.setAns4i(Is4);
            prefs.setCount(a);
            return list.toArray(new Question[0]);
        } else {
            return new Question[]{
                    new Question(1,"Сколько всего материков на земле?",
                            new Answers[]{
                                    new Answers("4", 0, 1, true),
                                    new Answers("5", 0, 1, true),
                                    new Answers("6", 1, 1, true),
                                    new Answers("7", 0, 1, true)
                            },1)
                    ,
                    new Question(1,"В древнегреческой мифологии Немезида была крылатой богиней",
                            new Answers[]{
                                    new Answers("Воды", 0, 2, true),
                                    new Answers("Красоты", 0, 2, true),
                                    new Answers("Победы", 0, 2, true),
                                    new Answers("Возмездия", 1, 2, true)
                            },2)
                    ,
                    new Question(1,"Какое из этих слов пишется с НЕ слитно?",
                            new Answers[]{
                                    new Answers("(не)увидев", 0, 3, true),
                                    new Answers("(не)нужно", 0, 3, true),
                                    new Answers("(не)втерпеж", 1, 3, true),
                                    new Answers("(не)спится", 0, 3, true)
                            },3)
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

package ru.myitschool.lesson20221216_1;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reposit {
    Prefs prefs;
    List<String> names ;
    List<String> balls1;
    List<String> Ans1s ;
    List<String> Ans2s ;
    List<String> Ans3s ;
    List<String> Ans4s ;
    List<String> Ans1bs;
    List<String> Ans2bs;
    List<String> Ans3bs;
    List<String> Ans4bs;
    List<String> Ans3is;
    List<String> Ans4is;
     public static Reposit reposit = new Reposit();
    public Reposit() {
        this.prefs = MenuActivity.prefs;
    }

    public void addUnit(Unit unit) {
        addItem(unit);
    }
public void addtoShared(Unit unit) {
    names = new ArrayList<>();
    balls1 = new ArrayList<>();
    Ans1s = new ArrayList<>();
    Ans2s = new ArrayList<>();
    Ans3s = new ArrayList<>();
    Ans4s = new ArrayList<>();
    Ans1bs = new ArrayList<>();
    Ans2bs = new ArrayList<>();
    Ans3bs = new ArrayList<>();
    Ans4bs = new ArrayList<>();
    Ans3is = new ArrayList<>();
    Ans4is = new ArrayList<>();
    names.add(unit.getName());
    balls1.add("" + unit.getBalls());
    Ans1s.add((unit.getAnswers()[0].getName()));
    Ans2s.add((unit.getAnswers()[1].getName()));
    Ans3s.add((unit.getAnswers()[2].getName()));
    Ans4s.add((unit.getAnswers()[3].getName()));
    Ans1bs.add(unit.getAnswers()[0].getScore() + "");
    Ans2bs.add(unit.getAnswers()[1].getScore() + "");
    Ans3bs.add(unit.getAnswers()[2].getScore() + "");
    Ans4bs.add(unit.getAnswers()[3].getScore() + "");
    prefs.setCount(1);
    String b = "false";
    String t = "false";
    if(unit.getAnswers()[2].isIsreal()) {b = "true";}
    if(unit.getAnswers()[3].isIsreal()) {t = "true";}
    Ans3is.add(b);
    Ans4is.add(t);
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
}

public void fillrepo() {
    Gson gson = new Gson();
    Type listType = new TypeToken<List<String>>() {
    }.getType();
    names = gson.fromJson(prefs.getnameq(), listType);
    balls1 = gson.fromJson(prefs.getBalls(), listType);
    Ans1s = gson.fromJson(prefs.getAns1(), listType);
    Ans2s = gson.fromJson(prefs.getAns2(), listType);
    Ans3s = gson.fromJson(prefs.getAns3(), listType);
    Ans4s = gson.fromJson(prefs.getAns4(), listType);
    Ans1bs = gson.fromJson(prefs.getAns1b(), listType);
    Ans2bs = gson.fromJson(prefs.getAns2b(), listType);
    Ans3bs = gson.fromJson(prefs.getAns3b(), listType);
    Ans4bs = gson.fromJson(prefs.getAns4b(), listType);
    Ans4is = gson.fromJson(prefs.getAns4i(), listType);
    Ans3is = gson.fromJson(prefs.getAns3i(), listType);
    for(int i = 0;i<prefs.getCount();i++) {
        Unit unit = new Question(Integer.parseInt(balls1.get(i)),names.get(i),new Answers[] {
                new Answers(Ans1s.get(i),Integer.parseInt(Ans1bs.get(i)),i+1,true),
                new Answers(Ans2s.get(i),Integer.parseInt(Ans2bs.get(i)),i+1,true),
                new Answers(Ans3s.get(i),Integer.parseInt(Ans3bs.get(i)),i+1,Boolean.parseBoolean(Ans3is.get(i))),
                new Answers(Ans4s.get(i),Integer.parseInt(Ans4bs.get(i)),i+1,Boolean.parseBoolean(Ans4is.get(i)))
        },i);
     Reposit.reposit.addUnit(unit);
    }
}
    public void updateShared(Unit unit) {

            Gson gson = new Gson();
            Type listType = new TypeToken<List<String>>() {
            }.getType();
            names = gson.fromJson(prefs.getnameq(), listType);
            balls1 = gson.fromJson(prefs.getBalls(), listType);
            Ans1s = gson.fromJson(prefs.getAns1(), listType);
            Ans2s = gson.fromJson(prefs.getAns2(), listType);
            Ans3s = gson.fromJson(prefs.getAns3(), listType);
            Ans4s = gson.fromJson(prefs.getAns4(), listType);
            Ans1bs = gson.fromJson(prefs.getAns1b(), listType);
            Ans2bs = gson.fromJson(prefs.getAns2b(), listType);
            Ans3bs = gson.fromJson(prefs.getAns3b(), listType);
            Ans4bs = gson.fromJson(prefs.getAns4b(), listType);
            Ans4is = gson.fromJson(prefs.getAns4i(), listType);
            Ans3is = gson.fromJson(prefs.getAns3i(), listType);

        names.add(unit.getName());
        balls1.add("" + unit.getBalls());
        Ans1s.add((unit.getAnswers()[0].getName()));
        Ans2s.add((unit.getAnswers()[1].getName()));
        Ans3s.add((unit.getAnswers()[2].getName()));
        Ans4s.add((unit.getAnswers()[3].getName()));
        Ans1bs.add(unit.getAnswers()[0].getScore() + "");
        Ans2bs.add(unit.getAnswers()[1].getScore() + "");
        Ans3bs.add(unit.getAnswers()[2].getScore() + "");
        Ans4bs.add(unit.getAnswers()[3].getScore() + "");
        prefs.setCount(prefs.getCount()+1);
        String b = "false";
        String t = "false";
        if(unit.getAnswers()[2].isIsreal()) {b = "true";}
        if(unit.getAnswers()[3].isIsreal()) {t = "true";}
        Ans3is.add(b);
        Ans4is.add(t);
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
    }
    private Item[] items = new Item[0];
    public Unit getUnit(int i) {
        return (Unit) items[i];
    }

    public Item[] getItems() {
        return items;
    }
    public void setUnit(Item unit,int i) {setItem(unit,i);}
    public void setItem(Item item,int i) {
        items[i] = item;

    }
    public void clear(){
        items = Arrays.copyOf(items,0);
    }
    private void addItem(Item item) {
        items = Arrays.copyOf(items, items.length + 1);
        items[items.length - 1] = item;
    }
}

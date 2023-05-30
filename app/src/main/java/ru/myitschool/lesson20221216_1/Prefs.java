package ru.myitschool.lesson20221216_1;

import android.content.SharedPreferences;

import java.util.List;

public class Prefs {
    private final static String KEY_REZ = "KEY_REZ";
private final static String KEY_QUEST = "KEY_QUEST";
    private final static String Balls = "Balls";
    private final static String Ans1 = "Ans1";
    private final static String Ans2 = "Ans2";
    private final static String Ans3 = "Ans3";
    private final static String Ans4 = "Ans4";
    private final static String Ans1b = "Ans1b";
    private final static String Ans2b = "Ans2b";
    private final static String Ans3b = "Ans3b";
    private final static String Ans4b = "Ans4b";
    private final static String Ans3i = "Ans3i";
    private final static String Ans4i = "Ans4i";
    private final static String count = "count";
    private final static String KEY_ISCREATED = "KEY_ISCREATED";

public int getCount() {return sharedPreferences.getInt(count,0);}
    public void setCount(int a) {sharedPreferences.edit().putInt(count,a).apply();}
    public String getnameq() {
        return sharedPreferences.getString(KEY_QUEST,"");
    }
    public void setnameq(String a) {
        sharedPreferences.edit().putString(KEY_QUEST,a).apply();
    }
    public String getBalls() {return sharedPreferences.getString(Balls,"");}
    public String getAns1() {return sharedPreferences.getString(Ans1,"");}
    public String getAns2() {return sharedPreferences.getString(Ans2,"");}
    public String getAns3() {return sharedPreferences.getString(Ans3,"");}
    public String getAns4() {return sharedPreferences.getString(Ans4,"");}
    public String getAns1b() {return sharedPreferences.getString(Ans1b,"");}
    public String getAns2b() {return sharedPreferences.getString(Ans2b,"");}
    public String getAns3b() {return sharedPreferences.getString(Ans3b,"");}
    public String getAns4b() {return sharedPreferences.getString(Ans4b,"");}
    public String getAns3i() {return sharedPreferences.getString(Ans3i,"");}
    public String getAns4i() {return sharedPreferences.getString(Ans4i,"");}

    public void setBalls(String a) {sharedPreferences.edit().putString(Balls,a).apply();}
    public void setAns1(String a) {sharedPreferences.edit().putString(Ans1,a).apply();}
    public void setAns2(String a) {sharedPreferences.edit().putString(Ans2,a).apply();}
    public void setAns3(String a) {sharedPreferences.edit().putString(Ans3,a).apply();}
    public void setAns4(String a) {sharedPreferences.edit().putString(Ans4,a).apply();}
    public void setAns1b(String a) {sharedPreferences.edit().putString(Ans1b,a).apply();}
    public void setAns2b(String a) {sharedPreferences.edit().putString(Ans2b,a).apply();}
    public void setAns3b(String a) {sharedPreferences.edit().putString(Ans3b,a).apply();}
    public void setAns4b(String a) {sharedPreferences.edit().putString(Ans4b,a).apply();}
    public void setAns3i(String a) {sharedPreferences.edit().putString(Ans3i,a).apply();}
    public void setAns4i(String a) {sharedPreferences.edit().putString(Ans4i,a).apply();}


    public final static String REZ = "REZ";
    private final SharedPreferences sharedPreferences;

    public Prefs(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public boolean getcr() {
        return sharedPreferences.getBoolean(KEY_ISCREATED,false);
    }
    public void setcr() {sharedPreferences.edit().putBoolean(KEY_ISCREATED,true).apply();}

    public void setREZ(float REZ) {
        sharedPreferences.edit().putFloat(KEY_REZ, REZ).apply();
    }

    public float getREZ() {
        return sharedPreferences.getFloat(KEY_REZ, 0);
    }

}

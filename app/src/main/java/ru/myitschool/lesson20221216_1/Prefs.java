package ru.myitschool.lesson20221216_1;

import android.content.SharedPreferences;

public class Prefs {
    private final static String KEY_REZ = "KEY_REZ";
    public final static String REZ = "REZ";
    private final SharedPreferences sharedPreferences;

    public Prefs(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public void setREZ(float REZ) {
        sharedPreferences.edit().putFloat(KEY_REZ, REZ).apply();
    }

    public float getREZ() {
        return sharedPreferences.getFloat(KEY_REZ, 0);
    }
}

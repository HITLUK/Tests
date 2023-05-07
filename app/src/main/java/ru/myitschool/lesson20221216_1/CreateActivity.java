package ru.myitschool.lesson20221216_1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import ru.myitschool.lesson20221216_1.databinding.ActivityGameBinding;
import ru.myitschool.lesson20221216_1.databinding.ItemButtonBinding;

public class CreateActivity extends AppCompatActivity {
    private ActivityGameBinding binding;
    private final Quest quest = new Quest();
    private PrefsManager prefsManager;
    private PrefsManager prefsManager1;
    static int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGameBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        prefsManager = new PrefsManager(getSharedPreferences(PrefsManager.NAME, MODE_PRIVATE));
        prefsManager1 = new PrefsManager(getSharedPreferences(PrefsManager.COUNT, MODE_PRIVATE));
        Quest quest = new Quest();
    }

    public static Intent getInstance(Context context) {
        return new Intent(context, CreateActivity.class);
    }

}
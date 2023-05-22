package ru.myitschool.lesson20221216_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ContentInfo;
import android.view.View;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.Objects;

import ru.myitschool.lesson20221216_1.databinding.ActivityMenuBinding;

public class MenuActivity extends AppCompatActivity {
    private ActivityMenuBinding binding;
    public static boolean iscreated = false;
    private Prefs prefs;
    public static Intent getInstance(Context context) {
        return new Intent(context, MenuActivity.class);
    }
public static boolean isIscreated() {
        return iscreated;
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        prefs = new Prefs(getSharedPreferences(Prefs.REZ,MODE_PRIVATE));
        binding.last.setText("Последний результат: "+prefs.getREZ()+"%");
        binding.play.setOnClickListener(view -> {
            startActivity(GameActivity.getInstance(this));

        });
        binding.create.setOnClickListener(view -> {
            startActivity(CreateActivity.getInstance(this));

        });


    }

    @Override
    protected void onResume() {
        super.onResume();
    }


}
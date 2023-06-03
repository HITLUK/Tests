package ru.myitschool.lesson20221216_1;


import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ru.myitschool.lesson20221216_1.databinding.ActivityCreateBinding;
import ru.myitschool.lesson20221216_1.databinding.ItemUserBinding;

public class CreateActivity extends AppCompatActivity {

    private ActivityCreateBinding binding;
    public static int idquestion = 0;
    public static int edited = 0;
    public boolean iscr;
    public static int ed;
    Prefs prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs = new Prefs(getSharedPreferences(Prefs.REZ, MODE_PRIVATE));
        binding = ActivityCreateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Reposit.reposit.clear();
        Reposit.reposit.fillrepo();
        filllist();
        binding.add.setOnClickListener(view -> startActivity(AddActivity.getInstance(this)));
        binding.edit.setOnClickListener(view -> {
            if (binding.edited.getText().toString().isEmpty()) {
                Toast.makeText(this, "Вы не выбрали вопрос", Toast.LENGTH_SHORT).show();
            } else {
                edited = Integer.parseInt(binding.edited.getText().toString()) - 1;
                startActivity(EditActivity.getInstance(this));
            }
        });
        binding.stop.setOnClickListener(view -> {
            if (iscr) {
                MenuActivity.iscreated = true;
            }
            MenuActivity.prefs.setcr();
            startActivity(MenuActivity.getInstance(this));
        });
    }

    public static Intent getInstance(Context context) {
        return new Intent(context, CreateActivity.class);
    }
    public void filllist(){
        binding.container.removeAllViews();
        ed = 1;
        for(Item item : Reposit.reposit.getItems()) {
            iscr = true;
            Unit unit = (Unit) item;
            ItemUserBinding userBinding = ItemUserBinding.inflate(getLayoutInflater());
            userBinding.idquestion.setText(Integer.toString(ed));
            userBinding.name.setText(unit.getName());
            userBinding.bals.setText(Integer.toString(unit.getBalls()));
            binding.container.addView(userBinding.getRoot());
            ed++;
        }
    }
    public static int getIDquestion(){
        return idquestion;
    }
    public static void setIDquestion() {
        idquestion++;
    }
}
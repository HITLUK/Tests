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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs = new Prefs(getSharedPreferences(Prefs.REZ, MODE_PRIVATE));
        binding = ActivityCreateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        iscr = false;
        int a = prefs.getCount();

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
        Reposit.reposit.clear();
        for (int i = 0; i < Ans3is.size()-1; i++) {
            Boolean i3 = false;
            Boolean i4 = false;
            if (Boolean.parseBoolean(Ans3is.get(i))) {
                i3 = true;
            }
            if (Boolean.parseBoolean(Ans4is.get(i))) {
                i4 = true;
            }

            Unit unit = new Question(Integer.parseInt(balls1.get(i)), names.get(i), new Answers[]{
                    new Answers(Ans1s.get(i), Integer.parseInt(Ans1bs.get(i)), i+1 , true),
                    new Answers(Ans2s.get(i), Integer.parseInt(Ans1bs.get(i)), i +1, true),
                    new Answers(Ans3s.get(i), Integer.parseInt(Ans1bs.get(i)), i +1, i3),
                    new Answers(Ans4s.get(i), Integer.parseInt(Ans1bs.get(i)), i +1, i4)
            }, i);
            Reposit.reposit.addUnit(unit);
        }

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
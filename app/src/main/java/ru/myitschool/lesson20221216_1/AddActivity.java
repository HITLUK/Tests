package ru.myitschool.lesson20221216_1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ru.myitschool.lesson20221216_1.databinding.ActivityAddBinding;

public class AddActivity extends AppCompatActivity {
    private ActivityAddBinding binding;
    private int sc1, sc2, sc3, sc4;
public boolean isful;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {

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

        prefs = new Prefs(getSharedPreferences(prefs.REZ,MODE_PRIVATE));
        super.onCreate(savedInstanceState);
        binding = ActivityAddBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.balls.setText("1");
        sc1 = 0;
        isful = false;
        sc2 = 0;
        sc3 = 0;
        sc4 = 0;
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
        binding.compl.setOnClickListener(view -> {
            addquest();
            if(isful) {
                startActivity(CreateActivity.getInstance(this));
            }
            });
    }

    public static Intent getInstance(Context context) {
        return new Intent(context, AddActivity.class);
    }

    private void clearInput() {
        binding.inputQuest.setText("");
        binding.ans1.setText("");
        binding.ans2.setText("");
        binding.ans3.setText("");
        binding.ans4.setText("");
        binding.inputQuest.clearFocus();
        binding.ans1.clearFocus();
        binding.ans2.clearFocus();
        binding.ans3.clearFocus();
        binding.ans4.clearFocus();
        binding.radioGroup.clearCheck();
    }

    public void addquest() {
        boolean is1 = true;
        boolean is2 = true;
        boolean is3 = false;
        boolean is4 = false;
        if (binding.ans1.getText().toString().isEmpty() ||
                binding.ans2.getText().toString().isEmpty() ||
                (!binding.radio1.isChecked() && !binding.radio2.isChecked()
                        && !binding.radio3.isChecked() && !binding.radio4.isChecked()) || binding.inputQuest.getText().toString().isEmpty() || binding.balls.getText().toString().isEmpty()) {
            Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show();
        } else {
            if (!binding.ans3.getText().toString().isEmpty()) {is3=true;}
            if (!binding.ans4.getText().toString().isEmpty()) {is4=true;}
            isful = true;
            CreateActivity.setIDquestion();
            if (binding.radio1.isChecked()) {
                sc1 = Integer.parseInt(binding.balls.getText().toString());
            }
            if (binding.radio2.isChecked()) {
                sc2 = Integer.parseInt(binding.balls.getText().toString());
            }
            if (binding.radio3.isChecked()) {
                sc3 = Integer.parseInt(binding.balls.getText().toString());
            }
            if (binding.radio4.isChecked()) {
                sc4 = Integer.parseInt(binding.balls.getText().toString());
            }
            int bals = Integer.parseInt(binding.balls.getText().toString());
            int id = CreateActivity.getIDquestion();
            String name = binding.inputQuest.getText().toString();
            Answers[] answers = new Answers[]{
                    new Answers(binding.ans1.getText().toString(), sc1, 1, is1),
                    new Answers(binding.ans2.getText().toString(), sc2, 1, is2),
                    new Answers(binding.ans3.getText().toString(), sc3, 1, is3),
                    new Answers(binding.ans4.getText().toString(), sc4, 1, is4)
            };
            Unit unit = new Question(bals, name, answers, id);
            Reposit.reposit.addUnit(unit);
            if(!prefs.getcr()) {
                Reposit.reposit.addtoShared(unit);
            } else {
                Reposit.reposit.updateShared(unit);
            }
            clearInput();
        }
    }
}
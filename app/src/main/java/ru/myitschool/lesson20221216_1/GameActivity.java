package ru.myitschool.lesson20221216_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;

import ru.myitschool.lesson20221216_1.databinding.ActivityGameBinding;
import ru.myitschool.lesson20221216_1.databinding.ItemButtonBinding;

public class GameActivity extends AppCompatActivity {
    private ActivityGameBinding binding;
    private final Quest quest = new Quest(this);
    static int count=0;
    private Prefs prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGameBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        prefs = new Prefs(getSharedPreferences(Prefs.REZ,MODE_PRIVATE));
        initQuestion(0);
        binding.number.setText("1/"+quest.getlenght());
count = 0;
    }
    public static Intent getInstance(Context context) {
        return new Intent(context, GameActivity.class);
    }
    public void initQuestion(int stepNumber) {
        count++;
        if(quest.getlenght()==1) {
            setNegativeState();
        } else {
            if (quest.getlenght() == count) {
                setPositiveState();
            } else {
                setQuestionState(stepNumber);
            }
        }
    }
    private void setPositiveState() {
        binding.number.setText("");
        if(MenuActivity.iscreated) {
            float s = (float)(Math.round((float)quest.getScore() * 10000 / quest.getMaxscore()))/100;
            prefs.setREZ(s);
            binding.description.setText("Вы завершили прохождение теста.\nВаш результат- " + quest.getScore() + "/" + quest.getMaxscore() + " (" + s + "%)");
        } else {
            float s = (float)(Math.round((float)quest.getScore() * 10000 / 3))/100;
            prefs.setREZ(s);
            binding.description.setText("Вы завершили прохождение теста.\nВаш результат- " + quest.getScore() + "/3 (" + s + "%)");
        }
        fillCloseButton();
    }
    private void setNegativeState() {
            binding.description.setText("Добавьте больше вопросов");
        fillCloseButton();
    }



    private void fillCloseButton() {
        binding.buttons.removeAllViews();
        ItemButtonBinding buttonBinding = ItemButtonBinding.inflate(getLayoutInflater(),
                binding.buttons,
                false);
        buttonBinding.getRoot().setText("Выход в главное меню");
        buttonBinding.getRoot().setOnClickListener(v -> startActivity(MenuActivity.getInstance(this)));
        binding.buttons.addView(buttonBinding.getRoot());


    }

    private void setQuestionState(int stepNumber) {
        binding.number.setText(stepNumber+1+"/"+quest.getlenght());
        Question question = quest.getQuestion(stepNumber);
        binding.description.setText(question.getName());
        fillButton(question.getAnswers());
    }

    private void fillButton(Answers[] answers) {
        binding.buttons.removeAllViews();
        for (Answers answer : answers) {
            if (answer.isIsreal()) {
                ItemButtonBinding buttonBinding = ItemButtonBinding.inflate(getLayoutInflater(),
                        binding.buttons,
                        false);
                buttonBinding.getRoot().setText(answer.getName());
                buttonBinding.getRoot().setOnClickListener(v -> {
                    goNext(answer);
                });
                binding.buttons.addView(buttonBinding.getRoot());
            }
        }
    }
    private void goNext(Answers answer) {
        quest.addScore(answer.getScore());
        initQuestion(answer.getNextStep());
    }
}
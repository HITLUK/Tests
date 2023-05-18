package ru.myitschool.lesson20221216_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import ru.myitschool.lesson20221216_1.databinding.ActivityGameBinding;
import ru.myitschool.lesson20221216_1.databinding.ItemButtonBinding;

public class GameActivity extends AppCompatActivity {
    private ActivityGameBinding binding;
    private final Quest quest = new Quest();
    static int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGameBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initQuestion(0);
count = 0;
    }
    public static Intent getInstance(Context context) {
        return new Intent(context, GameActivity.class);
    }
    public void initQuestion(int stepNumber) {
        count++;
if(quest.getlenght() == count) {
    setPositiveState();
} else {
    setQuestionState(stepNumber);
}
    }
    private void setPositiveState() {
        if(MenuActivity.iscreated) {
            binding.description.setText("Вы завершили прохождение теста.\nВаш результат- " + quest.getScore() + "/" + quest.getMaxscore() + " (" + (float) quest.getScore() / quest.getMaxscore() * 100 + "%)");
        } else {
            binding.description.setText("Вы завершили прохождение теста.\nВаш результат- " + quest.getScore() + "/3 (" + (float) quest.getScore() / 3 * 100 + "%)");
        }
        fillCloseButton();
    }




    private void fillCloseButton() {
        binding.buttons.removeAllViews();
        ItemButtonBinding buttonBinding = ItemButtonBinding.inflate(getLayoutInflater(),
                binding.buttons,
                false);
        buttonBinding.getRoot().setText("Выход в главное меню");
        buttonBinding.getRoot().setOnClickListener(v -> finish());
        binding.buttons.addView(buttonBinding.getRoot());


    }

    private void setQuestionState(int stepNumber) {
        Question question = quest.getQuestion(stepNumber);
        binding.description.setText(question.getName());
        fillButton(question.getAnswers());
    }

    private void fillButton(Answers[] answers) {
        binding.buttons.removeAllViews();
        for (Answers answer : answers) {
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
    private void goNext(Answers answer) {
        quest.addScore(answer.getScore());
        initQuestion(answer.getNextStep());
    }
}
package ru.myitschool.lesson20221216_1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ru.myitschool.lesson20221216_1.databinding.ActivityAddBinding;

public class EditActivity extends AppCompatActivity {
    private ActivityAddBinding binding;
    public int sc1, sc2, sc3, sc4, idthis;
    public boolean isfull;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        isfull = false;
        sc1 = 0;
        sc2 = 0;
        sc3 = 0;
        sc4 = 0;
        idthis = 0;
        loadquest(Reposit.reposit.getUnit(CreateActivity.edited));
        binding.compl.setOnClickListener(view -> {
            editquest();
            if (isfull) {
                startActivity(CreateActivity.getInstance(this));
            }
            });
    }

    public static Intent getInstance(Context context) {
        return new Intent(context, EditActivity.class);
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

    public void loadquest(Unit question) {
        binding.inputQuest.setText(question.getName());
        idthis = CreateActivity.edited;
        Answers[] may = question.getAnswers();
        int a = question.getBalls();
        binding.ans1.setText(may[0].getName());
        binding.ans2.setText(may[1].getName());
        binding.ans3.setText(may[2].getName());
        binding.ans4.setText(may[3].getName());
        binding.balls.setText(Integer.toString(a));
        if (may[0].getScore() != 0) {
            binding.radio1.setChecked(true);
        }
        if (may[1].getScore() != 0) {
            binding.radio1.setChecked(true);
        }
        if (may[2].getScore() != 0) {
            binding.radio1.setChecked(true);
        }
        if (may[3].getScore() != 0) {
            binding.radio1.setChecked(true);
        }
    }

    public void editquest() {
        if (binding.ans1.getText().toString().isEmpty() ||
                binding.ans2.getText().toString().isEmpty() ||
                binding.ans3.getText().toString().isEmpty() ||
                binding.ans4.getText().toString().isEmpty() ||
                (!binding.radio1.isChecked() && !binding.radio2.isChecked()
                        && !binding.radio2.isChecked() && !binding.radio4.isChecked()) || binding.inputQuest.getText().toString().isEmpty() || binding.balls.getText().toString().isEmpty()) {
            Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show();
        } else {
            isfull = true;
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
            String name = binding.inputQuest.getText().toString();
            Answers[] answers = new Answers[]{
                    new Answers(binding.ans1.getText().toString(), sc1, 1),
                    new Answers(binding.ans2.getText().toString(), sc2, 1),
                    new Answers(binding.ans3.getText().toString(), sc3, 1),
                    new Answers(binding.ans4.getText().toString(), sc4, 1)
            };
            Unit unit = new Question(bals, name, answers, idthis);
            Reposit.reposit.setUnit(unit, idthis);
            clearInput();
        }
    }
}
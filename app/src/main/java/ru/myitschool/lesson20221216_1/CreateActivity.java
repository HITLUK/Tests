package ru.myitschool.lesson20221216_1;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import ru.myitschool.lesson20221216_1.databinding.ActivityCreateBinding;
import ru.myitschool.lesson20221216_1.databinding.ItemUserBinding;

public class CreateActivity extends AppCompatActivity {
    private ActivityCreateBinding binding;
public static int idquestion = 0;
public static int edited = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        filllist();
        binding.add.setOnClickListener(view -> startActivity(AddActivity.getInstance(this)));
        binding.edit.setOnClickListener(view -> {
                    edited = Integer.parseInt(binding.edited.getText().toString());
            Toast.makeText(this,Integer.toString(edited),Toast.LENGTH_LONG).show();
                    startActivity(EditActivity.getInstance(this));
                });
        binding.stop.setOnClickListener(view -> {
            MenuActivity.iscreated = true;
            startActivity(MenuActivity.getInstance(this));
        });
    }

    public static Intent getInstance(Context context) {
        return new Intent(context, CreateActivity.class);
    }
   public void filllist(){
       binding.container.removeAllViews();
       int ed = 1;
for(Item item : Reposit.reposit.getItems()) {
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
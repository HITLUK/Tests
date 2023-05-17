package ru.myitschool.lesson20221216_1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import ru.myitschool.lesson20221216_1.databinding.ActivityCreateBinding;
import ru.myitschool.lesson20221216_1.databinding.ItemUserBinding;

public class CreateActivity extends AppCompatActivity {
    private ActivityCreateBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        filllist();
        binding.add.setOnClickListener(view -> startActivity(AddActivity.getInstance(this)));
        binding.stop.setOnClickListener(view -> startActivity(MenuActivity.getInstance(this)));
    }
    public static Intent getInstance(Context context) {
        return new Intent(context, CreateActivity.class);
    }
   public void filllist(){
for(Item item : Reposit.reposit.getItems()) {
    Unit unit = (Unit) item;
    ItemUserBinding userBinding = ItemUserBinding.inflate(getLayoutInflater());
    userBinding.name.setText(unit.getName());
    binding.container.addView(userBinding.getRoot());
}
    }
}
package com.example.lutemon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TrainingActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private Button btnTrain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_training);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        radioGroup = findViewById(R.id.rgTrainee);
        btnTrain = findViewById(R.id.btnTrain);

        loadLutemons();

        btnTrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trainSelectedLutemon();
            }
        });
    }

    private void loadLutemons() {
        for (Lutemon lutemon : Storage.getInstance().getAllLutemons()) {
            RadioButton rb = new RadioButton(this);
            rb.setText(lutemon.getName() + " (" + lutemon.getColor() + ")");
            rb.setId(lutemon.getId());
            radioGroup.addView(rb);
        }
    }

    private void trainSelectedLutemon() {
        int selectedId = radioGroup.getCheckedRadioButtonId();

        if (selectedId == -1) {
            Toast.makeText(this, "Please select a Lutemon to train!", Toast.LENGTH_SHORT).show();
            return;
        }

        Lutemon selectedLutemon = Storage.getInstance().getLutemon(selectedId);
        if (selectedLutemon != null) {
            selectedLutemon.gainExperience(5); // Give 5 exp for training
            selectedLutemon.training += 1; // Track trainings
            Toast.makeText(this, selectedLutemon.getName() + " gained experience from training!", Toast.LENGTH_SHORT).show();
            if (selectedLutemon.getExperience() >= 10) {
                selectedLutemon.levelUp();
            }
        } else {
            Toast.makeText(this, "Error: Lutemon not found!", Toast.LENGTH_SHORT).show();
        }
    }


    public void switchToMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
package com.example.lutemon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CreateLutemonActivity extends AppCompatActivity {

    private EditText lutemonName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_lutemon);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lutemonName = findViewById(R.id.TxtFldName);
    }

    public void createLutemon(View view) {
        RadioGroup rgLutemonType = findViewById(R.id.rgLutemonType);
        int identity = rgLutemonType.getCheckedRadioButtonId();
        String name = lutemonName.getText().toString();
        Lutemon lusikka = null;
        if (identity == R.id.rbBlack) {
            lusikka = new Black(name);
        } else if (identity == R.id.rbGreen) {
            lusikka = new Green(name);
        } else if (identity == R.id.rbPink) {
            lusikka = new Pink(name);
        } else if (identity == R.id.rbWhite) {
            lusikka = new White(name);
        } else if (identity == R.id.rbOrange) {
            lusikka = new Orange(name);
        } else {
            // make sure the user picks a type first
            Toast.makeText(this, "Choose a type of Lutemon to create!", Toast.LENGTH_SHORT).show();
            return;
        }
        // if the creation is successful, add to storage
        if (lusikka != null) {
            Storage.getInstance().addLutemon(lusikka);
            Toast.makeText(this, "Your Lutemon has been created!", Toast.LENGTH_SHORT).show();
        }
    }

    public void switchToMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
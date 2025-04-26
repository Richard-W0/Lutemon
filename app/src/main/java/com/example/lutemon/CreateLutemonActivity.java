package com.example.lutemon;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CreateLutemonActivity extends AppCompatActivity {

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
    }

    public void addLutemon(View view) {
        RadioGroup rgLutemonType = findViewById(R.id.rgLutemonType);
        int identity = rgLutemonType.getCheckedRadioButtonId();
        if (identity == R.id.rbBlack) {

        } else if (identity == R.id.rbGreen) {

        } else if (identity == R.id.rbPink) {

        } else if (identity == R.id.rbWhite) {

        } else if (identity == R.id.rbOrange) {

        } else {
            // pyydä käyttäjää valitsemaan lutemonin tyyppi ensin
        }
    }
}
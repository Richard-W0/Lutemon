package com.example.lutemon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

public class BattleActivity extends AppCompatActivity {

    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_battle);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textView = findViewById(R.id.btlTxtFld);
    }

    public void fight(Lutemon lutemon1, Lutemon lutemon2) {
        textView.setText(String.format("%s is fighting %s!", lutemon1.getName(), lutemon2.getName()));

        // TO DO: if check että 0 hp lutemonit ei pääse tappeluun asti TAI molemmille palautetaan
        //        täys HP ennen taistelua

        while (lutemon1.getHealth() > 0 && lutemon2.getHealth() > 0) {
            printLutemonInfo(lutemon1, lutemon2);
            // lutemon 1 attacks
            combat(lutemon1, lutemon2);

            if (lutemon2.getHealth() <= 0) {
                battleEnd(lutemon1, lutemon2);
            }

            printLutemonInfo(lutemon1, lutemon2);
            // lutemon 2 attacks
            combat(lutemon2, lutemon1);

            if (lutemon1.getHealth() <= 0) {
                battleEnd(lutemon2, lutemon1);
            }
        }
    }

    public void combat(Lutemon attacker, Lutemon defender) {
        textView.append('\n' + String.format("%s (%s) attacks %s (%s)!", attacker.getName(),
                attacker.getColor(), defender.getName(), defender.getColor()));
        int damage = attacker.getAttack();
        defender.takeDamage(damage);
    }

    public void battleEnd(Lutemon victor, Lutemon loser) {
        victor.incrementWins();
        loser.incrementLosses();
        textView.append('\n' + String.format("%s has been defeated by %s!", loser.getName(), victor.getName()));
        victor.gainExperience(10);
    }

    public void printLutemonInfo(Lutemon lutemon1, Lutemon lutemon2) {
        textView.append('\n' + String.format("1: %s (%s) att: %s; def: %s; exp: %s; health: %s/%s",
                lutemon1.getName(), lutemon1.getColor(), lutemon1.getAttack(), lutemon1.getDefense(),
                lutemon1.getExperience(), lutemon1.getHealth(), lutemon1.getMaxHealth()));
        textView.append('\n' + String.format("2: %s (%s) att: %s; def: %s; exp: %s; health: %s/%s",
                lutemon2.getName(), lutemon2.getColor(), lutemon2.getAttack(), lutemon2.getDefense(),
                lutemon2.getExperience(), lutemon2.getHealth(), lutemon2.getMaxHealth()));
    }

    public void switchToMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
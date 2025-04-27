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
        textView.setText(lutemon1.getName() + " is fighting " + lutemon2.getName() + "!");

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

    public void printLutemonInfo(Lutemon lutemon1, Lutemon lutemon2) {
        textView.append('\n' + "1." + lutemon1.getName() + " (" + lutemon1.getColor() + ") att: " +
                lutemon1.getAttack() + "; def: " + lutemon1.getDefense() + "; exp: " +
                lutemon1.getExperience() + "; health: " + lutemon1.getHealth() + "/" +
                lutemon1.getMaxHealth());
        textView.append('\n' + "1." + lutemon2.getName() + " (" + lutemon2.getColor() + ") att: " +
                lutemon2.getAttack() + "; def: " + lutemon2.getDefense() + "; exp: " +
                lutemon2.getExperience() + "; health: " + lutemon2.getHealth() + "/" +
                lutemon2.getMaxHealth());
    }

    public void combat(Lutemon attacker, Lutemon defender) {
        textView.append('\n' + attacker.getName() + " (" + attacker.getColor() + ") attacks" +
                defender.getName() + " (" + defender.getColor() + ")");
        int damage = attacker.getAttack();
        defender.takeDamage(damage);
    }

    public void battleEnd(Lutemon victor, Lutemon loser) {
        victor.incrementWins();
        loser.incrementLosses();
        textView.append('\n' + loser.getName() + " has been defeated by" + victor.getName() + "!");
        victor.gainExperience(10);
    }

    public void switchToMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
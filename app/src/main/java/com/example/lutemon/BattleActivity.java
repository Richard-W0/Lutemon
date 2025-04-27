package com.example.lutemon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.Collections;

public class BattleActivity extends AppCompatActivity {

    private TextView textView;
    private ChipGroup chipGroupBattle;
    private Button btnFight;

    private ArrayList<Lutemon> selectedLutemons = new ArrayList<>(); // stores selected lutemons

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
        chipGroupBattle = findViewById(R.id.chipGroupBattle);
        btnFight = findViewById(R.id.btnFight);

        loadLutemons();

        btnFight.setOnClickListener(v -> {
            if (selectedLutemons.size() != 2) {
                textView.setText("Select exactly 2 Lutemons to battle!");
            } else {
                fight(selectedLutemons.get(0), selectedLutemons.get(1));
            }
        });

        Button btnLeaderboard = findViewById(R.id.btnLeaderboard);

        btnLeaderboard.setOnClickListener(v -> {
            showLeaderboardPopup();
        });
    }

    private void loadLutemons() {
        for (Lutemon lutemon : Storage.getInstance().getAllLutemons()) {
            Chip chip = new Chip(this);
            chip.setText(lutemon.getName() + " (" + lutemon.getColor() + ")");
            chip.setCheckable(true);
            chip.setId(lutemon.getId());

            chip.setOnCheckedChangeListener((buttonView, isChecked) -> {
                Lutemon selected = Storage.getInstance().getLutemon(buttonView.getId());
                if (isChecked) {
                    if (selectedLutemons.size() < 2) {
                        selectedLutemons.add(selected);
                    } else {
                        buttonView.setChecked(false); // uncheck if already 2 selected
                        textView.setText("You can only select 2 Lutemons!");
                    }
                } else {
                    selectedLutemons.remove(selected);
                }
            });

            chipGroupBattle.addView(chip);
        }
    }

    public void fight(Lutemon lutemon1, Lutemon lutemon2) {
        textView.setText(String.format("%s is fighting %s!\n", lutemon1.getName(), lutemon2.getName()));

        // Restore full health before battle
        lutemon1.setHealth(lutemon1.getMaxHealth());
        lutemon2.setHealth(lutemon2.getMaxHealth());

        while (lutemon1.getHealth() > 0 && lutemon2.getHealth() > 0) {
            printLutemonInfo(lutemon1, lutemon2);

            combat(lutemon1, lutemon2);

            if (lutemon2.getHealth() <= 0) {
                battleEnd(lutemon1, lutemon2);
                return;
            }

            combat(lutemon2, lutemon1);

            if (lutemon1.getHealth() <= 0) {
                battleEnd(lutemon2, lutemon1);
                return;
            }
        }
    }

    public void combat(Lutemon attacker, Lutemon defender) {
        textView.append(String.format("\n%s attacks %s!", attacker.getName(), defender.getName()));
        int damage = attacker.getAttack();
        defender.takeDamage(damage);
    }

    public void battleEnd(Lutemon winner, Lutemon loser) {
        textView.append(String.format("\n%s has been defeated by %s!", loser.getName(), winner.getName()));
        winner.incrementWins();
        loser.incrementLosses();
        winner.gainExperience(10);
    }

    public void printLutemonInfo(Lutemon lutemon1, Lutemon lutemon2) {
        textView.append(String.format("\n1: %s HP: %d/%d \n 2: %s HP: %d/%d",
                lutemon1.getName(), lutemon1.getHealth(), lutemon1.getMaxHealth(),
                lutemon2.getName(), lutemon2.getHealth(), lutemon2.getMaxHealth()));
    }

    public void switchToMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void showLeaderboardPopup() {
        ArrayList<Lutemon> lutemonList = new ArrayList<>(Storage.getInstance().getAllLutemons());

        Collections.sort(lutemonList, (l1, l2) -> Integer.compare(l2.getWins(), l1.getWins()));

        StringBuilder builder = new StringBuilder();
        for (Lutemon l : lutemonList) {
            builder.append(l.getName())
                    .append(" (Wins: ")
                    .append(l.getWins())
                    .append(")\n");
        }

        new AlertDialog.Builder(this)
                .setTitle("Leaderboard")
                .setMessage(builder.toString())
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .show();
    }
}

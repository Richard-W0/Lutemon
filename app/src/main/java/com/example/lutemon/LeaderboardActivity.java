package com.example.lutemon;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Collection;

public class LeaderboardActivity extends AppCompatActivity {

    private TextView leaderboardTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        leaderboardTextView = findViewById(R.id.leaderboardTextView);

        showLeaderboard();
    }

    private void showLeaderboard() {
        // Get all lutemons from storage
        Collection<Lutemon> lutemonCollection = Storage.getInstance().getAllLutemons();

        // Copy into an ArrayList so we can sort
        ArrayList<Lutemon> lutemonList = new ArrayList<>(lutemonCollection);

        // Sort by wins descending
        Collections.sort(lutemonList, (l1, l2) -> Integer.compare(l2.getWins(), l1.getWins()));

        StringBuilder builder = new StringBuilder();
        for (Lutemon l : lutemonList) {
            builder.append(l.getName())
                    .append(" (Wins: ")
                    .append(l.getWins())
                    .append(")\n");
        }

        leaderboardTextView.setText(builder.toString());
    }
}

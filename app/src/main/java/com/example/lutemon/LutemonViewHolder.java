package com.example.lutemon;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonViewHolder extends RecyclerView.ViewHolder {
    ImageView lutemonImage;
    TextView lutemonName, lutemonAttack, lutemonDefense, lutemonHealth, lutemonExp, lutemonStats;

    public LutemonViewHolder(@NonNull View itemView) {
        super(itemView);
        lutemonImage = itemView.findViewById(R.id.ltmnImage);
        lutemonName = itemView.findViewById(R.id.ltmnName);
        lutemonAttack = itemView.findViewById(R.id.ltmnAttack);
        lutemonDefense = itemView.findViewById(R.id.ltmnDefense);
        lutemonHealth = itemView.findViewById(R.id.ltmnHP);
        lutemonExp = itemView.findViewById(R.id.ltmnExperience);
        lutemonStats = itemView.findViewById(R.id.ltmnStatistics);
    }
}

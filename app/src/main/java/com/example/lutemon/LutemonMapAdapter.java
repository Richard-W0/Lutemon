package com.example.lutemon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;

public class LutemonMapAdapter extends RecyclerView.Adapter<LutemonViewHolder> {
    private Context context;
    private Storage storage;

    public LutemonMapAdapter(Context context, Storage storage) {
        this.context = context;
        this.storage = Storage.getInstance();
    }

    @NonNull
    @Override
    public LutemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonViewHolder holder, int position) {
        holder.lutemonImage.setImageResource(storage.getLutemon(position).getImage());
        holder.lutemonName.setText(storage.getLutemon(position).getName());
        holder.lutemonAttack.setText("Attack: " + storage.getLutemon(position).getAttack());
        holder.lutemonHealth.setText(String.format("Health: %s / %s", storage.getLutemon(position).getHealth(),
                storage.getLutemon(position).getMaxHealth()));
        holder.lutemonExp.setText("Level: " + storage.getLutemon(position).getLevel() + " Experience: " + storage.getLutemon(position).getExperience() + "/10");
        holder.lutemonStats.setText(String.format("wins: %s | losses: %s", storage.getLutemon(position).getWins(),
                storage.getLutemon(position).getLosses()));
        if (storage.getLutemon(position).getName().equals("Bibi")) {
            holder.lutemonDefense.setText("Defense: " + storage.getLutemon(position).getDefense() + ",  Intelligence: -10");
        } else if (storage.getLutemon(position).getName().equals("Nita")) {
            holder.lutemonDefense.setText("Defense: " + storage.getLutemon(position).getDefense() + ",  Intelligence: -5");
        } else {
            holder.lutemonDefense.setText("Defense: " + storage.getLutemon(position).getDefense());
        }
    }

    @Override
    public int getItemCount() {
        return storage.getLutemonCount();
    }
}

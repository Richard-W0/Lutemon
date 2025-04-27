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
        this.storage = storage;
    }

    @NonNull
    @Override
    public LutemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonViewHolder holder, int position) { // ei toimi koska int position ei obvs oo sen id :(
        holder.lutemonName.setText(storage.getLutemon(position).getName());
        holder.lutemonAttack.setText(storage.getLutemon(position).getAttack());
        holder.lutemonDefense.setText(storage.getLutemon(position).getDefense());
        holder.lutemonHealth.setText(String.format("%s / %s", storage.getLutemon(position).getHealth(),
                storage.getLutemon(position).getMaxHealth()));
        holder.lutemonExp.setText(storage.getLutemon(position).getExperience());
        holder.lutemonStats.setText(String.format("wins: %s | losses: %s", storage.getLutemon(position).getWins(),
                storage.getLutemon(position).getLosses()));
    }

    @Override
    public int getItemCount() {
        return storage.getLutemonCount();
    }
}

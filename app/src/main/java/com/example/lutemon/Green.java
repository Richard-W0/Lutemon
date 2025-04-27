package com.example.lutemon;

public class Green extends Lutemon {
    public Green(String name) {
        super(name);
        this.color = "Green";
        this.attack = 6;
        this.defense = 3;
        this.maxHealth = 19;
        this.health = this.maxHealth;
        this.image = R.drawable.frog;
    }
}

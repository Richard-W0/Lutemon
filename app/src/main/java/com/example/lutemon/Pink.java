package com.example.lutemon;

public class Pink extends Lutemon {
    public Pink(String name) {
        super(name);
        this.color = "Pink";
        this.attack = 7;
        this.defense = 2;
        this.maxHealth = 18;
        this.health = this.maxHealth;
        this.image = R.drawable.piggy;
    }
}

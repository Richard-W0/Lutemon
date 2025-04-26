package com.example.lutemon;

public class White extends Lutemon {
    public White(String name) {
        super(name);
        this.color = "White";
        this.attack = 5;
        this.defense = 4;
        this.maxHealth = 20;
        this.health = this.maxHealth;
    }
}

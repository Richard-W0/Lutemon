package com.example.lutemon;

public class Orange extends Lutemon {
    public Orange(String name) {
        super(name);
        this.color = "Orange";
        this.attack = 8;
        this.defense = 1;
        this.maxHealth = 17;
        this.health = this.maxHealth;
    }
}

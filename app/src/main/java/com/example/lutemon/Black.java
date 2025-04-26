package com.example.lutemon;

public class Black extends Lutemon {
    public Black(String name) {
        super(name);
        this.color = "Black";
        this.attack = 9;
        this.defense = 0;
        this.maxHealth = 16;
        this.health = this.maxHealth;
    }
}

package com.example.lutemon;

public class Orange extends Lutemon {
    public Orange(String name) {
        super(name);
        this.color = "Orange";
        this.attack = 8;
        this.defense = 1;
        this.maxHealth = 17;
        this.health = this.maxHealth;
        if (name.equals("Bibi")) { // check if the name matches our cats :)
            this.image = R.drawable.bibi;
            this.defense = 0;
            this.attack = 10;
        } else if (name.equals("Nita")) {
            this.image = R.drawable.nita;
            this.defense = 5;
        } else {
            this.image = R.drawable.tigerface;
        }
    }
}

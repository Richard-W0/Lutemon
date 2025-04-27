package com.example.lutemon;

public class Lutemon {
    String name;
    String color;
    int health;
    int maxHealth;
    int attack;
    int defense;
    int level;
    int experience;
    int id;
    int wins;
    int losses;
    int training;

    public static int idCounter;

    public Lutemon(String name) {
        this.name = name;
        this.experience = 0;
        this.wins = 0;
        this.losses = 0;
        this.training = 0;
        this.id = idCounter++; // se kuuluu tänne lol
    }

    public void levelUp() {
        this.level = this.level + 1;
        this.experience = 0;
        // idCounter++; // kuuluko tän olla täällä....? --> vastaus: ei, sen id ei kasva levelin mukaan :D
    }

    public static int getNumberOfCreatedLutemons() {
        return Storage.getInstance().getLutemonCount();
    }

    public String getName() {
        return this.name;
    }

    public int getId(){ return this.id; }

    public String getColor(){
        return this.color;
    }
}

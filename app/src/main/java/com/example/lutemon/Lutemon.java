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

    public static int idCounter;

    public Lutemon(String name) {
        this.name = name;
        this.experience = 0;
    }

    public void levelUp() {
        this.level = this.level + 1;
        this.experience = 0;
        idCounter++;
    }

    public int getNumberOfCreatedLutemons() {
        // code here
        int i = 1; // temp koodi ettei se valita :D
        return i;
    }

    public String getName() {
        return this.name;
    }
}

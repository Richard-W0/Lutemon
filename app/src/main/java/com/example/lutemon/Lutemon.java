package com.example.lutemon;

public class Lutemon {
    protected String name;
    protected String color;
    protected int image;
    protected int health;
    protected int maxHealth;
    protected int attack;
    protected int defense;
    protected int level;
    protected int experience;
    protected int id;
    protected int wins;
    protected int losses;
    protected int training;

    public static int idCounter;

    public Lutemon(String name) {
        this.name = name;
        this.experience = 0;
        this.wins = 0;
        this.losses = 0; // lol se jää tähän en jaksa säätää pois
        this.training = 0;
        this.id = idCounter++; // se kuuluu tänne lol
    }

    public void levelUp() { // tää ei oo tehtävänannon mukainen.....
        //this.level = this.level + 1;  smh et muista mitään ohjelmoinnin perusteist....
        this.level++;
        this.experience = 0;
        // idCounter++; // kuuluko tän olla täällä....? --> vastaus: ei, sen id ei kasva levelin mukaan :D

        this.attack += 1;    // esimerkki kasvu
        this.defense += 1;   // esimerkki kasvu
        this.maxHealth += 3; // esimerkki kasvu
        this.health = maxHealth; // perus pokemon full heal level upist
    }

    public static int getNumberOfCreatedLutemons() {
        return Storage.getInstance().getLutemonCount();
    }

    public void takeDamage(int damage) {
        int actualDamage = damage - this.defense;
        if (actualDamage < 0) {
            actualDamage = 0; // no healing the enemy by attacking lol
        }
        this.health -= actualDamage;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public void gainExperience(int exp) {
        this.experience += exp;
        if (this.experience >= 10) { // esimerkki level up määrä
            levelUp();
        }
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public void incrementWins() {
        this.wins++;
    }

    public void incrementLosses() {
        this.losses++;
    }

    public String getName() {
        return this.name;
    }

    public int getId(){ return this.id; }

    public String getColor(){
        return this.color;
    }

    public int getAttack() { return this.attack; }

    public int getDefense() { return this.defense; }

    public int getHealth() { return this.health; }

    public int getMaxHealth() { return this.maxHealth; }

    public int getExperience() { return this.experience; }

    public int getLosses() { return this.losses; }

    public int getWins() { return this.wins; }

    public int getImage() { return this.image; }

    public int getLevel() { return this.level; }
}


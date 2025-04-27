package com.example.lutemon;

// outdated class that was merged into BattleActivity and remains unused - but a reminder of how far we've come...

public class BattleField{

    public BattleField(String name){
    }

    public void fight(Lutemon lutemon1, Lutemon lutemon2) {
        System.out.println(lutemon1.getName() + " is fighting " + lutemon2.getName() + "!");

        while (lutemon1.getHealth() > 0 && lutemon2.getHealth() > 0) {
            // lutemon 1 attacks
            int damage1 = lutemon1.getAttack();
            lutemon2.takeDamage(damage1);

            if (lutemon2.getHealth() <= 0) {
                System.out.println(lutemon2.getName() + " has DIED!"); // käytä sitä toastia tähän tekstiin en nyt jaksa tää on helpompaa
                break;
            }

            // lutemon 2 attacks
            int damage2 = lutemon2.getAttack();
            lutemon1.takeDamage(damage2);

            if (lutemon1.getHealth() <= 0) {
                System.out.println(lutemon1.getName() + " has DIED!");
                break;
            }
        }

        // after the fight
        lutemon1.incrementWins();
        lutemon2.incrementLosses();

        // experience to winner
        if (lutemon1.getHealth() > 0) {
            lutemon1.gainExperience(10);
            System.out.println(lutemon1.getName() + " wins!");
        } else if (lutemon2.getHealth() > 0) {
            lutemon2.gainExperience(10);
            System.out.println(lutemon2.getName() + " wins!");
        }
    }
}


package com.example.lutemon;
import java.util.Collection;
import java.util.HashMap;

public class Storage {
    private static Storage storage = null;

    private String name;
    private HashMap<Integer, Lutemon> lutemons; // miks sitä ei alusteta suoraan tässä vaan pitää mennä getInstance:n kautta?

    // Private constructor: prevents creating multiple storages
    private Storage() {
        this.name = "Lutemon Storage";
        this.lutemons = new HashMap<>(); // pitäiskö rajottaa olemassaolevien lutemonien määrää? mut sit pitäis olla myös käyttäjälle keino poistaa niitä....
    }

    public static Storage getInstance() {
        if (storage == null) {
            storage = new Storage();
        }
        return storage;
    }

    public void addLutemon(Lutemon lutemon) {
        lutemons.put(lutemon.getId(), lutemon);
    }

    public Lutemon getLutemon(int id) {
        return lutemons.get(id);
    }

    public void listLutemons() {
        for (Lutemon lutemon : lutemons.values()) {
            System.out.println("ID: " + lutemon.getId() + ", Name: " + lutemon.getName() + ", Color: " + lutemon.getColor());
        }
    }

    public int getLutemonCount() {
        return lutemons.size();
    }

    public Collection<Lutemon> getAllLutemons() {
        return lutemons.values();
    }
}
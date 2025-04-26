package com.example.lutemon;
import java.util.HashMap;

public class Storage {
    private HashMap<Integer, Lutemon> Lutemons;
    private String name;

    public Storage(String, name){
        this.name = name;
        this.Lutemons = new HashMap<>();
    }
    public void addLutemon(Lutemon lutemon){
        Lutemons.put(Lutemon.getId(), lutemon);
    }

    public Lutemon getLutemon(int id){
        return Lutemons.get(id);
    }

    public void listLutemons(){
        for (Lutemon lutemon : Lutemons.values()){
            System.out.println("ID: " + lutemon.getId() + ", Name: " + lutemon.getName() + ", Color: " + lutemon.getColor());
        }
    }
}

package br.ufrn.imd.model;

import java.util.ArrayList;

public class Player {
    private String name;
    ArrayList<Ship> ships;

    public Player(String name) {
        this.name = name;
        ships = new ArrayList<Ship>();
        // add one ship from each type in ships
        ships.add(new Corveta(false));
        ships.add(new Submarino(false));
        ships.add(new Fragata(false));
        ships.add(new Destroyer(false));

    }

    public String getName() {
        return name;
    }

}

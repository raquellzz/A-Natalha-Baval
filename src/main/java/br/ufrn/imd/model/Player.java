package br.ufrn.imd.model;

import java.util.ArrayList;

/**
 * The Player class represents a player of Natalha Baval.
 * It manages the name and ships of the player.
 */
public class Player {
    private String name;
    ArrayList<Ship> ships;

    /**
     * Constructs a new Player object with the specified name.
     * 
     * @param name The name of the player.
     */
    public Player(String name) {
        this.name = name;
        ships = new ArrayList<Ship>();
        // add one ship from each type in ships
        ships.add(new Corveta(false));
        ships.add(new Submarino(false));
        ships.add(new Fragata(false));
        ships.add(new Destroyer(false));

    }

    /**
     * Returns the name of the player.
     * 
     * @return The name of the player.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the player.
     * 
     * @param name The name of the player.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the ship at the specified index.
     * 
     * @param index The index of the ship.
     * @return The ship at the specified index.
     */
    public Ship getShip(int index) {
        return ships.get(index);
    }

    /**
     * Sets the ship at the specified index.
     * 
     * @param index The index of the ship.
     * @param ship The ship to be set.
     */
    public void setShip(int index, Ship ship) {
        ships.set(index, ship);
    }

    /**
     * Returns the list of ships of the player.
     * 
     * @return The list of ships of the player.
     */
    public ArrayList<Ship> getShips() {
        return ships;
    }

    /**
     * Sets the list of ships of the player.
     * 
     * @param ships The list of ships of the player.
     */
    public void setShips(ArrayList<Ship> ships) {
        this.ships = ships;
    }
    

}

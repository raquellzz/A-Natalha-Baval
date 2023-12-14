package br.ufrn.imd.model;

/**
 * Represents a submarino ship for the game "A Natalha Baval".
 */
public class Submarino extends Ship {

    /**
     * Constructs a Submarino object with the specified values.
     * 
     * @param vertical true if the ship is vertical, false otherwise
     */
    public Submarino(boolean vertical) {
        super(3, vertical, 'S');
    }
}

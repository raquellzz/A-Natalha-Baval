package br.ufrn.imd.model;

/**
 * Represents a corveta ship for the game "A Natalha Baval".
 */
public class Corveta extends Ship {

    /**
     * Constructs a Corveta object with the specified values.
     * 
     * @param vertical true if the ship is vertical, false otherwise
     */
    public Corveta(boolean vertical) {
        super(2, vertical, 'C');
    }
}

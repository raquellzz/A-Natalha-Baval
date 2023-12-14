package br.ufrn.imd.model;

/**
 * Represents a fragata ship for the game "A Natalha Baval".
 */
public class Fragata extends Ship {

    /**
     * Constructs a Fragata object with the specified values.
     * 
     * @param vertical true if the ship is vertical, false otherwise
     */
    public Fragata(boolean vertical) {
        super(4, vertical, 'F');
    }
}

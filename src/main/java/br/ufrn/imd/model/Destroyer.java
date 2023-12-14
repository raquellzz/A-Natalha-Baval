package br.ufrn.imd.model;

/**
 * Represents a destroyer ship for the game "A Natalha Baval".
 */
public class Destroyer extends Ship {

    /**
     * Constructs a Destroyer object with the specified values.
     * 
     * @param vertical true if the ship is vertical, false otherwise
     */
    public Destroyer(boolean vertical) {
        super(5, vertical, 'D');
    }
}

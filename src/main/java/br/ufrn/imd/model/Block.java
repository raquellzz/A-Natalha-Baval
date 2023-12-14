package br.ufrn.imd.model;

/**
 * Represents a block of a table for the game "A Natalha Baval".
 */
public class Block {
    char type; // C = Corveta, S = Submarino, F = Fragata, D = Destroyer, W = Water
    boolean hit; // true = hit, false = not hit
    boolean ship; // true = ship, false = no ship
    int x; // x coordinate
    int y; // y coordinate

    /**
     * Constructs a Block object with default values.
     */
    public Block(int x, int y) {
        this.type = 'W';
        this.hit = false;
        this.ship = false;
        this.x = x;
        this.y = y;
    }

    /**
     * Constructs a Block object with the specified values.
     * 
     * @param type the type of the block
     * @param hit  true if the block has been hit, false otherwise
     * @param ship true if the block has a ship, false otherwise
     * @param x    the x-coordinate of the block
     * @param y    the y-coordinate of the block
     */
    public Block(char type, boolean hit, boolean ship, int x, int y) {
        this.type = type;
        this.hit = hit;
        this.ship = ship;
        this.x = x;
        this.y = y;
    }
 
    /**
     * Gets the type of the block.
     * 
     * @return the type of the block
     */
    public char getType() {
        return this.type;
    }

    /**
     * Sets the type of the block.
     * 
     * @param type the type of the block
     */
    public void setType(char type) {
        this.type = type;
    }

    /**
     * Gets the hit status of the block.
     * @return
     */
    public boolean getHit() {
        return this.hit;
    }

    /**
     * Sets the hit status of the block.
     * 
     * @param hit true if the block has been hit, false otherwise
     */
    public void setHit(boolean hit) {
        this.hit = hit;
    }

    /**
     * Gets the ship status of the block.
     * 
     * @return true if the block has a ship, false otherwise
     */
    public boolean getShip() {
        return this.ship;
    }

    /**
     * Sets the ship status of the block.
     * 
     * @param ship true if the block has a ship, false otherwise
     */
    public void setShip(boolean ship) {
        this.ship = ship;
    }

    /**
     * Gets the x-coordinate of the block.
     * 
     * @return the x-coordinate of the block
     */
    public int getX() {
        return this.x;
    }

    /**
     * Sets the x-coordinate of the block.
     * 
     * @param x the x-coordinate of the block
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Gets the y-coordinate of the block.
     * 
     * @return the y-coordinate of the block
     */
    public int getY() {
        return this.y;
    }

    /**
     * Sets the y-coordinate of the block.
     * 
     * @param y the y-coordinate of the block
     */
    public void setY(int y) {
        this.y= y;
    }

}

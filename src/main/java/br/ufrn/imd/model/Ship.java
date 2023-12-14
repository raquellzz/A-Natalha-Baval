package br.ufrn.imd.model;

import java.util.ArrayList;

/**
 * Represents a ship for the game "A Natalha Baval".
 */
public abstract class Ship {
    private ArrayList<Block> ship = new ArrayList<>();
    private int size;
    private boolean vertical;
    private boolean down;

    /**
     * Constructs a Ship object with the specified values.
     * 
     * @param size     the size of the ship
     * @param vertical true if the ship is vertical, false otherwise
     * @param type     the type of the ship
     */
    public Ship(int size, boolean vertical, char type) {
        this.down = false;
        this.vertical = vertical;
        for (int i = 0; i < size; i++) {
            Block block = new Block(type, false, true, -1, -1);
            this.ship.add(block);
        }
    }

    /**
     * Gets the down status of the ship.
     * 
     * @return true if the ship is down, false otherwise
     */
    public boolean getDown() {
        return this.down;
    }

    /**
     * Sets the down status of the ship.
     * 
     * @param down true if the ship is down, false otherwise
     */
    public void setDown(boolean down) {
        this.down = down;
    }

    /**
     * Gets the vertical status of the ship.
     * 
     * @return
     */
    public boolean getVertical() {
        return this.vertical;
    }

    /**
     * Sets the vertical status of the ship.
     * 
     * @param vertical true if the ship is vertical, false otherwise
     */
    public void setVertical(boolean vertical) {
        this.vertical = vertical;
    }

    /**
     * Gets the size of the ship.
     * 
     * @return the size of the ship
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Sets the size of the ship.
     * 
     * @param size the size of the ship
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Gets the block at the specified index.
     * 
     * @param i the index of the block
     * @return the block at the specified index
     */
    public Block getBlock(int i) {
        try {
            return this.ship.get(i);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Sets the block at the specified index.
     * 
     * @param i     the index of the block
     * @param block the block to be set
     */
    public void setBlock(int i, Block block) {
        this.ship.set(i, block);
    }

    /**
     * Gets the type of the ship.
     * 
     * @return the type of the ship
     */
    public char getType() {
        return this.ship.get(0).getType();
    }

    /**
     * Sets the type of the ship.
     * 
     * @param type the type of the ship
     */
    public void setType(char type) {
        for (Block block : this.ship) {
            block.setType(type);
        }
    }

    /**
     * Gets the ship.
     * 
     * @return the ship
     */
    public ArrayList<Block> getShip() {
        return this.ship;
    }

    /**
     * Sets the ship.
     * 
     * @param ship the ship to be set
     */
    public void setShip(ArrayList<Block> ship) {
        this.ship = ship;
    }
}

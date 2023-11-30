package br.ufrn.imd.model;

import java.util.ArrayList;

public abstract class Ship {
    private ArrayList<Block> ship = new ArrayList<>();
    private int size;
    private boolean vertical;
    private boolean down;

    public Ship(int size, boolean vertical, char type) {
        this.down = false;
        this.vertical = vertical;
        for (int i = 0; i < size; i++) {
            Block block = new Block(type, false, true, -1, -1);
            this.ship.add(block);
        }
    }

    public boolean getDown() {
        return this.down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean getVertical() {
        return this.vertical;
    }

    public void setVertical(boolean vertical) {
        this.vertical = vertical;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Block getBlock(int i) {
        try {
            return this.ship.get(i);
        } catch (Exception e) {
            return null;
        }
    }

    public void setBlock(int i, Block block) {
        this.ship.set(i, block);
    }

    public char getType() {
        return this.ship.get(0).getType();
    }

    public void setType(char type) {
        for (Block block : this.ship) {
            block.setType(type);
        }
    }

    public ArrayList<Block> getShip() {
        return this.ship;
    }

    public void setShip(ArrayList<Block> ship) {
        this.ship = ship;
    }
}

package br.ufrn.imd.model;

public class Block {
    char type; // C = Corveta, S = Submarino, F = Fragata, D = Destroyer, W = Water
    boolean hit; // true = hit, false = not hit
    boolean ship; // true = ship, false = no ship
    int x; // x coordinate
    int y; // y coordinate

    public Block(int x, int y) {
        this.type = 'W';
        this.hit = false;
        this.ship = false;
        this.x = x;
        this.y = y;
    }

    public Block(char type, boolean hit, boolean ship, int x, int y) {
        this.type = type;
        this.hit = hit;
        this.ship = ship;
        this.x = x;
        this.y = y;
    }
 
    // gets and sets
    public char getType() {
        return this.type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public boolean getHit() {
        return this.hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    public boolean getShip() {
        return this.ship;
    }

    public void setShip(boolean ship) {
        this.ship = ship;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y= y;
    }

}

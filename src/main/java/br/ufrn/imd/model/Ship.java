package br.ufrn.imd.model;

import java.util.ArrayList;

public abstract class Ship {
    ArrayList<Block> ship = new ArrayList<>();
    int size;
    boolean vertical;
    boolean horizontal;
    boolean down;

    public Ship(int size, char direction, char type){
        this.down = false;
        if(direction == 'V'){
            this.vertical = true;
            this.horizontal = false;
        }
        else{
            this.horizontal = true;
            this.vertical = false;
        }
        for(int i = 0; i < size; i ++){
            Block block = new Block(type, false, true, -1, -1);
            this.ship.add(block);
        }
    }
}

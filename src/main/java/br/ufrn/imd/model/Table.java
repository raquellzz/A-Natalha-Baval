package br.ufrn.imd.model;

public class Table {
    private int size = 10;
    private Block[][] field;

    public Table(int size) {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                field[i][j] = new Block(i, j);
            }
    }

    public Block[][] getField() {
        return this.field;
    }

    public void setField(Block[][] field) {
        this.field = field;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void clear() {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                field[i][j] = new Block(i, j);
            }
    }

    public boolean addShip(Ship ship, int x, int y) {
        if (ship.getVertical() == true) {
            for (int i = 0; i < ship.getSize(); i++) {
                if (y + 1 >= size || field[x][y + i].type != 'W')
                    return false;
            }
            for (int i = 0; i < ship.getSize(); i++) {
                ship.getBlock(i).setX(x);
                ship.getBlock(i).setY(y + i);
                field[x][y + i] = ship.getBlock(i);
            }
            return true;
        } else {
            for (int i = 0; i < ship.getSize(); i++) {
                if (x + 1 >= size || field[x + i][y].type != 'W')
                    return false;
            }
            for (int i = 0; i < ship.getSize(); i++) {
                ship.getBlock(i).setX(x + i);
                ship.getBlock(i).setY(y);
                field[x + i][y] = ship.getBlock(i);
            }
            return true;
        }
    }
}

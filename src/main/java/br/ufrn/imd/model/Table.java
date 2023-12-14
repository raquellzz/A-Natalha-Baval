package br.ufrn.imd.model;

public class Table {
    private int size = 10;
    private Block[][] field = new Block[10][10];

    public Table(int size) {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                Block block = new Block(i, j);
                field[i][j] = block;
            }
    }

    public Block[][] getField() {
        return this.field;
    }

    public Block getBlock(int x, int y) {
        return field[x][y];
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

    public boolean checkShip(Ship ship, int x, int y) {
        if (ship.getVertical() == true) {
            if (ship.getSize() + y > size)
                return false;
            for (int i = 0; i < ship.getSize(); i++) {
                if (field[x][y + i].type != 'W')
                    return false;
            }
            return true;
        } else {
            if (ship.getSize() + x > size)
                return false;
            for (int i = 0; i < ship.getSize(); i++) {
                if (field[x + i][y].type != 'W')
                    return false;
            }
            return true;
        }
    }

    public boolean addShip(Ship ship, int x, int y) {
        if (ship == null)
            return false;
        if (ship.getVertical() == true && checkShip(ship, x, y)) {
            for (int i = 0; i < ship.getSize(); i++) {
                ship.getBlock(i).setX(x);
                ship.getBlock(i).setY(y + i);
                field[x][y + i] = ship.getBlock(i);
            }
            return true;
        } else if (checkShip(ship, x, y)) {
            for (int i = 0; i < ship.getSize(); i++) {
                ship.getBlock(i).setX(x + i);
                ship.getBlock(i).setY(y);
                field[x + i][y] = ship.getBlock(i);
            }
            return true;
        }
        return false;
    }

    public boolean checkRotateShip(Ship ship) {
        if (ship == null)
            return false;
        if (ship.getVertical()) {
            if (ship.getBlock(0).getX() + ship.getSize() > size + 1)
                return false;
            for (int i = 1; i < ship.getSize(); i++) {
                if (field[ship.getBlock(i).getX() + i][ship.getBlock(i).getY()].getType() != 'W')
                    return false;
            }
            return true;
        } else {
            if (ship.getBlock(0).getY() + ship.getSize() > size + 1)
                return false;
            for (int i = 1; i < ship.getSize(); i++) {
                if (field[ship.getBlock(i).getX()][ship.getBlock(i).getY() + i].getType() != 'W')
                    return false;
            }
            return true;
        }
    }

    public boolean rotateShip(Ship ship) {
        if (checkRotateShip(ship)) {
            if (ship.getVertical()) {
                for (int i = 0; i < ship.getSize(); i++) {
                    int tempX = ship.getBlock(i).getX();
                    int tempY = ship.getBlock(i).getY();
                    ship.getBlock(i).setX(tempX + i);
                    ship.getBlock(i).setY(tempY);
                    field[tempX][tempY] = new Block(tempX, tempY);
                    field[tempX + i][tempY] = ship.getBlock(i);
                }
            } else {
                for (int i = 0; i < ship.getSize(); i++) {
                    int tempX = ship.getBlock(i).getX();
                    int tempY = ship.getBlock(i).getY();
                    ship.getBlock(i).setX(tempX);
                    ship.getBlock(i).setY(tempY + i);
                    field[tempX][tempY] = new Block(tempX, tempY);
                    field[tempX][tempY + i] = ship.getBlock(i);
                }

            }
            return true;
        }
        return false;
    }
}

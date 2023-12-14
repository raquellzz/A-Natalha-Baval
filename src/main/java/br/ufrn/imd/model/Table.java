package br.ufrn.imd.model;

/**
 * Represents a table for the game "A Natalha Baval".
 */
public class Table {
    private int size = 10;
    private Block[][] field = new Block[10][10];

    /**
     * Constructs a Table object with the specified size.
     * 
     * @param size the size of the table
     */
    public Table(int size) {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                Block block = new Block(i, j);
                field[i][j] = block;
            }
    }

    /**
     * Gets the field of the table.
     * 
     * @return the field of the table
     */
    public Block[][] getField() {
        return this.field;
    }

    /**
     * Gets the block at the specified coordinates.
     * 
     * @param x the x-coordinate of the block
     * @param y the y-coordinate of the block
     * @return the block at the specified coordinates
     */
    public Block getBlock(int x, int y) {
        return field[x][y];
    }

    /**
     * Sets the field of the table.
     * 
     * @param field the field to be set
     */
    public void setField(Block[][] field) {
        this.field = field;
    }

    /**
     * Gets the size of the table.
     * 
     * @return the size of the table
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Sets the size of the table.
     * 
     * @param size the size to be set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Clears the table by setting all blocks to new blocks.
     */
    public void clear() {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                field[i][j] = new Block(i, j);
            }
    }

    /**
     * Checks if a ship can be placed at the specified coordinates.
     * 
     * @param ship the ship to be placed
     * @param x the x-coordinate of the placement
     * @param y the y-coordinate of the placement
     * @return true if the ship can be placed, false otherwise
     */
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

    /**
     * Adds a ship to the table at the specified coordinates.
     * 
     * @param ship the ship to be added
     * @param x the x-coordinate of the placement
     * @param y the y-coordinate of the placement
     * @return true if the ship was added successfully, false otherwise
     */
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

    /**
     * Checks if a ship can be rotated.
     * 
     * @param ship the ship to be rotated
     * @return true if the ship can be rotated, false otherwise
     */
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

    /**
     * Rotates a ship on the table.
     * 
     * @param ship the ship to be rotated
     * @return true if the ship was rotated successfully, false otherwise
     */
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

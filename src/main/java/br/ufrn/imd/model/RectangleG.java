package br.ufrn.imd.model;

import javafx.scene.shape.Rectangle;

/**
 * Represents a rectangle for the game "A Natalha Baval".
 */
public class RectangleG {
    public Rectangle rectangle;
    public int x;
    public int y;

    /**
     * Constructs a RectangleG object with the specified values.
     * 
     * @param rectangle the rectangle
     * @param x         the x-coordinate of the rectangle
     * @param y         the y-coordinate of the rectangle
     */
    public RectangleG(Rectangle rectangle, int x, int y) {
        this.rectangle = rectangle;
        this.x = x;
        this.y = y;
    }

    /**
     * Gets the rectangle.
     * 
     * @return the rectangle
     */
    public Rectangle getRectangle() {
        return this.rectangle;
    }

    /**
     * Sets the rectangle.
     * 
     * @param rectangle the rectangle to be set
     */
    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    /**
     * Gets the x-coordinate of the rectangle.
     * 
     * @return the x-coordinate of the rectangle
     */
    public int getX() {
        return this.x;
    }

    /**
     * Sets the x-coordinate of the rectangle.
     * 
     * @param x the x-coordinate of the rectangle
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Sets the y-coordinate of the rectangle.
     * 
     * @param y the y-coordinate of the rectangle
     */
    public RectangleG rectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
        return this;
    }

    /**
     * Gets the y-coordinate of the rectangle.
     * 
     * @return the y-coordinate of the rectangle
     */
    public int getY() {
        return this.y;
    }

    
}

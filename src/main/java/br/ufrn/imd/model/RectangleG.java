package br.ufrn.imd.model;

import javafx.scene.shape.Rectangle;

public class RectangleG {
    public Rectangle rectangle;
    public int x;
    public int y;

    public RectangleG(Rectangle rectangle, int x, int y) {
        this.rectangle = rectangle;
        this.x = x;
        this.y = y;
    }

    public Rectangle getRectangle() {
        return this.rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public RectangleG rectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
        return this;
    }

    public int getY() {
        return this.y;
    }

    
}

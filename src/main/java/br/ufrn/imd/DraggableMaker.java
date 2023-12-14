package br.ufrn.imd;

import javafx.scene.Node;

/**
 * Makes a node draggable.
 */
public class DraggableMaker {

    private double mouseAnchorX;
    private double mouseAnchorY;

    /**
     * Constructs a DraggableMaker object.
     */
    public void makeDraggable(Node node) {
        node.setOnMousePressed(e -> {
            mouseAnchorX = e.getX();
            mouseAnchorY = e.getY();
        });

        node.setOnMouseDragged(e -> {
            node.setLayoutX(e.getSceneX() - mouseAnchorX);
            node.setLayoutY(e.getSceneY() - mouseAnchorY);
            
        });
    }
}

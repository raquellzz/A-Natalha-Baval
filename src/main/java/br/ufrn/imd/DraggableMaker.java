package br.ufrn.imd;

import javafx.scene.Node;

public class DraggableMaker {

    private double mouseAnchorX;
    private double mouseAnchorY;

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

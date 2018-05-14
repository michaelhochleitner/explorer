package sample;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class MainController {

    @FXML private VBox vistaHolder;

    @FXML private VBox root;

    public void setVista(Node node) { vistaHolder.getChildren().setAll(node); }
}

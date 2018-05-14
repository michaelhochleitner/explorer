package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class SettingController extends ControllerWithData{
    @FXML private ChoiceBox mapsize;
    @FXML private ChoiceBox treasures;

    public void startGame() {
        System.out.println(mapsize.getSelectionModel().getSelectedItem().toString());
        System.out.println(treasures.getSelectionModel().getSelectedItem().toString());
        this.data.setMapsize(mapsize.getSelectionModel().getSelectedItem());
        this.data.setTreasureCount(treasures.getSelectionModel().getSelectedItem());
        VistaNavigator.initDataAndLoadVista(VistaNavigator.GAME);
    }
}

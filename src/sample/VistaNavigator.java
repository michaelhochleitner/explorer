package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.IOException;

public class VistaNavigator {

    public static final String MAIN = "main.fxml";
    public static final String SETTINGS = "settingdialog.fxml";
    public static final String GAME = "sample.fxml";
    public static final String SETTINGS_2 = "settings.fxml";

    private static MainController mainController;

    private static Data data;
    public static Data getData() { return data; }
    public static void setData(Data data){ VistaNavigator.data = data; }

    public static void setMainController(MainController mainController) {
        VistaNavigator.mainController = mainController;
    }

    public static void initDataAndLoadVista(String fxml) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(VistaNavigator.class.getResource(fxml));
            Node node = fxmlLoader.load();
            ControllerWithData controller = fxmlLoader.getController();
            controller.initModel(getData());
            mainController.setVista(node);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadVista(String fxml) {
        try {
            mainController.setVista(
                                    FXMLLoader.load(VistaNavigator.class.getResource(fxml)
                                    )
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
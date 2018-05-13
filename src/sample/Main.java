package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader mainLoader = new FXMLLoader(getClass().getResource(VistaNavigator.MAIN));
        Pane mainPane = mainLoader.load(getClass().getResourceAsStream(VistaNavigator.MAIN));
        MainController mainController = mainLoader.getController();
        VistaNavigator.setMainController(mainController);


        Scene scene = new Scene(mainPane);
        Data data = new Data();
        VistaNavigator.setData(data);

        VistaNavigator.initDataAndLoadVista(VistaNavigator.SETTINGS);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Indiana Jones");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

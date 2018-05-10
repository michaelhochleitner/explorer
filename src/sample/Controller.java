package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.HashSet;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Set;

public class Controller implements Initializable{

    private Random rand = new Random();

    private StringProperty yPos = new SimpleStringProperty("5");
    private StringProperty xPos = new SimpleStringProperty("5");

    private Set placesOfInterest;

    @FXML private Label yLabel;
    @FXML private Label xLabel;
    @FXML private Label poiLabel;

    @FXML protected void handleActionButtonAction(ActionEvent event) {
        move();
    }

    private boolean randomBoolean(){
        return rand.nextBoolean();
    }

    private int plusOrMinusOne(){
        if (randomBoolean()){
            return -1;
        } else {
            return 1;
        }
    }

    private void move(){
        if (randomBoolean()){
            incrementPos(xPos);
        } else {
            incrementPos(yPos);
        }
        checkForPlaceOfInterest();
    }

    public void checkForPlaceOfInterest() {
        int xPosInt = Integer.parseInt(xPos.getValue());
        int yPosInt = Integer.parseInt(yPos.getValue());
        Tuple currentPos = new Tuple(xPosInt, yPosInt);

        boolean poifound = false;
        for (Object tuplex : placesOfInterest) {
            if(tuplex.equals(currentPos)){
                poifound = true;
            }
        }

        if (poifound) {
            poiLabel.textProperty().setValue("You found a place of interest");
        } else {
            poiLabel.textProperty().setValue("common tile");
        }
    }

    private void incrementPos(StringProperty stringProperty) {
        String posString = stringProperty.getValue();
        int posInt = Integer.parseInt(posString);
        switch (posInt) {
            case 10: posInt -= 1;
            break;

            case 1: posInt += 1;
            break;

            default: posInt += plusOrMinusOne();
            break;
        }
        posString = Integer.toString(posInt);
        stringProperty.setValue(posString);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        placesOfInterest = new HashSet();

        Tuple tuple = new Tuple(5,6);
        Tuple tuple1 = new Tuple(6,5);
        Tuple tuple2 = new Tuple(5,4);
        Tuple tuple3 = new Tuple(4,5);

        placesOfInterest.add(pointOfInterest());
        placesOfInterest.add(pointOfInterest());
        placesOfInterest.add(pointOfInterest());
        placesOfInterest.add(pointOfInterest());
        yLabel.textProperty().bind(yPos);
        xLabel.textProperty().bind(xPos);
    }

    private Tuple pointOfInterest() {
        int xPos = rand.nextInt(10);
        int yPos = rand.nextInt(10);
        Tuple poi = new Tuple(xPos, yPos);
        System.out.println("poi at "+xPos+" "+yPos);
        return poi;
    }
}

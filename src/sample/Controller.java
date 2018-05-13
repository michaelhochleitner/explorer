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

    @FXML
    private StringProperty poiFound = new SimpleStringProperty("0");
    @FXML
    private StringProperty stepsNeeded = new SimpleStringProperty("0");

    private Set placesOfInterest;

    @FXML private Label yLabel;
    @FXML private Label xLabel;
    @FXML private Label poiLabel;
    @FXML private Label poifound;
    @FXML private Label steps;

    @FXML protected void handleActionButtonAction() {
        move();
    }

    @FXML protected void handleUpButton(){
        incrementPosition(yPos);
        incrementStringProperty(stepsNeeded);
    }

    @FXML protected void handleRightButton(){
        incrementPosition(xPos);
        incrementStringProperty(stepsNeeded);
    }

    @FXML protected void handleLeftButton() {
        decrementPosition(xPos);
        incrementStringProperty(stepsNeeded);
    }

    @FXML protected void handleDownButton() {
        decrementPosition(yPos);
        incrementStringProperty(stepsNeeded);
    }

    private void decrementPosition(StringProperty stringProperty) {
        int posInt = intFrom(stringProperty);
        if (posInt > 0){
            posInt -= 1;
        }
        setStringPropertyValueWith(stringProperty, posInt);
        checkForPlaceOfInterest();
    }

    private void incrementPosition(StringProperty stringProperty) {
        int posInt = intFrom(stringProperty);
        if (posInt < 9){
            posInt += 1;
        }
        setStringPropertyValueWith(stringProperty, posInt);
        checkForPlaceOfInterest();
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
            randomPositionChange(xPos);
        } else {
            randomPositionChange(yPos);
        }
        checkForPlaceOfInterest();
    }

    public void checkForPlaceOfInterest() {
        int xPosInt = Integer.parseInt(xPos.getValue());
        int yPosInt = Integer.parseInt(yPos.getValue());
        Tuple currentPos = new Tuple(xPosInt, yPosInt);

        Object foundTuple = null;

        boolean poifound = false;
        for (Object tuplex : placesOfInterest) {
            if(tuplex.equals(currentPos)){
                poifound = true;
                foundTuple = tuplex;
            }
        }

        if (poifound) {
            incrementStringProperty(poiFound);
            poiLabel.textProperty().setValue("You found a treasure!");
            placesOfInterest.remove(foundTuple);
        } else {
            poiLabel.textProperty().setValue("common tile");
        }
    }

    private void incrementStringProperty(StringProperty stringProperty) {
        int poif = intFrom(stringProperty);
        poif +=1;
        setStringPropertyValueWith(stringProperty,poif);
    }

    private void randomPositionChange(StringProperty stringProperty) {
        int posInt = intFrom(stringProperty);
        switch (posInt) {
            case 9: posInt -= 1;
            break;

            case 0: posInt += 1;
            break;

            default: posInt += plusOrMinusOne();
            break;
        }
        setStringPropertyValueWith(stringProperty, posInt);
    }

    private void setStringPropertyValueWith(StringProperty stringProperty, int posInt) {
        String posString;
        posString = Integer.toString(posInt);
        stringProperty.setValue(posString);
    }

    private int intFrom(StringProperty stringProperty) {
        String posString = stringProperty.getValue();
        return Integer.parseInt(posString);
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
        poifound.textProperty().bind(poiFound);
        steps.textProperty().bind(stepsNeeded);
    }

    private Tuple pointOfInterest() {
        int xPos = rand.nextInt(10);
        int yPos = rand.nextInt(10);
        Tuple poi = new Tuple(xPos, yPos);
        System.out.println("poi at "+xPos+" "+yPos);
        return poi;
    }
}

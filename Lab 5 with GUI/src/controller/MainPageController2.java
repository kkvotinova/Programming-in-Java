/*
 * Copyright (c) 2021 Ksuvot
 */

package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import project.brain.ElevatorControl;
import project.brain.Request;

public class MainPageController2 {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView House;

    @FXML
    private ImageView firstElevator;

    @FXML
    private ImageView secondElevator;

    @FXML
    private ImageView thirdElevator;

    @FXML
    private Button startButton;

    @FXML
    void initialize() {
        startButton.setOnAction(actionEvent -> {
            ElevatorControl elevatorControl = new ElevatorControl(4, 7, 3);
            Request request = new Request(7, 15, elevatorControl);
            elevatorControl.setMainPageController2(this);
            elevatorControl.setChoiceMode(2);

            Thread requestsThread = new Thread(request);
            Thread elevatorsThread = new Thread(elevatorControl);
            requestsThread.start();
            elevatorsThread.start();
        });
    }

    public ImageView getFirstElevator() {
        return firstElevator;
    }

    public ImageView getSecondElevator() {
        return secondElevator;
    }

    public ImageView getThirdElevator() {
        return thirdElevator;
    }
}

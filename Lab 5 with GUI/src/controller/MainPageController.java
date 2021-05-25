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

public class MainPageController {

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
    private Button startButton;

    @FXML
    void initialize() {
        startButton.setOnAction(actionEvent -> {
            ElevatorControl elevatorControl = new ElevatorControl(3, 5, 2);
            Request request = new Request(5, 11, elevatorControl);
            elevatorControl.setMainPageController(this);
            elevatorControl.setChoiceMode(1);

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
}

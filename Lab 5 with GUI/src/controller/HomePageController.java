/*
 * Copyright (c) 2021 Ksuvot
 */

package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import project.brain.ElevatorControl;
import project.brain.Request;

public class HomePageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button startButton;

    @FXML
    private RadioButton firstModeChoice;

    @FXML
    private RadioButton secondModeChoice;

    @FXML
    void initialize() {
        startButton.setOnAction(actionEvent -> {
            startButton.getScene().getWindow().hide();

            ElevatorControl elevatorControl;
            Request request;

            FXMLLoader fxmlLoader = new FXMLLoader();
            if (firstModeChoice.isSelected()) {
                fxmlLoader.setLocation(getClass().getResource("/resources/MainPage.fxml"));
                elevatorControl = new ElevatorControl(3, 5, 2);
                request = new Request(5, 11, elevatorControl);
            } else {
                fxmlLoader.setLocation(getClass().getResource("/resources/MainPage2.fxml"));
                elevatorControl = new ElevatorControl(4, 7, 3);
                request = new Request(7, 15, elevatorControl);
            }
            try {
                fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Thread requestsThread = new Thread(request);
            Thread elevatorsThread = new Thread(elevatorControl);
            requestsThread.start();
            elevatorsThread.start();

            Parent parent = fxmlLoader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.showAndWait();
        });
    }
}

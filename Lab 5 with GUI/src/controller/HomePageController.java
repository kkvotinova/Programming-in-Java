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

            FXMLLoader fxmlLoader = new FXMLLoader();
            if (firstModeChoice.isSelected()) {
                fxmlLoader.setLocation(getClass().getResource("/resources/MainPage.fxml"));
            } else {
                fxmlLoader.setLocation(getClass().getResource("/resources/MainPage2.fxml"));
            }
            try {
                fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent parent = fxmlLoader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.showAndWait();

            if (!stage.isShowing()) {
                System.exit(0);
            }
        });
    }
}

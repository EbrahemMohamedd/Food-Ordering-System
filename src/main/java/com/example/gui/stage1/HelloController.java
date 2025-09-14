package com.example.gui.stage1;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
public class HelloController implements Initializable {
    private Stage stage;


    @FXML
    double progress = 0.0;

    @FXML
    private ProgressBar progressBar;

    @FXML
    ImageView image;

    @FXML
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.01), e -> {

            progress += 0.004;
            progressBar.setProgress(progress);
        }));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

}

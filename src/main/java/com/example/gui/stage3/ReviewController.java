package com.example.gui.stage3;

import com.example.gui.HelloApplication;
import com.example.gui.stage2.HomePageController;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class ReviewController {

    @FXML
    private MenuButton RestName;

    @FXML
    private MenuButton RestRate;

    @FXML
    private Text fail;

    @FXML
    private Text success;

    private String selectedRestaurant = null;
    private String selectedRate = null;
    public static List<String> reviewData = new ArrayList<>();

    @FXML
    void initialize() {

        setNull();
        RestName.setPrefWidth(235);
        RestRate.setPrefWidth(235);

        for (String restaurant : HomePageController.restaurantNamesArray) {
            MenuItem menuItem = new MenuItem(restaurant);
            menuItem.setOnAction(e -> {
                RestName.setText(restaurant);
                selectedRestaurant = restaurant;
            });
            RestName.getItems().add(menuItem);
        }

        String[] rates = {"1", "2", "3", "4", "5"};
        for (String rate : rates) {
            MenuItem menuItem = new MenuItem(rate);
            menuItem.setOnAction(e -> {
                RestRate.setText(rate);
                selectedRate = rate;
            });
            RestRate.getItems().add(menuItem);
        }
    }

    @FXML
    void SwitchToHome(ActionEvent event) {
        HelloApplication.display(3);
        setNull();
    }

    @FXML
    void Submit(ActionEvent event) {
        if (selectedRestaurant == null || selectedRate == null) {
            fail.setVisible(true);
            success.setVisible(false);
            return;
        }

        success.setVisible(true);
        fail.setVisible(false);

        reviewData.add(selectedRestaurant);
        reviewData.add(selectedRate);
        HelloApplication.delay1sec(3);
        PauseTransition delay = new PauseTransition(Duration.seconds(1));
        delay.setOnFinished(e -> setNull());
        delay.play();
    }

    @FXML
    void setNull() {
        RestName.setText("Select a restaurant");
        RestRate.setText("Rate the restaurant");
        selectedRestaurant = null;
        selectedRate = null;
        fail.setVisible(false);
        success.setVisible(false);
        reviewData.clear();
    }
}

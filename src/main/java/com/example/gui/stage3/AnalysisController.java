package com.example.gui.stage3;

import com.example.gui.HelloApplication;
import com.example.gui.Item;
import com.example.gui.stage2.ItemCartController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;

public class AnalysisController {
    public VBox app;
    public VBox main;
    public VBox drink;
    public Text mainprice;
    public Text drprice;
    public Text apprice;
    double countAPP = 0;
    double countMAIN = 0;
    double countDRINK = 0;
    public void fillDataAPP(){
        for(Item item : Analysis.itemsAPP) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/com/example/gui/AnalysisItems.fxml"));

            AnalysisItemController controller;
            Pane childPane;
            try {
                childPane = fxmlLoader.load();
                controller = fxmlLoader.getController();

            } catch (IOException e) {

                throw new RuntimeException(e);
            }
            controller.fill(item);
            countAPP += item.getQuantity() * item.getPrice();

            childPane.setUserData(controller);
            app.getChildren().add(childPane);
            app.setPrefHeight(app.getPrefHeight() + 100);
        }

    }
    public void fillDataMAIN(){
        for(Item item : Analysis.itemsMAIN) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/com/example/gui/AnalysisItems.fxml"));

            AnalysisItemController controller;
            Pane childPane;
            try {
                childPane = fxmlLoader.load();
                controller = fxmlLoader.getController();

            } catch (IOException e) {

                throw new RuntimeException(e);
            }

            controller.fill(item);
            countMAIN += item.getQuantity() * item.getPrice();

            childPane.setUserData(controller);
            main.getChildren().add(childPane);
            main.setPrefHeight(main.getPrefHeight() + 100);
        }

    }
    public void fillDataDRINK(){
        for(Item item : Analysis.itemsDRINK) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/com/example/gui/AnalysisItems.fxml"));

            AnalysisItemController controller;
            Pane childPane;
            try {
                childPane = fxmlLoader.load();
                controller = fxmlLoader.getController();

            } catch (IOException e) {

                throw new RuntimeException(e);
            }


            controller.fill(item);
            countDRINK += item.getQuantity() * item.getPrice();
            drink.getChildren().add(childPane);
            drink.setPrefHeight(drink.getPrefHeight() + 100);
        }

    }


    public void Main(){
        countAPP = 0;
        countMAIN = 0;
        countDRINK = 0;
        app.getChildren().clear();
        main.getChildren().clear();
        drink.getChildren().clear();
        fillDataAPP();
        fillDataMAIN();
        fillDataDRINK();
        apprice.setText(countAPP + "$");
        mainprice.setText(countMAIN + "$");
        drprice.setText(countDRINK + "$");
    }


    @FXML
    void SwitchToHomeAdmin(ActionEvent event) {
        HelloApplication.display(9);
    }

}

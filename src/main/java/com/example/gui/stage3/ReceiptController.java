package com.example.gui.stage3;

import com.example.gui.HelloApplication;
import com.example.gui.Item;
import com.example.gui.stage1.LoginController;
import com.example.gui.stage2.CartController;
import com.example.gui.stage2.MenuController;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.util.Pair;

import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import static com.example.gui.stage2.CartController.itemsCart;
import static com.example.gui.stage2.CartController.price;


public class ReceiptController {

    AnalysisController analysisController;
    @FXML
    public static ArrayList<Item> itemsReceipt = new ArrayList<>();
    @FXML
    private TextField Customization;
    @FXML
    private CartController cartController;
    @FXML
    public VBox BasicBox;
    @FXML
    public Label warning;
    @FXML
    public TextField address;
    @FXML
    public Text name;
    @FXML
    public Text totalPrice;
    @FXML
    public Text preparing;
    @FXML
    public Button button;
    public static String Username;
    public void itemsToReceipt(){
        name.setText(LoginController.name);
        Username = name.getText();
        for (Item item : itemsReceipt) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/com/example/gui/ReceiptItem.fxml"));

            ReceiptItemController controller;
            Pane childPane;
            try {
                childPane = fxmlLoader.load();
                controller = fxmlLoader.getController();

            } catch (IOException e) {

                throw new RuntimeException(e);
            }

            controller.fill(item);
            childPane.setUserData(controller);
            BasicBox.getChildren().add(childPane);
            BasicBox.setPrefHeight(BasicBox.getPrefHeight() + 50);
            totalPrice.setText(15 + price + "$");

        }

    }
    void setNull(){
          BasicBox.getChildren().clear();
          address.setText("");
          preparing.setText("Preparing");
    }

    @FXML
    void confirm(ActionEvent event) {
        if(address.getText().isEmpty()){
                warning.setVisible(true);
                warning.setText("add your address");
                PauseTransition delay = new PauseTransition(Duration.seconds(1));
                delay.setOnFinished(Event -> warning.setVisible(false));
                delay.play();
                return;
        }
        statusPreparing();
    }


    public void statusPreparing() {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0), event -> preparing.setText("Preparing")),
                new KeyFrame(Duration.seconds(3), event -> preparing.setText("On Way")),
                new KeyFrame(Duration.seconds(6), event -> {
                    preparing.setText("Delivered");

                })
        );
        address.setDisable(true);
        Customization.setDisable(true);
        button.setDisable(true);
        PauseTransition delay = new PauseTransition(Duration.seconds(8));
        delay.setOnFinished(Event -> {
            timeline.stop();
            address.setDisable(false);
            Customization.setDisable(false);
            //address.setEditable(false);
            button.setDisable(false);
            cartController.cash.setSelected(false);
            cartController.visa.setSelected(false);
            cartController.BasicBox.getChildren().clear();
            cartController.scroll.setVvalue(0);
            itemsCart.clear();
            MenuController.test.clear();
            MenuController.totalCartValue = 0;
            price = 0;
            cartController.OrderDone();
            setNull();
            Analysis.toAnalysisList.addAll(itemsReceipt);
            HelloApplication.display(3);
        } );
        delay.play();

        timeline.setCycleCount(1); // Run only once
        timeline.play(); // Start the timeline
    }

    public void setCartController(CartController cartController1){
        cartController=cartController1;
    }


    public void setAnalysisController(AnalysisController analysisController){
        this.analysisController = analysisController;
    }


}







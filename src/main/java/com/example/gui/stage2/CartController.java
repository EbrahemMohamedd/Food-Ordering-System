package com.example.gui.stage2;

import com.example.gui.HelloApplication;
import com.example.gui.Item;
import com.example.gui.stage1.LoginController;
import com.example.gui.stage3.ReceiptController;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;

public class CartController {

    @FXML
    private ReceiptController receiptController;
    @FXML
    private TextField visa1;

    @FXML
    private Label warning;


    @FXML
    private TextField visa2;

    @FXML
    private TextField visa3;

    @FXML
    MenuController menuController;
    @FXML
    public static ArrayList<Item> itemsCart = new ArrayList<>();
    @FXML
    String indicateEmpty;
    @FXML
    public Label EmptyCart = new Label();
    @FXML
    public ScrollPane scroll;
    @FXML
    public VBox BasicBox;
    @FXML
    private VBox paymentDetails;

    @FXML
    private Label DeliveryPrice;

    @FXML
    private Label TotalPrice;

    @FXML
    private Label CartPrice;

    @FXML
    public RadioButton visa;
    @FXML
    public RadioButton cash;
    @FXML
    public static double price;

    public void checkPay(){
        cash.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                visa1.setVisible(false);
                visa2.setVisible(false);
                visa3.setVisible(false);
                visa.setSelected(false);
            }
        });
        visa.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                visa1.setVisible(true);
                visa2.setVisible(true);
                visa3.setVisible(true);
                cash.setSelected(false);
            }
            else {
                visa1.setVisible(false);
                visa2.setVisible(false);
                visa3.setVisible(false);
            }
        });



    }

    public void OrderExist() {
        if (MenuController.Ordered) {
//
            paymentDetails.setVisible(true);
            BasicBox.getChildren().remove(EmptyCart);
            for (int i = 0; i < itemsCart.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/com/example/gui/ItemCart.fxml"));

                ItemCartController controller;
                Pane childPane;
                try {
                    childPane = fxmlLoader.load();
                    controller = fxmlLoader.getController();

                } catch (IOException e) {

                    throw new RuntimeException(e);
                }

                controller.fill(itemsCart.get(i));

                childPane.setUserData(controller);
                childPane.setPrefSize(450, 92);
                VBox.setMargin(childPane, new Insets(0, 20, 20, 0));
                double Delivery = Double.parseDouble(DeliveryPrice.getText().replace("$",""));

                int finalI = i;
                price = MenuController.totalCartValue;
                CartPrice.setText(price + "$");
                TotalPrice.setText( Delivery + price + "$" );

                childPane.setOnMouseClicked(event -> {
                    if (controller.delete) {
                        BasicBox.getChildren().remove(childPane);

                        price -= (itemsCart.get(finalI).getQuantity() * itemsCart.get(finalI).getPrice());
                        CartPrice.setText(price + "$");
                        itemsCart.remove(finalI);
                        TotalPrice.setText( Delivery + price + "$" );

                        indicateEmpty = BasicBox.getChildren().toString();
                        if (indicateEmpty.equals("[]")) {
                            paymentDetails.setVisible(false);
                            OrderDone();
                        }
                    }
                });
                BasicBox.setPrefHeight(BasicBox.getPrefHeight() + 50);

                TotalPrice.setText( 15 + price + "$" );
                BasicBox.getChildren().add(childPane);
                MenuController.Ordered = false;
                controller.delete = false;
            }


        }
    }

    public void OrderDone() {
        BasicBox.getChildren().clear();
        paymentDetails.setVisible(false);
        EmptyCart.setText("No Items In Cart!");
        EmptyCart.setFont(new Font("Basketball", 30)); // Set font size
        EmptyCart.setTextFill(Color.WHITE); // Set text color
        VBox.setMargin(EmptyCart, new Insets(250, 0, 0, 0)); // Top, Right, Bottom, Left margins
        BasicBox.getChildren().add(EmptyCart);
    }

    public void initialize() {
        visa1.setVisible(false);
        visa3.setVisible(false);
        visa2.setVisible(false);

        checkPay();

        OrderDone();


    }
    public void setMenuController(MenuController menuController1) {
        menuController = menuController1;

    }

    public void Confirm(ActionEvent actionEvent) {
        if(!cash.isSelected() && !visa.isSelected()){
            if(paymentDetails.isVisible()) {
                warning.setVisible(true);
                warning.setText("Choose Payment Method");
                PauseTransition delay = new PauseTransition(Duration.seconds(1));
                delay.setOnFinished(Event -> warning.setVisible(false));
                delay.play();
                return;
            }
        }

        if(visa1.getText().isEmpty() || visa2.getText().isEmpty() || visa3.getText().isEmpty()){
            if(visa.isSelected()) {
                warning.setVisible(true);
                warning.setText("Please Fill All The Fields");
                PauseTransition delay = new PauseTransition(Duration.seconds(1));
                delay.setOnFinished(Event -> warning.setVisible(false));
                delay.play();
                return;
            }


        }

        if(itemsCart.isEmpty())
            return;
        ReceiptController.itemsReceipt.clear();
        ReceiptController.itemsReceipt.addAll(itemsCart);
        itemsCart.clear();

        visa1.setVisible(false);
        visa2.setVisible(false);
        visa3.setVisible(false);
        cash.setSelected(false);
        visa.setSelected(false);
        scroll.setVvalue(0);
        receiptController.name.setText(LoginController.name);
        receiptController.itemsToReceipt();
        HelloApplication.display(6);

    }

    public void CancelOrder(ActionEvent actionEvent) {
        cash.setSelected(false);
        visa.setSelected(false);
        BasicBox.getChildren().clear();
        HelloApplication.display(3);
        scroll.setVvalue(0);
        itemsCart.clear();
        MenuController.test.clear();
        MenuController.totalCartValue = 0;
        price = 0;
        OrderDone();

    }
    public void setReceiptController(ReceiptController receiptController1){
        receiptController=receiptController1;
    }

}

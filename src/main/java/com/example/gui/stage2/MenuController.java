package com.example.gui.stage2;

import com.example.gui.HelloApplication;
import com.example.gui.Item;
import com.example.gui.stage3.Analysis;
import com.example.gui.stage3.ReceiptController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MenuController {
    @FXML
    ReceiptController receiptController;
    public static int index=0;

    private static List<Pane> paneListApp = new ArrayList<>();
    private List<Pane> paneListMain = new ArrayList<>();
    private List<Pane> paneListDrink = new ArrayList<>();
    public static Boolean Ordered = false;
    @FXML
    private  ScrollPane scrollA;
    @FXML
    private ScrollPane scrollD;
    @FXML
    private ScrollPane scrollM;
    @FXML
    private  HBox BasicBoxApp;
    @FXML
    private HBox BasicBoxMain;
    @FXML
    private HBox BasicBoxDrink;
    @FXML
    static ArrayList<Item> items = new ArrayList<>();
    static public ArrayList<Item> test = new ArrayList<>();
    public static double totalCartValue = 0;

    @FXML
    void Cancel(ActionEvent event) {
        HelloApplication.display(3);
        resetQuantities();
    }
    @FXML
    private void resetQuantities() {
        // Reset quantities for all Appetizer items
        for (Pane pane : paneListApp) {
            ItemController controller = (ItemController) pane.getUserData();
            if (controller != null) {
                controller.Quantity.getValueFactory().setValue(0);  // Reset to 0
            }
        }

        // Reset quantities for all Main Dish items
        for (Pane pane : paneListMain) {
            ItemController controller = (ItemController) pane.getUserData();
            if (controller != null) {
                controller.Quantity.getValueFactory().setValue(0);  // Reset to 0
            }
        }

        // Reset quantities for all Drink items
        for (Pane pane : paneListDrink) {
            ItemController controller = (ItemController) pane.getUserData();
            if (controller != null) {
                controller.Quantity.getValueFactory().setValue(0);  // Reset to 0
            }
        }

        scrollA.setHvalue(0);
        scrollA.setVvalue(0);
        scrollM.setHvalue(0);
        scrollM.setVvalue(0);
        scrollD.setHvalue(0);
        scrollD.setVvalue(0);
    }
    @FXML
    static ItemController itemController;
    @FXML
    void SwitchToCart(ActionEvent event) {
        int i=0;
        for (Pane pane : paneListApp) {
            ItemController controller = (ItemController) pane.getUserData();

            if (controller != null) {
                double itemPrice = Double.parseDouble(controller.Price.getText().replace("$",""));
                int quantity = controller.Quantity.getValue();
                int totalPrice = (int) (itemPrice * quantity);
                Item newItem = new Item(controller.Name.getText(),quantity,itemPrice,controller.Description.getText(),controller.img.getImage().getUrl());

                if(quantity != 0){

                    int idx = test.indexOf((newItem));
                    if(idx == -1) {
                        test.add(newItem);
                    }
                    else {
                        test.get(idx).setQuantity(test.get(idx).getQuantity()+quantity);
                    }
                }
                totalCartValue += totalPrice;
            }
        }

        for (Pane pane : paneListMain) {
            ItemController controller = (ItemController) pane.getUserData();
            if (controller != null) {
                double itemPrice = Double.parseDouble(controller.Price.getText().replace("$",""));
                int quantity = controller.Quantity.getValue();
                int totalPrice = (int) (itemPrice * quantity);
                Item newItem = new Item(controller.Name.getText(),quantity,itemPrice,controller.Description.getText(),controller.img.getImage().getUrl());

                if(quantity != 0) {

                    int idx = test.indexOf((newItem));
                    if (idx == -1) {
                        test.add(newItem);
                    } else {
                        test.get(idx).setQuantity(test.get(idx).getQuantity() + quantity);
                    }

                    totalCartValue += totalPrice;
                }
            }
        }

        for (Pane pane : paneListDrink) {
            ItemController controller = (ItemController) pane.getUserData();
            if (controller != null) {
                double itemPrice = Double.parseDouble(controller.Price.getText().replace("$",""));
                int quantity = controller.Quantity.getValue();
                int totalPrice = (int) (itemPrice * quantity);

                Item newItem = new Item(controller.Name.getText(),quantity,itemPrice,controller.Description.getText(),controller.img.getImage().getUrl());

                if(quantity != 0) {

                    int idx = test.indexOf((newItem));
                    if (idx == -1) {
                        test.add(newItem);
                    } else {
                        test.get(idx).setQuantity(test.get(idx).getQuantity() + quantity);
                    }

                    totalCartValue += totalPrice;
                }
            }
        }


        //
        CartController.itemsCart.clear();
        CartController.itemsCart.addAll(test);
        if(totalCartValue != 0)
            Ordered = true;
        resetQuantities();
    }
    @FXML
    public  void fillItems(String fxml, HBox BasicBox, List<Pane> paneList, ScrollPane scrollH, List<Item> restaurantItems)  {
        test.clear();
        totalCartValue = 0;
        Analysis.itemsAPP.clear();
        Analysis.itemsMAIN.clear();
        Analysis.itemsDRINK.clear();
        for (Item item : restaurantItems) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(MenuController.class.getResource("/com/example/gui/" + fxml));
            ItemController controller;
            Pane childPane;
            try {
                childPane = fxmlLoader.load();
                controller = fxmlLoader.getController();
                itemController = controller;
            } catch (IOException e) {

                throw new RuntimeException(e);
            }

            assert controller != null;
            controller.Name.setText(item.getName());
            controller.Price.setText("$" + item.getPrice());
            controller.Description.setText(item.getDescription());
            controller.setImg(item.getPath());




            childPane.setUserData(controller);

            paneList.add(childPane);
            childPane.setPrefSize(200, 136);
            childPane.setCursor(Cursor.HAND);
            HBox.setMargin(childPane, new Insets(0,50,50,0));
            scrollH.setPrefWidth(scrollH.getPrefWidth() + 150);
            BasicBox.setPrefWidth(BasicBox.getPrefWidth() + 150);
            BasicBox.getChildren().add(childPane);

            controller.Quantity.valueProperty().addListener((observable, oldValue, newValue) -> {
                int q = controller.Quantity.getValue();
                String n = controller.Name.getText();
                double p = Double.parseDouble(controller.Price.getText().replace("$",""));
                String d= controller.Description.getText();
                String h=controller.img.getImage().getUrl();
                items.removeIf(item_ -> item_.getName().equals(n));

                if(q != 0) {
                    items.add(new Item(n, q, p,d,h));
                    CartController.itemsCart.add(new Item(n, q, p,d,h));
                }
            });
        }
    }

    public  void initialize1(int i) {
        BasicBoxApp.getChildren().clear();
        BasicBoxMain.getChildren().clear();
        BasicBoxDrink.getChildren().clear();
        paneListApp.clear();
        paneListMain.clear();
        paneListDrink.clear();
        if(i==0){
            List<Item> KfcAppetizer = MenuLoader.KFC_Appetizer;
            List<Item> KfcMainDish = MenuLoader.KFC_MainDish;
            List<Item> KfcDrinks = MenuLoader.KFC_Drink;
            fillItems("Appetizer.fxml", BasicBoxApp, paneListApp, scrollA,KfcAppetizer);
            fillItems("MainDish.fxml", BasicBoxMain, paneListMain, scrollA,KfcMainDish);
            fillItems("Drink.fxml", BasicBoxDrink, paneListDrink, scrollA,KfcDrinks);

        }
        else if (i==1) {
            List<Item> MacAppetizer = MenuLoader.MAC_Appetizer;
            List<Item> MacMainDish = MenuLoader.MAC_MainDish;
            List<Item> MacDrink = MenuLoader.MAC_Drink;
            fillItems("Appetizer.fxml", BasicBoxApp, paneListApp, scrollA, MacAppetizer);
            fillItems("MainDish.fxml",BasicBoxMain,paneListMain,scrollM,MacMainDish);
            fillItems("Drink.fxml",BasicBoxDrink,paneListDrink, scrollD,MacDrink);
        }
        else if (i==2) {
            List<Item> WahmyAppetizer = MenuLoader.WAHMY_Appetizer;
            List<Item> WahmyMainDish = MenuLoader.WAHMY_MainDish;
            List<Item> WahmyDrink = MenuLoader.WAHMY_Drink;
            fillItems("Appetizer.fxml", BasicBoxApp, paneListApp, scrollA, WahmyAppetizer);
            fillItems("MainDish.fxml",BasicBoxMain,paneListMain,scrollM,WahmyMainDish);
            fillItems("Drink.fxml",BasicBoxDrink,paneListDrink, scrollD,WahmyDrink);
        }
        else if (i==3) {
            List<Item> BuffaloAppetizer = MenuLoader.BUFFALO_Appetizer;
            List<Item>BuffaloMainDish = MenuLoader.BUFFALO_MainDish;
            List<Item> BuffaloDrink = MenuLoader.BUFFALO_Drink;
            fillItems("Appetizer.fxml", BasicBoxApp, paneListApp, scrollA, BuffaloAppetizer);
            fillItems("MainDish.fxml",BasicBoxMain,paneListMain,scrollM,BuffaloMainDish);
            fillItems("Drink.fxml",BasicBoxDrink,paneListDrink, scrollD,BuffaloDrink);
        }




    }


}

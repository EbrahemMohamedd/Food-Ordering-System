package com.example.gui.stage2;
import com.example.gui.HelloApplication;
import com.example.gui.Item;
import com.example.gui.stage1.LoginController;
import com.example.gui.stage2.Restaurants.Buffalo.Buffalo;
import com.example.gui.stage2.Restaurants.Kfc.KFC;
import com.example.gui.stage2.Restaurants.Macdonalds.Macdonalds;
import com.example.gui.stage2.Restaurants.Wahmy.Wahmy;
import com.example.gui.stage3.ReviewController;
import com.example.gui.system;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.awt.event.WindowAdapter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HomePageController {
    public static String RestName;
    public static boolean isPressed=false;
    private MenuController menu;
    @FXML
    private CartController cartController;

    @FXML
    public Label HelloLabel;

    @FXML
    private List<String> restaurantNames = new ArrayList<>();

    @FXML
    private TextField searchField;

    @FXML
    private Label notFound;



    @FXML
        void exit(ActionEvent event) {
        system.clearFile("src/main/java/com/example/gui/stage2/Restaurants/Buffalo/Buffaloappetizer.txt");
        system.clearFile("src/main/java/com/example/gui/stage2/Restaurants/Buffalo/Buffalodrink.txt");
        system.clearFile("src/main/java/com/example/gui/stage2/Restaurants/Buffalo/Buffalomaindish.txt");
        system.clearFile("src/main/java/com/example/gui/stage2/Restaurants/Kfc/Kfcappetizer.txt");
        system.clearFile("src/main/java/com/example/gui/stage2/Restaurants/Kfc/Kfcdrinks.txt");
        system.clearFile("src/main/java/com/example/gui/stage2/Restaurants/Kfc/Kfcmaindish.txt");
        system.clearFile("src/main/java/com/example/gui/stage2/Restaurants/Macdonalds/Macdonaldsappetizer.txt");
        system.clearFile("src/main/java/com/example/gui/stage2/Restaurants/Macdonalds/Macdonaldsdrink.txt");
        system.clearFile("src/main/java/com/example/gui/stage2/Restaurants/Macdonalds/Macdonaldsmaindish.txt");
        system.clearFile("src/main/java/com/example/gui/stage2/Restaurants/Wahmy/Wahmyappetizer.txt");
        system.clearFile("src/main/java/com/example/gui/stage2/Restaurants/Wahmy/Wahmydrink.txt");
        system.clearFile("src/main/java/com/example/gui/stage2/Restaurants/Wahmy/Wahmymaindish.txt");
             KFC kf = new KFC();
        Wahmy wa = new Wahmy();
        Macdonalds mac = new Macdonalds();
        Buffalo bu = new Buffalo();
             for(Item it:MenuLoader.KFC_Drink){
                kf.addItem_to_Drinks(it.getName(),String.valueOf(it.getPrice()),it.getDescription(),it.getPath());
             }
             for(Item it:MenuLoader.KFC_Appetizer){
                kf.addItem_to_Appetizer(it.getName(),String.valueOf(it.getPrice()),it.getDescription(),it.getPath());
            }
            for(Item it:MenuLoader.KFC_MainDish){
                kf.addItem_to_MainMeal(it.getName(),String.valueOf(it.getPrice()),it.getDescription(),it.getPath());
            }
        for(Item it:MenuLoader.MAC_Drink){
            mac.addItem_to_Drinks(it.getName(),String.valueOf(it.getPrice()),it.getDescription(),it.getPath());
        }
        for(Item it:MenuLoader.MAC_MainDish){
            mac.addItem_to_MainMeal(it.getName(),String.valueOf(it.getPrice()),it.getDescription(),it.getPath());
        }for(Item it:MenuLoader.MAC_Appetizer){
            mac.addItem_to_Appetizer(it.getName(),String.valueOf(it.getPrice()),it.getDescription(),it.getPath());
        }
        for(Item it:MenuLoader.BUFFALO_Appetizer){
            bu.addItem_to_Appetizer(it.getName(),String.valueOf(it.getPrice()),it.getDescription(),it.getPath());
        }for(Item it:MenuLoader.BUFFALO_MainDish){
            bu.addItem_to_MainMeal(it.getName(),String.valueOf(it.getPrice()),it.getDescription(),it.getPath());
        }for(Item it:MenuLoader.BUFFALO_Drink){
            bu.addItem_to_Drinks(it.getName(),String.valueOf(it.getPrice()),it.getDescription(),it.getPath());
        }
        for(Item it:MenuLoader.WAHMY_MainDish){
            wa.addItem_to_MainMeal(it.getName(),String.valueOf(it.getPrice()),it.getDescription(),it.getPath());
        }for(Item it:MenuLoader.WAHMY_Drink){
            wa.addItem_to_Drinks(it.getName(),String.valueOf(it.getPrice()),it.getDescription(),it.getPath());
        }for(Item it:MenuLoader.WAHMY_Appetizer){
            wa.addItem_to_Appetizer(it.getName(),String.valueOf(it.getPrice()),it.getDescription(),it.getPath());
        }
        HelloApplication.exit();
        }
        @FXML
        void switchToCart(MouseEvent event) throws IOException {
            cartController.OrderExist();
            HelloApplication.display(5);
        }

        @FXML
        void switchToLogin(MouseEvent event) {
                HelloApplication.display(1);
        }

        @FXML
        void switchToReviews(MouseEvent event) {
            HelloApplication.display(7);
        }


        public static int finalI;

        @FXML
        private VBox BasicBox;

         private List<Pane> paneList = new ArrayList<>();

         @FXML
        private ScrollPane scroll;

    public static final String[] restaurantNamesArray = {"KFC", "Macdonald", "Wahmy", "Buffalo"};
    private final String[] restaurantAddress = {"Shobra El Kheima" , "El Mokattam" , "Hadayek El Kobba" , "Nasr City"};
    private final String[] restaurantPhones = {"01286941822" , "01118844732" , "01091227539" , "01020065580"};
    private final String[] restaurantRates = {"5.0" , "4.0" , "4.7" , "3.8"};
    private final String[] restaurantImg = {"/com/example/gui/assets/KFC LOGO.jpg" , "/com/example/gui/assets/MAC LOGO.jpg" , "/com/example/gui/assets/WAHMY LOGO.png" , "/com/example/gui/assets/BUFFALO LOGO.png"};

    public void initialize() {
        BasicBox.getChildren().remove(notFound);
        for (int i = 0; i < restaurantNamesArray.length; i++) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/com/example/gui/Restaurant.fxml"));
            Pane childPane;
            RestaurantController controller;

            try {
                childPane = fxmlLoader.load();
                controller = fxmlLoader.getController();

            } catch (IOException e) {

                throw new RuntimeException(e);
            }
            paneList.add(childPane);
            controller.setRestName(restaurantNamesArray[i]);
            controller.setRestAdd(restaurantAddress[i]);
            controller.setRestNum(restaurantPhones[i]);
            controller.setRestRate(restaurantRates[i]);
            controller.setimage(restaurantImg[i]);

            restaurantNames.add(restaurantNamesArray[i]);
            childPane.setPrefSize(455, 163);
            childPane.setCursor(Cursor.HAND);
            VBox.setMargin(childPane, new Insets(20));
            BasicBox.setPrefHeight(BasicBox.getPrefHeight() + 100);
            assert scroll != null;
            scroll.setPrefHeight(scroll.getPrefHeight() + 100);
            BasicBox.getChildren().add(childPane);
            int finalI1 = i;
            childPane.setOnMouseClicked(event -> {
                isPressed = true;
                MenuController.index = finalI1;
                menu.initialize1(finalI1);
                finalI = finalI1;
                RestName = restaurantNames.get(finalI1);
                HelloApplication.display(4);
                MenuController.items.clear();
            });
            isPressed = false;

        }
    }

    @FXML
    void searchingRestaurants(ActionEvent event) {
        String query = searchField.getText().toLowerCase();
        List<Pane> filteredPanes = paneList.stream()
                .filter(pane -> {
                    int index = paneList.indexOf(pane);
                    return restaurantNames.get(index).toLowerCase().contains(query);
                })
                .collect(Collectors.toList());
        BasicBox.getChildren().setAll(filteredPanes);
        BasicBox.getChildren().add(notFound);
        notFound.setVisible(filteredPanes.isEmpty());
    }


    public void setCartController(CartController cartController1){
        this.cartController = cartController1;
    }


    public void setMenu(MenuController menuController){

        this.menu=menuController;
    }

    public void setHelloLabel(){
        HelloLabel.setText("Hello, " + LoginController.fname);
    }
}



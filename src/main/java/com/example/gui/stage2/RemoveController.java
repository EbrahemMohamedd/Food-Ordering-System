package com.example.gui.stage2;

import com.example.gui.HelloApplication;
import com.example.gui.Item;
import com.example.gui.stage2.Restaurants.Buffalo.Buffalo;
import com.example.gui.stage2.Restaurants.Kfc.KFC;
import com.example.gui.stage2.Restaurants.Macdonalds.Macdonalds;
import com.example.gui.stage2.Restaurants.Wahmy.Wahmy;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class RemoveController {
    int i = 0;

    @FXML
    public adminController adminController;


    @FXML
    public TextField item;

    @FXML
    public MenuButton menubutton1;

    @FXML
    private Text fail;


    @FXML
    public void initialize() {
        // Create menu items
        MenuItem appetizer = new MenuItem("Appetizer");
        MenuItem maindish = new MenuItem("Maindish");
        MenuItem drink = new MenuItem("Drink");

        // Add actions for menu items
        appetizer.setOnAction(event -> {
            i = 1;
            menubutton1.setText(appetizer.getText());
        });
        maindish.setOnAction(event -> {
            i = 2;
            menubutton1.setText(maindish.getText());
        });
        drink.setOnAction(event -> {
            i = 3;
            menubutton1.setText(drink.getText());
        });

        // Add items to the MenuButton
        menubutton1.getItems().addAll(appetizer, maindish, drink);
    }


    @FXML
    public void setNull() {
        item.setText("");


    }

    @FXML
    boolean isEmpty = false;

    @FXML
    public void checkFields() {
        TextField[] textFields = {item};
        for (TextField textField : textFields) {
            isEmpty = textField.getText().isEmpty();
            if (isEmpty)
                break;
        }
        if (isEmpty || i == 0) {

            fail.setText("Fill All the Fields");
        }
    }

    @FXML
    void confirm(MouseEvent event) {
        menubutton1.setText("Choose");
        String name = item.getText();
//        Item removeitem = new Item(name);
        checkFields();

        if (isEmpty || i == 0) {
            checkFields();
            return;
        }
        if (adminController.rest.getText().equals("KFC")) {
//            KFC kf = new KFC();
            if (i == 1) {
                MenuLoader.KFC_Appetizer.removeIf(it -> name.equalsIgnoreCase(it.getName()));

            } else if (i == 2) {
                MenuLoader.KFC_MainDish.removeIf(removee -> removee.getName().equalsIgnoreCase(name));
            } else if (i == 3) {
                MenuLoader.KFC_Drink.removeIf(removee -> removee.getName().equalsIgnoreCase(name));

            }
        }
        if (adminController.rest.getText().equals("Buffalo")) {
            Buffalo buf = new Buffalo();
            if (i == 1) {
                MenuLoader.BUFFALO_Appetizer.removeIf(remove -> remove.getName().equalsIgnoreCase(name));

            } else if (i == 2) {
                MenuLoader.BUFFALO_MainDish.removeIf(remove -> remove.getName().equalsIgnoreCase(name));

            } else if (i == 3) {
                MenuLoader.BUFFALO_Drink.removeIf(remove -> remove.getName().equalsIgnoreCase(name));
            }
        }
        if (adminController.rest.getText().equals("Macdonald")) {
            Macdonalds mac = new Macdonalds();
            if (i == 1) {
                MenuLoader.MAC_Appetizer.removeIf(remove -> remove.getName().equalsIgnoreCase(name));
            } else if (i == 2) {
                MenuLoader.MAC_MainDish.removeIf(remove -> remove.getName().equalsIgnoreCase(name));

            } else if (i == 3) {
                MenuLoader.MAC_Drink.removeIf(remove -> remove.getName().equalsIgnoreCase(name));
            }
        }

        if (adminController.rest.getText().equals("Wahmy")) {
            Wahmy w = new Wahmy();
            if (i == 1) {
                MenuLoader.WAHMY_Appetizer.removeIf(remove -> remove.getName().equalsIgnoreCase(name));

            } else if (i == 2) {
                MenuLoader.WAHMY_MainDish.removeIf(remove -> remove.getName().equalsIgnoreCase(name));

            } else if (i == 3) {
                MenuLoader.WAHMY_Drink.removeIf(remove -> remove.getName().equalsIgnoreCase(name));
            }
        }








        setNull();
        HelloApplication.display(9);
        i=0;

    }





    @FXML
    void cancel(MouseEvent event){
        menubutton1.setText("Choose");
        i=0;
        HelloApplication.display(9);
    }

    public void setAdminController(adminController adminController1){
        adminController=adminController1;
    }

}

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

public class EditController {
    @FXML
    private adminController adminController;


    @FXML
    public Text fail;

    @FXML
    public TextField item;

    @FXML
    public TextField price;


    @FXML
    public MenuButton menubutton2;

    int i = 0;

    @FXML
    public void initialize() {
        MenuItem appetizer = new MenuItem("Appetizer");
        MenuItem maindish = new MenuItem("Maindish");
        MenuItem drink = new MenuItem("Drink");

        appetizer.setOnAction(event -> {
            i = 1;
            menubutton2.setText(appetizer.getText());
        });
        maindish.setOnAction(event -> {
            i = 2;
            menubutton2.setText(maindish.getText());
        });
        drink.setOnAction(event -> {
            i = 3;
            menubutton2.setText(drink.getText());
        });

        menubutton2.getItems().addAll(appetizer, maindish, drink);
    }


    @FXML
    public void setNull() {
        item.setText("");
        price.setText("");


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
    void confirm1(MouseEvent event) {
        String name = item.getText();
        if (!price.getText().matches("-?\\d+(\\.\\d+)?")) {
            fail.setText("Price is invalid");
            return;
        }
        checkFields();
        if (isEmpty || i == 0) {
            checkFields();
            return;
        }
        menubutton2.setText("Choose");

        if (adminController.rest.getText().equals("KFC")) {
            if (i == 1) {
                for (Item it : MenuLoader.KFC_Appetizer) {
                    if (it.getName().trim().equalsIgnoreCase(name)) {
                        it.setprice(String.valueOf(price.getText()));
                    }
                }
            } else if (i == 2) {
                for (Item it : MenuLoader.KFC_MainDish) {
                    if (it.getName().trim().equalsIgnoreCase(name)) {
                        it.setprice(String.valueOf(price.getText()));
                    }
                }
            } else if (i == 3) {
                for (Item it : MenuLoader.KFC_Drink) {
                    if (it.getName().equals(name)) {
                        it.setprice(String.valueOf(price.getText()));
                    }
                }
            }
        }
        if (adminController.rest.getText().equals("Buffalo")) {
            if (i == 1) {
                for (Item it : MenuLoader.BUFFALO_Appetizer) {
                    if (it.getName().trim().equalsIgnoreCase(name)) {
                        it.setprice(String.valueOf(price.getText()));
                    }
                }
            } else if (i == 2) {
                for (Item it : MenuLoader.BUFFALO_MainDish) {
                    if (it.getName().trim().equalsIgnoreCase(name)) {
                        it.setprice(String.valueOf(price.getText()));
                    }
                }
            } else if (i == 3) {
                for (Item it : MenuLoader.BUFFALO_Drink) {
                    if (it.getName().equals(name)) {
                        it.setprice(String.valueOf(price.getText()));
                    }
                }
            }
        }
        if (adminController.rest.getText().equals("Macdonald")) {
            if (i == 1) {
                for (Item it : MenuLoader.MAC_Appetizer) {
                    if (it.getName().trim().equalsIgnoreCase(name)) {
                        it.setprice(String.valueOf(price.getText()));
                    }
                }
            } else if (i == 2) {
                for (Item it : MenuLoader.MAC_MainDish) {
                    if (it.getName().trim().equalsIgnoreCase(name)) {
                        it.setprice(String.valueOf(price.getText()));
                    }
                }
            } else if (i == 3) {
                for (Item it : MenuLoader.MAC_Drink) {
                    if (it.getName().equals(name)) {
                        it.setprice(String.valueOf(price.getText()));
                    }
                }
            }
        }
        if (adminController.rest.getText().equals("Wahmy")) {
            if (i == 1) {
                for (Item it : MenuLoader.WAHMY_Appetizer) {
                    if (it.getName().trim().equalsIgnoreCase(name)) {
                        it.setprice(String.valueOf(price.getText()));
                    }
                }
            } else if (i == 2) {
                for (Item it : MenuLoader.WAHMY_MainDish) {
                    if (it.getName().trim().equalsIgnoreCase(name)) {
                        it.setprice(String.valueOf(price.getText()));
                    }
                }
            } else if (i == 3) {
                for (Item it : MenuLoader.WAHMY_Drink) {
                    if (it.getName().equals(name)) {
                        it.setprice(String.valueOf(price.getText()));
                    }
                }
            }
        }


        setNull();
        HelloApplication.display(9);
        i = 0;
    }
    @FXML
    public void cancel1(MouseEvent mouseEvent) {
        menubutton2.setText("choose");
        i=0;
        HelloApplication.display(9);
    }
    public void setAdminController (adminController adminController1){
        adminController = adminController1;
    }
}















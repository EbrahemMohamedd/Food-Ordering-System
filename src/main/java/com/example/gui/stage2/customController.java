package com.example.gui.stage2;

import com.example.gui.HelloApplication;
import com.example.gui.Item;
import com.example.gui.stage2.Restaurants.*;
import com.example.gui.stage2.Restaurants.Buffalo.Buffalo;
import com.example.gui.stage2.Restaurants.Kfc.KFC;
import com.example.gui.stage2.Restaurants.Macdonalds.Macdonalds;
import com.example.gui.stage2.Restaurants.Wahmy.Wahmy;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.util.Objects;

public class customController {
    @FXML
    private adminController adminController;

    @FXML
    public Button cancel;
    @FXML
    public Button confirm;
    @FXML
    private TextField nameitem;

    @FXML
    private TextField des;
    @FXML
    private TextField price;
    @FXML
    private Text fail;
    @FXML
    private Text path;
    @FXML
    private ImageView view;

    int i;
    String imgPath;

    @FXML
    private MenuButton menuButton; // Reference to MenuButton from FXML

    @FXML
    public void initialize() {
        // Create menu items
        MenuItem appetizer = new MenuItem("Appetizer");
        MenuItem maindish = new MenuItem("Maindish");
        MenuItem drink = new MenuItem("Drink");

        // Add actions for menu items
        appetizer.setOnAction(event ->{i = 1;menuButton.setText(appetizer.getText());} );
        maindish.setOnAction(event -> {i = 2;menuButton.setText(maindish.getText());});
        drink.setOnAction(event -> {i = 3;menuButton.setText(drink.getText());});

        // Add items to the MenuButton
        menuButton.getItems().addAll(appetizer, maindish, drink);
    }


    @FXML
    public void setNull() {
        nameitem.setText("");
        price.setText("");

        des.setText("");
        fail.setText("");
        path.setText("");
        view.setImage(null);
    }

    @FXML
    boolean isEmpty = false;

    @FXML
    public void checkFields() {
        TextField[] textFields = {nameitem, price, des};
        for (TextField textField : textFields) {
            isEmpty = textField.getText().isEmpty() & path.getText().isEmpty();

            if (isEmpty)
                break;
        }
         if(isEmpty||i==0)
        {

        fail.setText("Fill All the Fields");
         }
    }




    @FXML
    void confirm(MouseEvent event) {
        if(isEmpty||i==0 || path.getText().isEmpty())
        {
            checkFields();
            return;
        }
        if(price.getText().isEmpty()){
            checkFields();
            return;
        }
        if(!price.getText().matches("-?\\d+(\\.\\d+)?"))
        {
            fail.setText("Price is invalid");
            PauseTransition delay = new PauseTransition(Duration.seconds(2));
            delay.setOnFinished(Event -> fail.setText(""));
            delay.play();
            return;
        }

        menuButton.setText("Choose");
        String itemname = nameitem.getText();
        Double itemPrice = Double.parseDouble(price.getText().replace("$",""));
        String itemdescription = des.getText();


        Item newItem = new Item(itemname,0,itemPrice,itemdescription,imgPath);
        checkFields();
        if(isEmpty||i==0 || path.getText().isEmpty())
        {
            checkFields();
            return;
        }
        if (adminController.rest.getText().equals("KFC")) {
            KFC kfc = new KFC();
            if (i == 1) {
                MenuLoader.KFC_Appetizer.add(newItem);
            } else if (i == 2) {
                MenuLoader.KFC_MainDish.add(newItem);
            } else if (i == 3) {
                MenuLoader.KFC_Drink.add(newItem);
            }


        }
        if (adminController.rest.getText().equals("Buffalo")) {
            Buffalo buffalo = new Buffalo();
            if (i == 1) {
                MenuLoader.BUFFALO_Appetizer.add(newItem);
            } else if (i == 2) {
                MenuLoader.BUFFALO_MainDish.add(newItem);
            } else if (i == 3) {
                MenuLoader.BUFFALO_Drink.add(newItem);
            }
        }
        if (adminController.rest.getText().equals("Macdonald")) {
            Macdonalds macdonalds = new Macdonalds();
            if (i == 1) {
                MenuLoader.MAC_Appetizer.add(newItem);
            } else if (i == 2) {
                MenuLoader.MAC_MainDish.add(newItem);
            } else if (i == 3) {
                MenuLoader.MAC_Drink.add(newItem);
            }
        }
        if (adminController.rest.getText().equals("Wahmy")) {
            Wahmy wahmy = new Wahmy();
            if (i == 1) {
                MenuLoader.WAHMY_Appetizer.add(newItem);
            } else if (i == 2) {
                MenuLoader.WAHMY_MainDish.add(newItem);
            } else if (i == 3) {
                MenuLoader.WAHMY_Drink.add(newItem);
            }
        }

            setNull();
            HelloApplication.display(9);

        i=0;
    }
    @FXML
    void cancel(MouseEvent event) {
        menuButton.setText("Choose");
        i=0;
        HelloApplication.display(9);
    }

    @FXML

    public void imageImport(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Image File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );

        // Open the FileChooser dialog
        File selectedFile = fileChooser.showOpenDialog(new Stage());

        if (selectedFile != null) {
            String absolutePath = selectedFile.getAbsolutePath();
            System.out.println("Absolute Path: " + absolutePath);

            // Define the base directory for resources
            String basePath = new File("src/main/resources").getAbsolutePath();

            // Normalize the paths for compatibility across OS
            absolutePath = absolutePath.replace("\\", "/");
            basePath = basePath.replace("\\", "/");

            // Check if the selected file is within the resources directory
            if (absolutePath.startsWith(basePath)) {
                String relativePath = absolutePath.substring(basePath.length() + 1); // Skip the base path and the separator
                path.setText(relativePath);
                view.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/" + relativePath))));
                imgPath = '/' + relativePath;
            } else {
                path.setText("Please Choose Image From Assets Folder");
            }
        } else {
            path.setText("No file selected.");
        }
    }
    public void setAdminController(adminController adminController1) {

        adminController = adminController1;

    }
}


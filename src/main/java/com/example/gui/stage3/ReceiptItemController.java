package com.example.gui.stage3;

import com.example.gui.Item;
import javafx.fxml.FXML;

import javafx.scene.control.Label;

public class ReceiptItemController {



    @FXML
    public Label name;

    @FXML
    public Label price;

    @FXML
    public Label quantity;


    public void fill(Item item) {
        this.price.setText(item.getQuantity() * item.getPrice() + "$");
        this.name.setText(item.getName());
        this.quantity.setText("" + item.getQuantity());
    }




}

package com.example.gui.stage3;

import com.example.gui.Item;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AnalysisItemController {


    @FXML
    public Label ItemName;

    @FXML
    public Label Price;

    @FXML
    public Label quantity;

    public void fill(Item item) {
        this.Price.setText(item.getQuantity() * item.getPrice() + "$");
        this.ItemName.setText(item.getName());
        this.quantity.setText("" + item.getQuantity());
    }
    
    
}

package com.example.gui.stage2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class ItemController {

    @FXML
    public Label Description;

    @FXML
    public Label Name;

    @FXML
    public Label Price;

    @FXML
    public Spinner<Integer> Quantity;


    public ImageView img;


    @FXML
    private SplitMenuButton cust;



    public void setImg(String path){
        Image image = new Image(Objects.requireNonNull(getClass().getResource(path)).toString());
        img.setImage(image);

    }

    public void initialize(){
        Quantity.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0,1));

    }



}

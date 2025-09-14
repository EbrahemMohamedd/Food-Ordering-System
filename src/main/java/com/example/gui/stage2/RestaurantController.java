package com.example.gui.stage2;
import com.example.gui.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class RestaurantController {


    @FXML
    private Label RestAdd = new Label("");

    @FXML
    private Label RestName = new Label("");

    @FXML
    private Label RestNum = new Label("");

    @FXML
    private Label RestRate = new Label("");

    @FXML
    private ImageView image;
    @FXML
    private String url;
    public Label getRestAdd() {
        return RestAdd;
    }

    public void setRestAdd(String restAdd) {
        RestAdd.setText(restAdd);
    }

    public Label getRestName() {
        return RestName;
    }

    public void setRestName(String restName) {
        RestName.setText(restName);
    }

    public Label getRestNum() {
        return RestNum;
    }

    public void setRestNum(String restNum) {
        RestNum.setText(restNum);
    }

    public Label getRestRate() {
        return RestRate;
    }

    public void setRestRate(String restRate) {
        RestRate.setText(restRate);
    }

    public void setimage(String path){
        Image img = new Image(Objects.requireNonNull(getClass().getResource(path)).toString());
        image.setImage(img);

    }
}

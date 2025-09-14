package com.example.gui.stage2;


import com.example.gui.Item;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ItemCartController {

    public Label price;
    public Label name;
    public Label quantity;
    public ImageView imgCart;
    public Boolean delete =false;
    public void initialize() {


    }



    public void Delete(MouseEvent mouseEvent) {
        delete = true;
    }

    public void fill(Item item){
        this.price.setText(item.getQuantity() * item.getPrice() + "$");
        this.name.setText(item.getName());
        this.quantity.setText( "" + item.getQuantity());
        this.imgCart.setImage(new Image(item.getPath()));
}

}

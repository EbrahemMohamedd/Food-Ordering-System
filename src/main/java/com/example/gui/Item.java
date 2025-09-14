package com.example.gui;

import javafx.scene.control.TextField;

public class Item {
    String name;
    int quantity;
    double price;
    String description;
    String path;


    public Item(String name, int quantity, double price, String description,String path) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.description=description;
        this.path=path;
    }

    public String getPath() {
        return path;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    public void setname(String name) {
        this.name= name;
    }

    public void setprice(String price) {
        this.price = Double.parseDouble(price);
    }
}
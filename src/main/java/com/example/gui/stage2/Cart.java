package com.example.gui.stage2;
//import java.io.FileWriter;
//import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Item> items;
    public Cart() {
        this.items = new ArrayList<>();
    }
    public void addItem(String name, double price, int quantity) {
        for (Item item : items) {
            if (item.getName().equals(name)) {
                item.incrementQuantity( quantity);
            }
        }
        // If the item doesn't exist, add it with the specified quantity
        items.add(new Item( name , price , quantity));
    }

    public void incrementItem(String name,int quantity) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                item.incrementQuantity(quantity);

            }
        }
    }
//
    public void decrementItem(String name) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                item.decrementquantity();

            }
        }
    }


    public void removeItem(String name) {
        items.removeIf(Item -> Item.getName().equals(name));

    }

    public double getItemPrice(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item.getTotalPrice();
            }
            }
        return 0;
        }

    public double getTotalPrice() {
        double total = 0;
        for (Item cartItem : items) {
            total += cartItem.getTotalPrice();
        }
        return total;
    }

    public List<Item> getItems() {
        return items;  //pass to order file
    }


    public void clearCart() {
        items.clear();
    }

    public class Item {
        public String name;
        public double price;
        public int quantity;


        public Item(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = 0;
        }
        public String getName() {
            return name;
        }
        public double getPrice() {
            return price;
        }
        public int getQuantity() {
            return quantity;
        }
        public void incrementQuantity(int quantity) {
            this.quantity++;
        }
        public void decrementquantity(){
            if (quantity>0){
                quantity--;
            }
        }
        public double getTotalPrice() {
            return price * quantity;
        }
    }
}

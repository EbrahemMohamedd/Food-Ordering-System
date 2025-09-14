package com.example.gui.stage2.Restaurants;

public interface Menu {

    public void addItem_to_Appetizer(String name, String price,String description,String img );
    public void addItem_to_Drinks(String name, String price,String description,String img);
    public void addItem_to_MainMeal(String name, String price,String description,String img);
    public void edit_in_Appetizer(String name,String price);
    public void edit_in_Drinks(String name,String price);
    public void edit_in_MainMeal(String name,String price);
    public void remove_in_Drinks(String name );
    public void remove_in_Appetizer(String name );
    public void remove_in_MainMeal(String name );
}


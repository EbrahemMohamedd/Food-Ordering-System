package com.example.gui.stage2;
import com.example.gui.Item;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MenuLoader {

    public static List<Item> KFC_Appetizer =  new ArrayList<>();
    public static List<Item> KFC_MainDish = new ArrayList<>();
    public static List<Item> KFC_Drink = new ArrayList<>();

    public static List<Item> MAC_Appetizer = new ArrayList<>();
    public static List<Item> MAC_MainDish = new ArrayList<>();
    public static List<Item> MAC_Drink = new ArrayList<>();

    public static List<Item> WAHMY_Appetizer = new ArrayList<>();
    public static List<Item> WAHMY_MainDish = new ArrayList<>();
    public static List<Item> WAHMY_Drink = new ArrayList<>();

    public static List<Item> BUFFALO_Appetizer = new ArrayList<>();
    public static List<Item> BUFFALO_MainDish = new ArrayList<>();
    public static List<Item> BUFFALO_Drink = new ArrayList<>();


    public static void initialize(){
        KFC_Appetizer = loadMenuFromFile("src/main/java/com/example/gui/stage2/Restaurants/Kfc/Kfcappetizer.txt");
        KFC_MainDish = loadMenuFromFile("src/main/java/com/example/gui/stage2/Restaurants/Kfc/Kfcmaindish.txt");
        KFC_Drink = loadMenuFromFile("src/main/java/com/example/gui/stage2/Restaurants/Kfc/Kfcdrinks.txt");

        MAC_Appetizer = loadMenuFromFile("src/main/java/com/example/gui/stage2/Restaurants/Macdonalds/Macdonaldsappetizer.txt");
        MAC_MainDish  = loadMenuFromFile("src/main/java/com/example/gui/stage2/Restaurants/Macdonalds/Macdonaldsmaindish.txt");
        MAC_Drink  = loadMenuFromFile("src/main/java/com/example/gui/stage2/Restaurants/Macdonalds/Macdonaldsdrink.txt");;

        WAHMY_Appetizer = loadMenuFromFile("src/main/java/com/example/gui/stage2/Restaurants/Wahmy/Wahmyappetizer.txt");
        WAHMY_MainDish = loadMenuFromFile("src/main/java/com/example/gui/stage2/Restaurants/Wahmy/Wahmymaindish.txt");
        WAHMY_Drink = loadMenuFromFile("src/main/java/com/example/gui/stage2/Restaurants/Wahmy/Wahmydrink.txt");

        BUFFALO_Appetizer = loadMenuFromFile("src/main/java/com/example/gui/stage2/Restaurants/Buffalo/Buffaloappetizer.txt");
        BUFFALO_MainDish = loadMenuFromFile("src/main/java/com/example/gui/stage2/Restaurants/Buffalo/Buffalomaindish.txt");
        BUFFALO_Drink = loadMenuFromFile("src/main/java/com/example/gui/stage2/Restaurants/Buffalo/Buffalodrink.txt");

    }

   public static List<Item> loadMenuFromFile(String filePath) {
        List<Item> items = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 4) {
                    String name = parts[0].split(": ")[1];
                    double price = Double.parseDouble(parts[1].split(": ")[1]);
                    String description=parts[2].split(": ")[1];
                    String path=parts[3].split(": ")[1];
                    items.add(new Item(name, 0, price,description,path)); // Quantity starts at 0
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading menu file: " + e.getMessage());
        }
        return items;
    }
}

package com.example.gui.stage2.Restaurants.Kfc;

import com.example.gui.stage2.Restaurants.Menu;
import com.example.gui.stage2.Restaurants.Restaurant;

import java.util.List;

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

public class KFC extends Restaurant implements Menu {
    public KFC() {
    }




    public KFC(String name, String address, String contactInfo, double rating) {

        super(name, address, contactInfo, rating);

    }


    public void savekfcitem(String name, String price, String description ,String img,String fileName) {
        try {
            String packagePath = "src/main/java/com/example/gui/stage2/Restaurants/Kfc";
            File file = new File(packagePath, fileName);

            if (!file.exists()) {
                file.createNewFile();
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                writer.write("name: " + name + ", price: " + price + ", description: " + description + ", Image: " + img );
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editprice(String name, String price, String filePath) {
        String packagePath = "src/main/java/com/example/gui/stage2/Restaurants/Kfc";
        File file = new File(packagePath, filePath);

        try {
            // Read the entire file into a string
            String fileContent = new String(Files.readAllBytes(file.toPath()));
            StringBuilder updatedContent = new StringBuilder();

            // Process the file line by line
            String[] lines = fileContent.split("\\r?\\n"); // Handle both Windows and Unix newlines
            boolean isUpdated = false;

            for (String line : lines) {
                String[] parts = line.split(", ");
                if (parts.length == 3) {
                    String savedName = parts[0].split(": ")[1];

                    if (savedName.equalsIgnoreCase(name)) {
                        parts[1] = "price: " + price; // Update the price
                        isUpdated = true;
                    }
                    line = String.join(", ", parts); // Reconstruct the line
                }
                updatedContent.append(line).append(System.lineSeparator());
            }

            if (!isUpdated) {
                System.out.println("Item not found: " + name);
            }

            // Write the updated content back to the file
            Files.write(file.toPath(), updatedContent.toString().getBytes());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(String name, String filepath) {
        String packagePath = "src/main/java/com/example/gui/stage2/Restaurants/Kfc";
        File file = new File(packagePath, filepath);

        try {
            // Read the entire file into a string
            String fileContent = new String(Files.readAllBytes(file.toPath()));
            StringBuilder updatedContent = new StringBuilder();

            // Process the file line by line
            String[] lines = fileContent.split("\\r?\\n"); // Handle both Windows and Unix newlines
            boolean isRemoved = false;

            for (String line : lines) {
                String[] parts = line.split(", ");
                if (parts.length == 3) {
                    String savedName = parts[0].split(": ")[1];

                    if (savedName.equalsIgnoreCase(name)) {
                        isRemoved = true;
                        continue; // Skip this line, effectively removing it
                    }
                }
                updatedContent.append(line).append(System.lineSeparator());
            }

            if (!isRemoved) {
                System.out.println("Item not found: " + name);
            }

            // Write the updated content back to the file
            Files.write(file.toPath(), updatedContent.toString().getBytes());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
    // here remove




    public  void addItem_to_Drinks(String name, String price,String description,String img){
        savekfcitem(name,price,description,img,"/Kfcdrinks.txt");
    }
    public void addItem_to_MainMeal(String name, String price,String description,String img){
        savekfcitem(name,price,description,img,"/Kfcmaindish.txt");
    }
    public void addItem_to_Appetizer(String name, String price,String description,String img){
        savekfcitem(name,price,description,img,"/Kfcappetizer.txt");
    }

    public void edit_in_Appetizer(String name,String price) {
        editprice(name,price,"/Kfcappetizer.txt");

    }
    public void edit_in_Drinks(String name,String price){
        editprice(name,price,"/Kfcdrinks.txt");


    }
    public void edit_in_MainMeal(String name,String price) {
        editprice(name, price, "/Kfcmaindish.txt");


    }

    public void remove_in_Appetizer(String name){
        remove(name,"/Kfcappetizer.txt");


    }
    public void remove_in_Drinks(String name){
        remove(name,"/Kfcdrinks.txt");


    }
    public void remove_in_MainMeal(String name){
        remove(name,"/Kfcmaindish.txt");


    }


}

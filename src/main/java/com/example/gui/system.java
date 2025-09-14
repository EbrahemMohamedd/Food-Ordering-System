package com.example.gui;
import javafx.util.Pair;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class system {
    public static Map<Pair<String,String>,Integer>Owners = new HashMap<>();
    public static ArrayList<User> userList = new ArrayList<>();

    public static void InitializeOwnersAccount(){
        Owners.put(new Pair<>("KFC","Kfc"),9);
        Owners.put(new Pair<>("Macdonald","mac"),9);
        Owners.put(new Pair<>("Buffalo","Buffalo"),9);
        Owners.put(new Pair<>("Wahmy","Wahmy"),9);
    }
    public static boolean isOwnerAccount(String email,String password){
        Pair<String,String>key = new Pair<>(email,password);
        return Owners.containsKey(key);
    }
    public static int valueOfAccountscene(String email,String password){
        Pair<String,String>key = new Pair<>(email,password);
        return Owners.get(key);
    }

    public static int index;


    public static void saveUserCredentials() {
        System.out.println(userList);
        String filePath = "user_credentials.txt";
        try {
            File file = new File(filePath);
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                for (User user : userList) {
                    bw.write(String.valueOf(user));
                    bw.newLine();
                }
            }
            System.out.println("User credentials saved to " + filePath);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
    public static boolean checkCredentials(ArrayList<User> users, String email, String password) {
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                index = users.indexOf(user);    
                return true;
            }
        }
        return false;
    }
    public static void loadUsersFromFile(String filePath) {
        ArrayList<User> users = new ArrayList<>();

        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File not found: " + filePath);
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 6) {
                    try {
                        String Fname = parts[0].split(": ")[1];
                        String Lname = parts[1].split(": ")[1];
                        String email = parts[2].split(": ")[1];
                        String phone = parts[3].split(": ")[1];
                        String address = parts[4].split(": ")[1];
                        String password = parts[5].split(": ")[1];

                        users.add(new User(Fname, Lname, password, email, phone, address));
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Malformed line: " + line);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

        userList = users;
    }
    public static boolean fakeEmail(ArrayList<User> users, String mail) {
        for (User user : users) {
            if (user.getEmail().equals(mail)) {
                return true;
            }
        }
        return false;
    }
    public static void clearFile(String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }


}
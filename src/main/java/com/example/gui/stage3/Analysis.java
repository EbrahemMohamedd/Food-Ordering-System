package com.example.gui.stage3;

import com.example.gui.*;
import com.example.gui.stage1.LoginController;
import com.example.gui.stage2.HomePageController;
import com.example.gui.stage2.MenuLoader;
import com.example.gui.stage2.adminController;
import javafx.fxml.FXML;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Analysis {

    @FXML
    static adminController AdminController;


    public static ArrayList<Item> toAnalysisList = new ArrayList<>();
    public static ArrayList<Item> itemsAPP = new ArrayList<>();
    public static ArrayList<Item> itemsMAIN = new ArrayList<>();
    public static ArrayList<Item> itemsDRINK = new ArrayList<>();

    public static void LoaderAPP(List<Item> APP_Loader) {
        for (Item analysisItem : toAnalysisList) {
            for (Item appItem : APP_Loader) {
                if (analysisItem.getName().equals(appItem.getName())) {
                    itemsAPP.add(analysisItem);
                }
            }
        }
    }

    public static void LoaderMAIN(List<Item> Main_Loader) {
        for (Item analysisItem : toAnalysisList) {
            for (Item mainItem : Main_Loader) {
                if (analysisItem.getName().equals(mainItem.getName())) {
                    itemsMAIN.add(analysisItem);
                }
            }
        }
    }
    public static void LoaderDRINK(List<Item> Drink_Loader) {
        for (Item analysisItem : toAnalysisList) {
            for (Item drinkItem : Drink_Loader) {
                if (analysisItem.getName().equals(drinkItem.getName())) {
                    itemsDRINK.add(analysisItem);
                }
            }
        }
    }

    public static void Main(){
        itemsMAIN.clear();
        itemsAPP.clear();
        itemsDRINK.clear();

        String name = LoginController.name;
        if(AdminController.rest.getText().equals("KFC")){

            LoaderAPP(MenuLoader.KFC_Appetizer);
            LoaderMAIN(MenuLoader.KFC_MainDish);
            LoaderDRINK(MenuLoader.KFC_Drink);
        }

        else if(AdminController.rest.getText().equalsIgnoreCase("buffalo")){

            LoaderAPP(MenuLoader.BUFFALO_Appetizer);
            LoaderMAIN(MenuLoader.BUFFALO_MainDish);
            LoaderDRINK(MenuLoader.BUFFALO_Drink);
        }

        else if(AdminController.rest.getText().equalsIgnoreCase("wahmy")){

            LoaderAPP(MenuLoader.WAHMY_Appetizer);
            LoaderMAIN(MenuLoader.WAHMY_MainDish);
            LoaderDRINK(MenuLoader.WAHMY_Drink);
        }

        else if(AdminController.rest.getText().equalsIgnoreCase("Macdonald")){

            LoaderAPP(MenuLoader.MAC_Appetizer);
            LoaderMAIN(MenuLoader.MAC_MainDish);
            LoaderDRINK(MenuLoader.MAC_Drink);
        }
    }

    public void setClear(){
        itemsDRINK.clear();
        itemsAPP.clear();
        itemsMAIN.clear();

    }


    public void setAdminController(adminController adminController1){
        AdminController = adminController1;
    }

}

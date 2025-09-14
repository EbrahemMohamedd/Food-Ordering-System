package com.example.gui;
import com.example.gui.stage1.LoginController;
import com.example.gui.stage2.*;
import com.example.gui.stage3.Analysis;
import com.example.gui.stage3.AnalysisController;
import com.example.gui.stage3.ReceiptController;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.lang.System;
import java.util.Objects;

    public class HelloApplication extends Application {





    static Stage stg;
    static Scene[] sc = new Scene[13];
    @Override
    public void start(Stage stage) throws IOException {





        stg = stage;
        stage.setResizable(false);
        FXMLLoader loading = new FXMLLoader(HelloApplication.class.getResource("Loading.fxml"));
        Scene scene = new Scene(loading.load(), 700, 700);
        sc[0]= scene;
       String css = Objects.requireNonNull(this.getClass().getResource("css.css")).toExternalForm();
       scene.getStylesheets().add(css);


        FXMLLoader login = new FXMLLoader(HelloApplication.class.getResource("LogIn.fxml"));
        Scene scene1 = new Scene(login.load(), 700, 700);
        scene1.getStylesheets().add(css);
        sc[1]= scene1;


        FXMLLoader sign = new FXMLLoader(HelloApplication.class.getResource("SignUp.fxml"));
        Scene scene2 = new Scene(sign.load(), 700, 700);
        sc[2] = scene2;

        FXMLLoader home = new FXMLLoader(HelloApplication.class.getResource("HomePage.fxml"));
        Scene scene3 = new Scene(home.load(), 700, 900);
        sc[3] = scene3;
        scene3.getStylesheets().add(css);

        FXMLLoader menu = new FXMLLoader(HelloApplication.class.getResource("Menu.fxml"));
        Scene scene4 = new Scene(menu.load(), 700,900);
        sc[4] = scene4;
        scene4.getStylesheets().add(css);

        FXMLLoader cart = new FXMLLoader(HelloApplication.class.getResource("Cart.fxml"));
        Scene scene5 = new Scene(cart.load(), 700,900);
        sc[5] = scene5;
        scene5.getStylesheets().add(css);

        FXMLLoader receipt = new FXMLLoader(HelloApplication.class.getResource("Receipt.fxml"));
        Scene scene6 = new Scene(receipt.load(), 700,700);
        sc[6] = scene6;
        scene6.getStylesheets().add(css);

        FXMLLoader review = new FXMLLoader(HelloApplication.class.getResource("Review.fxml"));
        Scene scene7 = new Scene(review.load(),700,900);
        sc[7] = scene7;//

        FXMLLoader analysis = new FXMLLoader(HelloApplication.class.getResource("Analysis.fxml"));
        Scene scene8 = new Scene(analysis.load(),900,900);
        sc[8] = scene8;

        FXMLLoader admin = new FXMLLoader(HelloApplication.class.getResource("admin.fxml"));
        Scene scene9 = new Scene(admin.load(), 700,700);
        sc[9] = scene9;
        scene9.getStylesheets().add(css);

        FXMLLoader custom = new FXMLLoader(HelloApplication.class.getResource("custom.fxml"));
        Scene scene10 = new Scene(custom.load(), 700,900);
        sc[10] = scene10;
        scene10.getStylesheets().add(css);

        FXMLLoader remove = new FXMLLoader(HelloApplication.class.getResource("Remove.fxml"));
        Scene scene11 = new Scene(remove.load(), 700,700);
        sc[11] = scene11;
        scene11.getStylesheets().add(css);

        FXMLLoader edit = new FXMLLoader(HelloApplication.class.getResource("Edit.fxml"));
        Scene scene12 = new Scene(edit.load(), 700,700);
        sc[12] = scene12;
        scene12.getStylesheets().add(css);




        stage.setTitle("Los Galacticos");
        stage.setScene(sc[0]);
        stage.show();

        PauseTransition delay = new PauseTransition(Duration.seconds(3));
        delay.setOnFinished(event -> stage.setScene(sc[1]));
        delay.play();


        LoginController loginController = login.getController();
        adminController adminController = admin.getController();
        loginController.setAdminController(adminController);
        customController customController = custom.getController();
        customController.setAdminController(adminController);
        HomePageController homePageController = home.getController();
        loginController.setHomePageController(homePageController);
        CartController cartController = cart.getController();
        homePageController.setCartController(cartController);
        MenuController menuController = menu.getController();
        cartController.setMenuController(menuController);
        homePageController.setMenu(menuController);
        ReceiptController receiptController=receipt.getController();
        receiptController.setCartController(cartController);
        cartController.setReceiptController(receiptController);
        EditController editController=edit.getController();
        editController.setAdminController(adminController);
        RemoveController removeController=remove.getController();
        removeController.setAdminController(adminController);
        AnalysisController analysisController = analysis.getController();
        receiptController.setAnalysisController(analysisController);
        adminController.setAnalysisController(analysisController);


        Analysis analysis_;
        analysis_ = new Analysis();
        analysis_.setAdminController(adminController);

        //Loading Items From Files
        MenuLoader.initialize();
        system.loadUsersFromFile("user_credentials.txt");


    }

    public static void exit(){
        system.saveUserCredentials();
        stg.close();
    }

    public static void delay1sec(int i){
        PauseTransition delay = new PauseTransition(Duration.seconds(1));
        delay.setOnFinished(event -> stg.setScene(sc[i]) );
        delay.play();
    }

    public static void display(int i){
        stg.setScene(sc[i]);

    }


    public static void main(String[] args) {
        launch();
    }
}
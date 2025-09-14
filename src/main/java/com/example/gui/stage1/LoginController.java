package com.example.gui.stage1;
import com.example.gui.HelloApplication;
import com.example.gui.system;
import com.example.gui.stage2.*;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.util.Duration;


import java.io.FileNotFoundException;

public class LoginController {

    @FXML
    private Text test;
    @FXML
    private adminController adminController;
    @FXML
    private HomePageController homePageController;
    @FXML
    private PasswordField passwordBullets;
    @FXML
    private TextField passwordShown;
    @FXML
    private Text warning;
    @FXML
    private TextField mail;
    @FXML
    private CheckBox passToggle;

    public static String name;
    public static String fname;

    Font customFont = Font.loadFont(getClass().getResourceAsStream("/com/example/gui/assets/Basketball.otf"), 20);


    @FXML
    public boolean check(String usermail, String userpass){
        return system.checkCredentials(system.userList,usermail,userpass);
    }

    public void switchToSignUp(MouseEvent mouseEvent) {

        passwordBullets.setText("");
        mail.setText("");
        HelloApplication.display(2);
    }



    public void switchToSystem(ActionEvent actionEvent) throws FileNotFoundException {
        system.InitializeOwnersAccount();

        String email = mail.getText();
        String password = passwordBullets.getText();

        if (system.isOwnerAccount(email, password)) {
            int sceneValue = system.valueOfAccountscene(email,password);
            mail.setText("");
            passwordShown.setText("");
            passToggle.setSelected(false);
            passwordBullets.setText("");
            adminController.rest.setText(email);
            HelloApplication.display(9);
        }
        else if (check(email, password)) {
            name = system.userList.get(system.index).getFname() + " " + system.userList.get(system.index).getLname();
            fname = system.userList.get(system.index).getFname();
            mail.setText("");
            passToggle.setSelected(false);
            passwordBullets.setText("");
            passwordShown.setText("");
            homePageController.setHelloLabel();
            HelloApplication.display(3);
        }
        else {
            warning.setVisible(true);
            warning.setText("Entered Data is not Correct");
            PauseTransition delay = new PauseTransition(Duration.seconds(2));
            delay.setOnFinished(event -> warning.setVisible(false));
            delay.play();
        }



    }
    @FXML
    void exit(ActionEvent event) {
        HelloApplication.exit();
    }

    public void togglePasswordVisible(ActionEvent actionEvent) {

        if(passToggle.isSelected()){
            passwordShown.setText(passwordBullets.getText());
            passwordShown.setVisible(true);
            passwordBullets.setVisible(false);
            return;
        }

        passwordBullets.setText(passwordShown.getText());
        passwordBullets.setVisible(true);
        passwordShown.setVisible(false);
    }
    public void setHomePageController(HomePageController homePageController1){

        homePageController = homePageController1;

    }
    public void setAdminController(adminController adminController1){

        adminController =adminController1;

    }


}
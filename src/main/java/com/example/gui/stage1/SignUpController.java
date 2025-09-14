package com.example.gui.stage1;

import com.example.gui.*;
import com.example.gui.system;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;

public class SignUpController {

    @FXML
    private TextField add;
    @FXML
    private TextField fname;
    @FXML
    private TextField lname;
    @FXML
    private TextField mail;
    @FXML
    private TextField num;
    @FXML
    private Text fail;
    @FXML
    private PasswordField pass1;
    @FXML
    private PasswordField pass2;
    @FXML
    private Text success;
    @FXML
    public void setNull(){
        success.setText(" ");
        fail.setText(" ");
        pass1.setText("");
        pass2.setText("");
        fname.setText("");
        lname.setText("");
        mail.setText("");
        num.setText("");
        add.setText("");
    }
    @FXML
    boolean isEmpty = false;

    @FXML
    public void checkFields() {
        TextField[] textFields = {add, fname, lname, mail, num};
        for (TextField textField : textFields){
            isEmpty = textField.getText().isEmpty();
            if(isEmpty)
                break;
        }
        if(isEmpty)
        {
            fail.setText("Fill All the Fields");
        }
    }

    @FXML
    void fillData(){
        String Fname = fname.getText();
        System.out.println("Fname: " + Fname);

        String userMail = mail.getText();
        System.out.println("userMail: " + userMail);

        String userPassword = pass1.getText();
        System.out.println("userPassword: " + userPassword);

        String userName = lname.getText(); // This is redundant
        System.out.println("userName: " + userName);

        String userAddress = add.getText();
        System.out.println("userAddress: " + userAddress);

        String Phone = num.getText();
        System.out.println("Phone: " + Phone);

        User user = new User(Fname, userName, userPassword, userMail, Phone, userAddress);
        System.out.println(user);
        system.userList.add(user);
        System.out.println(system.userList);


    }


    @FXML
    void Sign_Up(ActionEvent event) throws IOException {
        checkFields();
        if (system.fakeEmail(system.userList,mail.getText())){
            fail.setText("This Email Already Exists");
            return;
        }
        if(pass1.getText().equals(pass2.getText()) ) {
            if(pass1.getText().isEmpty() || pass2.getText().isEmpty() ){
                success.setText("");
                fail.setText("");

            }

            else {
                if(isEmpty)
                {
                    checkFields();
                    return;
                }
                fillData();
                success.setText("Signed Up Successfully!!");
                fail.setText(" ");
                HelloApplication.delay1sec(1);
                PauseTransition delay = new PauseTransition(Duration.seconds(1));
                delay.setOnFinished(Event -> setNull() );
                delay.play();

            }
        }
        else {
            success.setText(" ");
            fail.setText("Passwords are not the same");
        }
    }
    @FXML
    void switchToLogin(ActionEvent event) {
        setNull();
        HelloApplication.display(1);
    }


}
package com.example.gui.stage2;

import com.example.gui.HelloApplication;
import com.example.gui.stage3.Analysis;
import com.example.gui.stage3.AnalysisController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;


public class adminController {

    @FXML
    private AnalysisController analysisController;
    @FXML
    public Text rest;
    @FXML
    public Button exit;
    @FXML
    public Button additem;

    @FXML
    public Button analysis;

    @FXML
    public Button edit;

    @FXML
    public Button remove;

    @FXML
    void additem(MouseEvent event){
        HelloApplication.display(10);}

    @FXML
    void switchToLogin(MouseEvent event) {
        HelloApplication.display(1);
    }

    @FXML
    void remove(MouseEvent event){HelloApplication.display(11);}

    @FXML
    void edit(MouseEvent event){HelloApplication.display(12);}

    @FXML
    void AnalysisScene(ActionEvent event) {
        Analysis.Main();
        analysisController.Main();


        HelloApplication.display(8);
    }

    public void setAnalysisController(AnalysisController analysisController) {
        this.analysisController = analysisController;
    }
}

module com.example.gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;
    requires java.sql;


    opens com.example.gui to javafx.fxml;
    exports com.example.gui;
    exports com.example.gui.stage1;
    opens com.example.gui.stage1 to javafx.fxml;
    exports com.example.gui.stage2;
    opens com.example.gui.stage2 to javafx.fxml;
    exports com.example.gui.stage3;
    opens com.example.gui.stage3 to javafx.fxml;
}
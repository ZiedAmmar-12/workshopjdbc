module workshopjdbc.master {

    requires java.sql;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires com.google.zxing;
    requires java.desktop;
    requires com.google.zxing.javase;
    requires javafx.swing;


    opens tn.esprit to javafx.fxml;
    opens tn.esprit.controllers to javafx.fxml;
    opens tn.esprit.models to javafx.base;
    opens tn.esprit.test to javafx.base;


    exports tn.esprit;
    exports tn.esprit.controllers;
    exports tn.esprit.models;
    exports tn.esprit.test;

}
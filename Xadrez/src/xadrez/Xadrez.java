/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package xadrez;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Usuario
 */
public class Xadrez extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/FXMLLogin.fxml"));       
        Scene scene = new Scene(root);          
        stage.setScene(scene);  
        Image image = new Image("xadrez/ImagensAuxiliares/ICON2.png");
        stage.setTitle("Xadrez Zika - O Xadrez que você conhece");
        stage.getIcons().add(image);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package xadrez;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FXMLLoginController implements Initializable {
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private TextField jogador1;
    
    @FXML
    private TextField jogador2;   
    
    @FXML
    private Button jogar;
    
    @FXML
    private Button iniciar;
    
    @FXML
    private ImageView pipa1;
    
    @FXML
    private ImageView pipa2;
      
    @FXML
    public void checaJogadores() throws Exception {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Erro");
        
        if(jogador1.getText().isEmpty() && jogador2.getText().isEmpty()){
            alerta.setContentText("Insira o nome dos jogadores!");
            alerta.show();
        }
        else if(jogador1.getText().isEmpty()){
            alerta.setContentText("Insira o nome do jogador 1!");
            alerta.show();
        }
        else if(jogador2.getText().isEmpty()){
            alerta.setContentText("Insira o nome do jogador 2!");
            alerta.show();
        }
        else{
            escreveArq(jogador1.getText());
            escreveArq(jogador2.getText());
            mudaScene();
        }
    }       
    
    @FXML
    public void botaoJogar(){
        jogador1.setVisible(true);
        jogador2.setVisible(true);
        iniciar.setVisible(true);
        jogar.setVisible(false);
    }
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(pipa1);
        translate.setDuration(Duration.millis(1000));
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.setByX(100);
        translate.setByY(-105);
        translate.setAutoReverse(true);
        translate.play();
        
        RotateTransition rotate = new RotateTransition();
        rotate.setNode(pipa1);
        rotate.setDuration(Duration.millis(2000));
        rotate.setCycleCount(TranslateTransition.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setByAngle(50);
        rotate.setAutoReverse(true);
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.play();
        
        TranslateTransition translate2 = new TranslateTransition();
        translate2.setNode(pipa2);
        translate2.setDuration(Duration.millis(1400));
        translate2.setCycleCount(TranslateTransition.INDEFINITE);
        translate2.setByX(-40);
        translate2.setByY(95);
        translate2.setAutoReverse(true);
        translate2.play();
        
        RotateTransition rotate2 = new RotateTransition();
        rotate2.setNode(pipa2);
        rotate2.setDuration(Duration.millis(1700));
        rotate2.setCycleCount(TranslateTransition.INDEFINITE);
        rotate2.setInterpolator(Interpolator.LINEAR);
        rotate2.setByAngle(-30);
        rotate2.setAutoReverse(true);
        rotate2.setAxis(Rotate.Z_AXIS);
        rotate2.play();
    }    
    
    @FXML
    public void mudaScene(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("fxml/FXMLTabuleiro.fxml"));
            stage = (Stage) iniciar.getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch(IOException e){
        }
    }
    
    public void escreveArq(String conteudo) throws IOException
    {    
        FileWriter ArquivoContas = new FileWriter("D:\\Usuario\\Documents\\PUC-Campinas\\4 semestre\\Paradigmas B\\Xadrez\\Xadrez\\src\\xadrez/ArquivoAux.txt", false);
        PrintWriter PW = new PrintWriter(ArquivoContas);
        PW.println(jogador1.getText());
        PW.println(jogador2.getText());
        PW.flush();
        PW.close();
        ArquivoContas.close();
    }   
}

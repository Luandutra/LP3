/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paineis;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class MinhaPrimeiraInterface extends Application {
    @Override
    public void start (Stage primaryStage){
        Button btn = new Button("Sou um Botão");
        Scene scene = new Scene(btn, 200, 250);
        primaryStage.setTitle("Minha Primeira Interface JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        Stage stage = new Stage();
        stage.setTitle("Nova janela");
        stage.setScene(new Scene(new Button("Mais um botão"),100, 100));
        stage.show();
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}

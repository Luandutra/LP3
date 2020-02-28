/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paineis;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class BotaoPainel extends Application{
    StackPane painel = new StackPane();

    @Override
    public void start(Stage stage) throws Exception {
        painel.getChildren().add(new Button("Clique aqui"));
        
        Scene scene = new Scene(painel, 200, 50);
        stage.setTitle("Botão dentro de um painel");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}

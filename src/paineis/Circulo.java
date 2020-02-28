/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paineis;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class Circulo extends Application{
    @Override
    public void start(Stage stage){
        Circle circle = new Circle();
        circle.setCenterX(100);//cpordenada
        circle.setCenterY(100);//coordenada
        circle.setRadius(50);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        
        Pane pane = new Pane();
        pane.getChildren().add(circle);
        
        Scene scene = new Scene(pane, 200, 200);
        stage.setTitle("Exibindo um circulo");
        stage.setScene(scene);
        stage.show();
        
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}

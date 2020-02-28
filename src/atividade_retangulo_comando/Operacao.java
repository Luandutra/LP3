/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade_retangulo_comando;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author luand
 */
public class Operacao extends Application implements Runnable{
    
   Rectangle rectPath = new Rectangle (0, 0, 40, 40);
        rectPath.setArcHeight(10); //bordas arredondadas
        rectPath.setArcWidth(10);  //bordas arredondadas
        rectPath.setFill(Color.ORANGE); //cor do quadrilátero
    
    @Override
    public void start(Stage stage) throws Exception {
       
    }
    
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}

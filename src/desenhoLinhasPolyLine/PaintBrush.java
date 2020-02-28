/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desenhoLinhasPolyLine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

/**
 *
 * @author luand
 */
public class PaintBrush extends Application {
    // Utilizaremos pontos de um polígono para o desenho da linha
    Polyline poly = new Polyline();

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Drawing lines with the Mouse");
        // Painel aonde realizaremos o desenho das linhas
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 500, 375);

        pane.getChildren().add(poly);

        // Linha só será desenhada quando o usuário clicar e arrastar com o mouse
        scene.setOnMouseDragged(e -> {
            //Adicionamos todos os pontos de movimento do mouse
            poly.getPoints().addAll(new Double[]{e.getX(), e.getY()});
        });

        //Ao liberar o botão do mouse criamos nova configuração de linha
        scene.setOnMouseReleased(e->{
            poly = new Polyline();
            //Adicionamos uma sombra à linha na cor azul
            DropShadow ds = new DropShadow();
            ds.setOffsetY(3.0);
            ds.setOffsetX(3.0);
            ds.setColor(Color.BLUE);
            poly.setEffect(ds);
            //Definimos uma espessura de linha aleatória
            poly.setStrokeWidth(Math.random()*10);
            //Adicionamos o novo objeto da linha no painel
            pane.getChildren().add(poly);
        });
        //pane.getChildren().add(tela);

        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
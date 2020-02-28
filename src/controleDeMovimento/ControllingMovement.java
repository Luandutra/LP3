/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleDeMovimento;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author luand
 */
public class ControllingMovement extends Application {
    //Retângulo que será movimentado pelo usuário
    final Rectangle rect1 = new Rectangle (0, 0, 40, 40);
    //Retângulo fixo que receberá a colisão
    final Rectangle rect2 = new Rectangle (100, 100, 40, 40);
    //Animação para sumir com o retângulo quando da colisão
    FadeTransition ft;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Controlling an object movement by the keyboard");
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 500, 375);
        
        //Capturamos qualquer evento de teclado na cena
        scene.setOnKeyPressed(evt -> {
           scene_onKeyPressed(evt);
        });

        //A animação de desaparecer dura 2 segundos
        ft = new FadeTransition(Duration.millis(2000), rect2);
        ft.setFromValue(1.0); //totalmente visível
        ft.setToValue(0);     //invisível
        ft.setCycleCount(1);  //ocorre uma única vez

        pane.getChildren().add(rect1);
        pane.getChildren().add(rect2);

        stage.setScene(scene);
        stage.show();
    }

    //Cada tecla direcional movimenta o retângulo em 5 pixels
    private void scene_onKeyPressed(KeyEvent evt) {
        if (evt.getCode() == KeyCode.RIGHT)
            rect1.setTranslateX(rect1.getTranslateX()+5);
        if (evt.getCode() == KeyCode.LEFT)
            rect1.setTranslateX(rect1.getTranslateX()-5);
        if (evt.getCode() == KeyCode.UP)
            rect1.setTranslateY(rect1.getTranslateY()-5);
        if (evt.getCode() == KeyCode.DOWN)
            rect1.setTranslateY(rect1.getTranslateY()+5);

        //Aqui detectamos a colisão
        //Verificamos se a área dos dois retângulos possui intersecção
        if (rect1.getBoundsInParent().intersects(rect2.getBoundsInParent())) {
            rect2.setFill(Color.RED); //mudamos a cor do retângulo para vermelho
            //tiramos do eixo z na posição 0 para não haver mais colisão
            rect2.setTranslateZ(-1);
            ft.play(); //damos início a animação do desaparecimento
        }
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}
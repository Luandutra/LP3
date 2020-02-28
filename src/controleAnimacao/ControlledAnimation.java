/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleAnimacao;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javax.imageio.ImageIO;

public class ControlledAnimation extends Application implements Runnable {

    //Retângulo que será animado
    final Rectangle rect = new Rectangle (0, 0, 40, 40);
    //Objeto responsável pela animação de rotação do retângulo
    RotateTransition rt;
    //Objeto que irá animar a mensagem de Pausa da animação
    ScaleTransition stBig;
    //Direção inicial do retângulo (tecla do teclado)
    KeyCode direction = KeyCode.RIGHT;
    //Objeto que representa a mensagem de pausa
    Text pause; 
    //Objeto que representa a janela da aplicação
    Stage stage;
    //Painel aonde realizaremos o desenho do retângulo
    Pane pane;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;

        //Removemos a barra de título
        stage.initStyle(StageStyle.UNDECORATED);
        //Descobrimos qual a resolução do usuário
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        pane = new Pane();

        //Criamos o objeto de rotação para o retângulo com duração de 1 segundo
        rt = new RotateTransition(Duration.millis(1000), rect);
        //A rotação será de 360 graus sentido horário
        rt.setByAngle(360);
        //A velocidade da rotação será igual do início ao fim
        rt.setInterpolator(Interpolator.LINEAR);
        //A rotação estará sempre ocorrendo
        rt.setCycleCount(Timeline.INDEFINITE);
        //Não é permitido rotacionar invertido ao final da animação
        rt.setAutoReverse(false);

        //Criamos o texto da pausa sendo metade do tamanho da tela
        pause = new Text(screenSize.getWidth()/2, screenSize.getHeight()/2, "Paused");
        //O texto será de cor vermelha
        pause.setFill(Color.RED);
        //Inicialmente o texto não é visível
        pause.setVisible(false);
        //Criamos o objeto responsável pela animação do texto com duração de 1 segundo
        stBig = new ScaleTransition(Duration.millis(1000), pause);
        stBig.setFromX(0);
        stBig.setFromY(0);
        stBig.setToX(10);
        stBig.setToY(20);

        pane.getChildren().addAll(rect,pause);
        //Definimos o tamanho da cena como sendo o tamanho total da resolução do usuário
        Scene scene = new Scene(pane,screenSize.getWidth(),screenSize.getHeight());

        //Capturamos qualquer evento de teclado que ocorrer na aplicação
        scene.setOnKeyPressed(e ->{
            scene_onKeyPressed(e);
        });

        stage.setScene(scene);
        stage.show();

        //Criamos a thread que irá movimentar o retângulo e damos início
        Thread t = new Thread(this);
        t.setDaemon(true);
        t.start();
        rt.play();
    }

    private void scene_onKeyPressed(KeyEvent e) {
        direction = e.getCode();
        switch(direction) {
            case RIGHT:
                if (pause.isVisible()) pause.setVisible(false);
                rt.stop(); rt.setByAngle(360); rt.play();
                break;
            case LEFT:
                if (pause.isVisible()) pause.setVisible(false);
                rt.stop(); rt.setByAngle(-360); rt.play();
                break;
            case UP:
                if (pause.isVisible()) pause.setVisible(false);
                rt.stop(); rt.setByAngle(-360); rt.play();
                break;
            case DOWN:
                if (pause.isVisible()) pause.setVisible(false);
                rt.stop(); rt.setByAngle(360); rt.play();
                break;
            case ESCAPE:
                //A tecla ESC encerra a aplicação
                System.exit(0);
            default:
                //Qualquer outra tecla pausa a animação
                rt.stop();
                pause.setVisible(true);
                stBig.play();    
                break;
        }  
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            switch(direction) {
                case RIGHT:
                    if (rect.getTranslateX()>stage.getWidth()+40)
                        rect.setTranslateX(-35);
                        rect.setTranslateX(rect.getTranslateX()+5);
                        break;
                case LEFT:
                    if (rect.getTranslateX()<0-40)
                        rect.setTranslateX(stage.getWidth()+40);
                        rect.setTranslateX(rect.getTranslateX()-5);
                        break;
                case UP:
                    if (rect.getTranslateY()<0-40)
                        rect.setTranslateY(stage.getHeight()+40);
                        rect.setTranslateY(rect.getTranslateY()-5);
                        break;
                case DOWN:
                    if (rect.getTranslateY()>stage.getHeight()+40)
                        rect.setTranslateY(-35);
                        rect.setTranslateY(rect.getTranslateY()+5);
                        break;
                case P:
                    //A tecla P tira uma foto da aplicação e salva
                    saveAsPng();
                    break;
                default:
                    break;
            }
        }
    }

    /*
    * Tira uma foto do painel e salva em um arquivo game.png 
    */
    public void saveAsPng() {
        WritableImage image = pane.snapshot(new SnapshotParameters(), null);

        File file = new File("game.png");

        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}

package animandoShape;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class AnimatedCircle extends Application implements Runnable{
    
    Circle circle = new Circle(40);
    Stage stage;
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        Pane pane = new Pane();
        circle.setCenterX(40);
        circle.setCenterY(40);
        pane.getChildren().add(circle);
        Scene scene = new Scene(pane,800,600);
        stage.setScene(scene);
        stage.show();
        Thread t = new Thread(this);
        t.setDaemon(true);
        t.start();
    }
    @Override
    public void run() {
        boolean forward = true;
        while (true) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (circle.getTranslateX()>=stage.getWidth()-80) forward=false;
            if (circle.getTranslateX()<=0) forward=true;
            if (forward)
                circle.setTranslateX(circle.getTranslateX()+5);
            else
                circle.setTranslateX(circle.getTranslateX()-5);
        }
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}

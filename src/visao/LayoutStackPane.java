package visao;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class LayoutStackPane extends Application{
    @Override
    public void start(Stage primary){
        StackPane stackPane = new StackPane();
        stackPane.setPadding(new Insets(20));
        Rectangle r1 = new Rectangle(300, 300);
        r1.setFill(Color.RED);
        Rectangle r2 = new Rectangle(200, 200);
        r2.setFill(Color.BLUE);
        Rectangle r3 = new Rectangle(100, 100);
        r3.setFill(Color.AQUA);
        Rectangle r4 = new Rectangle(50, 50);
        r4.setFill(Color.BROWN);
        stackPane.getChildren().addAll(r1, r2, r3, r4);
        
        Scene cena = new Scene(stackPane);
        primary.setScene(cena);
        primary.setTitle("Gerenciador de Layout StackPane");
        primary.show();
    }
    public static void main(String[] args) {
        LayoutStackPane.launch(args);
    }
    
}
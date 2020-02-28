package visao;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class LayoutAnchorPane extends Application{
    @Override
    public void start(Stage hs){
        AnchorPane anchorPane = new AnchorPane();
        Rectangle r1 = new Rectangle(150, 60);
        r1.setFill(Color.RED);
        Rectangle r2 = new Rectangle(150, 60);
        r2.setFill(Color.BLUE);
        Rectangle r3 = new Rectangle(150, 60);
        r3.setFill(Color.CHARTREUSE);
        Rectangle r4 = new Rectangle(150, 60);
        r4.setFill(Color.BROWN);
        Rectangle r5 = new Rectangle(150, 60);
        
        AnchorPane.setTopAnchor(r1, 20.0);
        AnchorPane.setTopAnchor(r2, 40.0);
        AnchorPane.setTopAnchor(r2, 160.0);
        AnchorPane.setTopAnchor(r3, 30.0);
        AnchorPane.setTopAnchor(r4, 20.0);
        AnchorPane.setTopAnchor(r5, 100.0);
        
        anchorPane.getChildren().addAll(r1, r2, r3, r4, r5);
        Scene cena = new Scene(anchorPane, 500, 300);
        hs.setScene(cena);
        hs.setTitle("Gerenciador de Layout AnchorPane");
        hs.show();
    }
    public static void main(String[] args) {
        LayoutAnchorPane.launch(args);
    }
}
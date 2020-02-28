package visao;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class LayoutVBox extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception{
        
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));
        Rectangle r1 = new Rectangle(50, 50);
        Rectangle r2 = new Rectangle(100, 100);
        Rectangle r3 = new Rectangle(25, 100);
        Rectangle r4 = new Rectangle(250, 50);
        VBox.setMargin(r1, new Insets(10, 10, 10, 10));
        vbox.getChildren().addAll(r1, r2, r3, r4);

        Scene cena = new Scene(vbox);
        primaryStage.setScene(cena);
        primaryStage.setTitle("Gerenciador de Layout VBox");
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        LayoutVBox.launch(args);
    }   
}
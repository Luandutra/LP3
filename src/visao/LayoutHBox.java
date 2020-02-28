package visao;
import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class LayoutHBox extends Application{
    @Override
    public void start(Stage Henrique){
        HBox hbox = new HBox(15);
        hbox.setPadding(new Insets(20));
        Rectangle r1 = new Rectangle(100, 100);
        Rectangle r2 = new Rectangle(200, 200);
        Rectangle r3 = new Rectangle(50, 200);
        Rectangle r4 = new Rectangle(200, 50);
        HBox.setMargin(r1, new Insets(10, 10, 10, 10));
        hbox.getChildren().addAll(r1, r2, r3, r4);
        
        Scene cena = new Scene(hbox);
        Henrique.setScene(cena);
        Henrique.setTitle("Gerenciador de Layout HBox");
        Henrique.show();
    }
    
    public static void main(String[] args) {
        LayoutHBox.launch(args);
    }
}

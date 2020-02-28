package visao;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Aplicacao02 extends Application{
    @Override
    public void start(Stage primaryKey) throws Exception{
        AnchorPane painel = new AnchorPane();
        
        Label label1 = new Label();
        label1.setText("Texto do Label");
        label1.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        AnchorPane.setTopAnchor(label1, 1.0);
        AnchorPane.setBottomAnchor(label1, 20.0);
        painel.getChildren().add(label1);
        
        Scene cena = new Scene(painel, 300, 200);
        primaryKey.setTitle("Aplicacao02");
        primaryKey.setScene(cena);
        primaryKey.show();
    }
    
    public static void main(String[] args) {
        Aplicacao02.launch(args);
    }
    
}

package visao;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Aplicacao01 extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane painel = new AnchorPane();
        Scene cena = new Scene(painel, 400, 200);
        primaryStage.setScene(cena);
        primaryStage.setTitle("Titulo da Aplicação1");
        primaryStage.show();
    }
    
    public static void main(String[] args){
        Aplicacao01.launch(args);
       
    }    
}
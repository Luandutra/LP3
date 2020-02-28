package visao;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class LayoutFlowPane extends Application{
    @Override
    public void start(Stage primaryKey){
        FlowPane flowPane = new FlowPane(Orientation.VERTICAL);//fluxo de distribuição
        flowPane.setAlignment(Pos.TOP_LEFT);
        flowPane.setPadding(new Insets(20));
        Rectangle r1 = new Rectangle(50, 50);//quadrado 1
        r1.setFill(Color.RED);
        Rectangle r2 = new Rectangle(150, 60);//retangulo vertical
        r2.setFill(Color.BLUE);
        Rectangle r3 = new Rectangle(250, 50);
        r3.setFill(Color.AQUA);
        Rectangle r4 = new Rectangle(250, 50);
        FlowPane.setMargin(r1, new Insets(10, 10, 10, 10));
        flowPane.getChildren().addAll(r1, r2, r3, r4);
        
        Scene cena = new Scene(flowPane);
        primaryKey.setScene(cena);
        primaryKey.setTitle("Gerenciador de Layout FlowPane");
        primaryKey.show();
    }
    public static void main(String[] args) {
        LayoutFlowPane.launch(args);
    }
}
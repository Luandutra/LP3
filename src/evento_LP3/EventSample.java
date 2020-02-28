
package evento_LP3;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class EventSample extends Application {
    Button btn;
    Label lbl;
    @Override
    public void start(Stage stage) throws Exception {
        //Título da janela
        stage.setTitle("Event Sample");
        FlowPane pane = new FlowPane();
        //Tamanho da janela
        Scene scene = new Scene(pane, 500, 375);  

        //Criação de um botão
        btn = new Button("OK");
        //Criação do label para exibir resultados
        lbl = new Label("");

        //Registrando o método que irá tratar quando o botão for pressionado
        btn.setOnAction(e->{
            btn_onAction(e);
        });

        //Registrando o método que irá tratar quando o mouse entrar na área gráfica do botão
        btn.setOnMouseEntered(e->{
            btn_onMouseEntered(e);
        });

        //Registrando o método que irá tratar quando o mouse sair da área gráfica do botão
        btn.setOnMouseExited(e->{
            btn_onMouseExited(e);
        });

        //Registrando o método que irá tratar quando houver um clique do mouse sobre o botão
        btn.setOnMouseClicked(e->{
            btn_onMouseClicked(e);
        });

        //Registrando o método que irá tratar quando alguma tecla for pressionada na janela ativa
        scene.setOnKeyPressed(e->{
            scene_onKeyPressed(e);
        });

        pane.getChildren().add(btn);
        pane.getChildren().add(lbl);

        stage.setScene(scene);
        stage.show();
    }

    private void scene_onKeyPressed(KeyEvent e) {
        System.out.println(e.getCode());
        if (e.getCode() == KeyCode.ENTER){
            lbl.setText("Enter Pressed!");
        }
    }

    private void btn_onMouseClicked(MouseEvent e) {
        lbl.setText(e.getClickCount() + " - " + e.getButton());
    }

    private void btn_onMouseExited(MouseEvent e) {
        btn.setText("Adeus Mouse!");
    }

    private void btn_onMouseEntered(MouseEvent e) {
        btn.setText("Mouse na Área");
    }

    protected void btn_onAction(ActionEvent event) {
        lbl.setText("Botao clicado");
    }
    
     public static void main(String[] args) {
        Application.launch(args);
    }
}
package arcoiris;
//Página 224 Deitel 8° edição
import javax.swing.JFrame;

public class DesenharArcoIris {
    public static void main(String[] args) {
        ClasseDesenharArcoIris panel = new ClasseDesenharArcoIris();
        JFrame application = new JFrame();
        
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel);
        application.setSize(400, 250);
        application.setVisible(true);
    }
    
}

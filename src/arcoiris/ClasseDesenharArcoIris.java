package arcoiris;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class ClasseDesenharArcoIris extends JPanel{
    //define as cores indigo e violeta
    private final static Color VIOLET = new Color(128, 0, 128);
    private final static Color INDIGO = new Color(75, 0, 130);
    
    //a utilizar no arco-iris iniciando da parte mais interna
    //as duas entradas em branco resultam em um arco vazio no centro
    private Color[] colors = {Color.WHITE, Color.WHITE, VIOLET, INDIGO, Color.BLUE,
    Color.GREEN, Color.YELLOW, Color.ORANGE, Color.RED};
    
    //construtor
    public ClasseDesenharArcoIris(){
        setBackground( Color.WHITE);//configura oo fundo como branco
    }
    
    //desenha o arco-iris utilizando arcos concêntricos
    public void paintComponent( Graphics g){
        super.paintComponent(g);
        int radius = 20; //raios de um arco
        
        //desenha o arco-íris perto da parte central inferior
        int centerX = getWidth()/2;
        int centerY = getWidth()-10;
        
        //desenha arcos preenchidos com o mais externo
        for(int counter = colors.length; counter > 0; counter--){
            //configura a cor para o arco atual
            g.setColor( colors[ counter -1] );
            
            //configura o arco de 0 a 180 graus
            g.fillArc(centerX - counter * radius, centerY - counter * radius, counter * radius * 2, counter * radius *2,
                    0, 180);
        }
    }
}
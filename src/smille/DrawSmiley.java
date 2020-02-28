package smille;

import javax.swing.JFrame;

public class DrawSmiley
{
   public static void main( String[] args )
   {
      DesenhoComponente painel = new DesenhoComponente();      
      JFrame aplicacao = new JFrame();
      aplicacao.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      
      aplicacao.add( painel );
      aplicacao.setSize( 230, 250 );      
      aplicacao.setVisible( true );
   }
} 
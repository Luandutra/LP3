/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notaAluno;

import java.util.Scanner;
import javax.swing.JOptionPane;


public class Main {

    static float nota(float notax) {
        Scanner leia = new Scanner(System.in);
        String s1;
        
        while (notax < 0 || notax > 10) {
            s1 = JOptionPane.showInputDialog("Erro Digite uma nota entre 0 e 10");
            notax = Float.parseFloat(s1);
            System.exit(0);
            
            //System.out.print("EROO ! Digite uma nota entre 0 e 10: ");
            //notax = (leia.nextFloat());
        }
        return notax;
    }

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        String nome, s1, s2, s3, s4;
        
        ClasseNotaAluno1 aluno = new ClasseNotaAluno1();
        
        /*
        System.out.print("Digite o nome do aluno: ");
        aluno.setNome(leia.next());
               
        
        System.out.print("Digite a [1°] nota do aluno(a): " + aluno.getNome() + " = ");
        float nota1 = nota(leia.nextFloat());
        aluno.setN1(nota1);
        /*ou
        aluno.setN1(nota(leia.nextFloat()));
        
        System.out.print("Digite a [2°] nota do aluno(a): " + aluno.getNome() + " = ");
        float nota2 = nota(leia.nextFloat());
        aluno.setN2(nota2);
        
        System.out.print("Digite a [3°] nota do aluno(a): " + aluno.getNome() + " = ");
        float nota3 = nota(leia.nextFloat());
        aluno.setN3(nota3);

        System.out.print("Digite a [4°] nota do aluno(a): " + aluno.getNome() + " = ");
        float nota4 = nota(leia.nextFloat());
        aluno.setN4(nota4);


        aluno.status();
        aluno.mediaSemestral();*/
        
        nome = JOptionPane.showInputDialog("Digite o nome do aluno");
        
        s1 = JOptionPane.showInputDialog("Digite a 1° nota");
        s2 = JOptionPane.showInputDialog("Digite a 2° nota");
        s3 = JOptionPane.showInputDialog("Digite a 3° nota");
        s4 = JOptionPane.showInputDialog("Digite a 4° nota");
        
        float n  = Integer.parseInt(nome);
        float n1 = Integer.parseInt(s1);
        float n2 = Integer.parseInt(s2);
        float n3 = Integer.parseInt(s3);
        float n4 = Integer.parseInt(s4);
        
        System.exit(0);
    }
}
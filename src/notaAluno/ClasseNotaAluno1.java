/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notaAluno;
import java.util.Scanner;

public class ClasseNotaAluno1 {
    Scanner leia = new Scanner(System.in);
    
    private String nome;
    private int matricula;
    private float n1, n2, n3, n4;
    private float mediaFinal, notaPF;
        
    public void Aluno(String nome, int matricula){
        System.out.println("Metodo Aluno: String nome; int matricula");
        this.nome = nome;
        this.matricula = matricula;
    }
    public float mediaSemestral(){
        mediaFinal = (n1 + n2 + n3 + n4) /4;
        System.out.print("\nMÉDIA SEMESTRAL = "+mediaFinal);
        if(mediaFinal >= 6){
            System.out.println(" Aprovado(a)");
        }else if(mediaFinal > 1 && mediaFinal < 6){
            System.out.println("  Aluno(a) de recuperação !");
            calcMediaComPF();
        }else{
            System.out.println("  Reprovado(a)");
        }
        
        return mediaFinal;
    }
    public float calcMediaComPF(){
        System.out.print("\nDigite a nota da PF: ");
        notaPF = leia.nextFloat();
        if(notaPF < 0 || notaPF > 10){
            while(notaPF < 0 || notaPF > 10){
                System.out.println("Erro ! DIGITE UMA NOTA VÁLIDA ENTRE 0 E 10");
                notaPF = leia.nextFloat();
            }
        }
        
        float notaFinal = (notaPF + mediaFinal)/2;
        if(notaFinal >= 5){
            System.out.println("Média finaL = "+notaFinal+" Aprovado(a)");
        }else{
            System.out.println("Aluno(a) "+nome+" nota final = "+notaFinal+" reprovado(a)");
        }
        return notaFinal;
    }
    public void status(){
        System.out.println("\n______Status do aluno(a)_______");
        System.out.print("Aluno(a): "+nome);
        System.out.print("\nNota1 = "+n1+"\nNota2 = "+n2+
                "\nNota3 = "+n3+"\nNota4 = "+n4);
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setN1(float n1){
        this.n1 = n1;
    }
    public void setN2(float n2){
        this.n2 = n2;
    }
    public void setN3(float n3){
        this.n3 = n3;
    }
    public void setN4(float n4){
        this.n4 = n4;
    }
    public void setMediaFinal(float mediaFinal){
        this.mediaFinal = mediaFinal;
    }
    public void setNotaPF(float notaPF){
        this.notaPF = notaPF;
    }
        
    public String getNome(){
        return nome;
    }
    public float getN1(){
        return n1;
    }
    public float getN2(){
        return n2;
    }
    public float getN3(){
        return n3;
    }
    public float getN4(){
        return n4;
    }
    public float getMediaFinal(){
        return mediaFinal;
    }
    public float getNotaPF(){
        return notaPF;
    }
    
}
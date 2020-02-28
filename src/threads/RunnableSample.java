/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

/**
 *
 * @author HENRIQUE
 */
public class RunnableSample implements Runnable{
    public void run(){
        for(int i=0; i < 1000; i++){
            System.out.print("X");
        }
    }
    
}

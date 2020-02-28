/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import threads.PrintThread;

/**
 *
 * @author HENRIQUE
 */
public class DaemonPrintThreadTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PrintThread pt = new PrintThread("O");
        Thread t = new Thread(pt);
        t.setDaemon(true);
        
        t.start();
    }
    
}

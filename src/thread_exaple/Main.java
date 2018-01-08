
package thread_exaple;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    public static void main(String arg[]) {
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        Thread_exaple t= new Thread_exaple(Thread.NORM_PRIORITY+2);
        Thread_exaple r = new Thread_exaple(Thread.NORM_PRIORITY-2);
        t.start();
        r.start();
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        t.stop();
        r.stop();
        
        try {
            t.t.join();
            r.t.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Low "+r.click);
        System.out.println("High "+t.click);      
    }    
}
